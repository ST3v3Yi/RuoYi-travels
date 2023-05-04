package com.ruoyi.travels.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.travels.domain.HotelRooms;
import com.ruoyi.travels.domain.RoomCriteria;
import com.ruoyi.travels.service.IHotelRoomsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 酒店房间Controller
 *
 * @author Yifun
 * @date 2023-04-29
 */
@RestController
@RequestMapping("/travels/rooms")
public class HotelRoomsController extends BaseController
{
    @Autowired
    private IHotelRoomsService hotelRoomsService;

    /**
     * 查询酒店房间列表
     */
    @PreAuthorize("@ss.hasPermi('travels:rooms:list')")
    @GetMapping("/list")
    public TableDataInfo list(HotelRooms hotelRooms)
    {
        startPage();
        List<HotelRooms> list = hotelRoomsService.selectHotelRoomsList(hotelRooms);
        return getDataTable(list);
    }

    /**
     * 获取相应酒店的房间信息
     * @return
     */
    @PreAuthorize("@ss.hasPermi('travels:rooms:list')")
    @GetMapping(value = "/hotel/{hotelId}")
    public AjaxResult getHotelRooms(@PathVariable("hotelId") Long hotelId)
    {
        return success(hotelRoomsService.selectHotelRoomsByHotelId(hotelId));
    }

    /**
     * 获取相应酒店的最低价格
     * @return
     */
    @PreAuthorize("@ss.hasPermi('travels:rooms:query')")
    @GetMapping(value = "/price/{hotelId}")
    public AjaxResult getMinPrice(@PathVariable("hotelId") Long hotelId)
    {
        return success(hotelRoomsService.selectHotelMinPriceByHotelId(hotelId));
    }

    /**
     * 获取具有对应房型的酒店ID
     */
    @PreAuthorize("@ss.hasPermi('travels:rooms:query')")
    @GetMapping(value = "/room/{type}")
    public AjaxResult getHotelId(@PathVariable("type") Long type)
    {
        return success(hotelRoomsService.selectHotelIdByRoomType(type));
    }

    /**
     * 获取可行的Hotel ID
     * 所谓可行是指可以符合筛选器中对于[房间数, 人数]要求的酒店
     *
     * 使用贪心算法，不求最优解，只求可行性
     *
     */
    @PreAuthorize("@ss.hasPermi('travels:rooms:query')")
    @PostMapping(value = "/feasibility")
    public AjaxResult getHotelIdList(@RequestBody RoomCriteria roomCriteria)
    {
        List<Long> Ids = new ArrayList<>(); // 定义一个Long数组用于保存可行的Hotel Id
        // 第一步：获取所有的HotelId，并将其放置在HotelIds数组中
        List<Long> hotelIds = hotelRoomsService.selectAllHotelId();
        for (Long hotelId : hotelIds) {
        // 第二步：依次查询对应hotel的room信息，并根据room的number大小进行排序【从大到小】
            System.out.println("对于酒店 Hotel Id= " + hotelId);
            // 查询该酒店下的所有房间信息
            List<HotelRooms> rooms = hotelRoomsService.selectHotelRoomsByHotelId(hotelId);
            System.out.println("该酒店共有：" + rooms.size() + "个房间");
            Boolean flag = false;
            // 根据房间的容纳人数进行排序
            Collections.sort(rooms, new Comparator<HotelRooms>() {
                @Override
                public int compare(HotelRooms r1, HotelRooms r2) {
                    return (int) (r2.getNumber() - r1.getNumber());
                }
            });
        // 第三步：通过贪心算法判定酒店是否可行
            // 根据 roomCriteria.getRoomNumber() 和 roomCriteria.getPeopleNumber() 获取前端的筛选条件
            Long roomNumber = roomCriteria.getRoomNumber();
            Long peopleNumber = roomCriteria.getPeopleNumber();
            System.out.println("而前端传回的需求分别为 => 房间数为：" + roomNumber + "， 人数为：" + peopleNumber);
            for (HotelRooms room : rooms) {
                System.out.println("对于酒店 Hotel Id=" + hotelId + " 的房间”" + room.getRoomName() + "“而言");
                System.out.println("其房间剩余数为：" + room.getCounts() + "，房间容纳人数为：" + room.getNumber());
                Long minNumber = Math.min(roomNumber, room.getCounts());
                System.out.println("在同需求房间数比较后，得到最小房间数为：" + minNumber);
                if (minNumber * room.getNumber() >= peopleNumber) {
                    System.out.println("条件一成立，该酒店可行！");
                    flag = true;
                    break;
                } else if (minNumber.equals(roomNumber)) {
                    System.out.println("条件二成立，该酒店不可行！");
                    break;
                } else {
                    roomNumber = roomNumber - minNumber;
                    peopleNumber = peopleNumber - minNumber * room.getNumber();
                    System.out.println("条件三成立，剩余需求房间数为：" + roomNumber + "，剩余需求人数为：" + peopleNumber);
                    continue;
                }
            }
            if (flag) {
                Ids.add(hotelId);
            }
        }
        System.out.println("Ids: " + Ids);
        return success(Ids);
    }

    /**
     * 导出酒店房间列表
     */
    @PreAuthorize("@ss.hasPermi('travels:rooms:export')")
    @Log(title = "酒店房间", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HotelRooms hotelRooms)
    {
        List<HotelRooms> list = hotelRoomsService.selectHotelRoomsList(hotelRooms);
        ExcelUtil<HotelRooms> util = new ExcelUtil<HotelRooms>(HotelRooms.class);
        util.exportExcel(response, list, "酒店房间数据");
    }

    /**
     * 获取酒店房间详细信息
     */
    @PreAuthorize("@ss.hasPermi('travels:rooms:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(hotelRoomsService.selectHotelRoomsById(id));
    }

    /**
     * 新增酒店房间
     */
    @PreAuthorize("@ss.hasPermi('travels:rooms:add')")
    @Log(title = "酒店房间", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HotelRooms hotelRooms)
    {
        return toAjax(hotelRoomsService.insertHotelRooms(hotelRooms));
    }

    /**
     * 修改酒店房间
     */
    @PreAuthorize("@ss.hasPermi('travels:rooms:edit')")
    @Log(title = "酒店房间", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HotelRooms hotelRooms)
    {
        return toAjax(hotelRoomsService.updateHotelRooms(hotelRooms));
    }

    /**
     * 删除酒店房间
     */
    @PreAuthorize("@ss.hasPermi('travels:rooms:remove')")
    @Log(title = "酒店房间", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hotelRoomsService.deleteHotelRoomsByIds(ids));
    }
}
