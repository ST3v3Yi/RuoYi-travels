package com.ruoyi.travels.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.travels.domain.RoomFacility;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.travels.domain.RoomFacilities;
import com.ruoyi.travels.service.IRoomFacilitiesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 房间设施Controller
 * 
 * @author Yifun
 * @date 2023-04-28
 */
@RestController
@RequestMapping("/travels/roomFacilities")
public class RoomFacilitiesController extends BaseController
{
    @Autowired
    private IRoomFacilitiesService roomFacilitiesService;

    /**
     * 查询房间设施列表
     */
    @PreAuthorize("@ss.hasPermi('travels:roomFacilities:list')")
    @GetMapping("/list")
    public TableDataInfo list(RoomFacilities roomFacilities)
    {
        startPage();
        List<RoomFacilities> list = roomFacilitiesService.selectRoomFacilitiesList(roomFacilities);
        return getDataTable(list);
    }

    /**
     * 导出房间设施列表
     */
    @PreAuthorize("@ss.hasPermi('travels:roomFacilities:export')")
    @Log(title = "房间设施", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RoomFacilities roomFacilities)
    {
        List<RoomFacilities> list = roomFacilitiesService.selectRoomFacilitiesList(roomFacilities);
        ExcelUtil<RoomFacilities> util = new ExcelUtil<RoomFacilities>(RoomFacilities.class);
        util.exportExcel(response, list, "房间设施数据");
    }

    /**
     * 获取房间设施详细信息
     */
    @PreAuthorize("@ss.hasPermi('travels:roomFacilities:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(roomFacilitiesService.selectRoomFacilitiesById(id));
    }

    /**
     * 获取相应房间的设施信息
     */
    @GetMapping(value = "/roomId/{roomId}")
    public AjaxResult getRoomFacilities(@PathVariable("roomId") Long roomId)
    {
        return success(roomFacilitiesService.selectRoomFacilitiesByRoomId(roomId));
    }

    /**
     * 新增房间设施
     */
    @PreAuthorize("@ss.hasPermi('travels:roomFacilities:add')")
    @Log(title = "房间设施", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RoomFacilities roomFacilities)
    {
        return toAjax(roomFacilitiesService.insertRoomFacilities(roomFacilities));
    }

    /**
     * 修改房间设施
     */
    @PreAuthorize("@ss.hasPermi('travels:roomFacilities:edit')")
    @Log(title = "房间设施", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RoomFacilities roomFacilities)
    {
        return toAjax(roomFacilitiesService.updateRoomFacilities(roomFacilities));
    }

    /**
     * 删除房间设施
     */
    @PreAuthorize("@ss.hasPermi('travels:roomFacilities:remove')")
    @Log(title = "房间设施", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(roomFacilitiesService.deleteRoomFacilitiesByIds(ids));
    }
}
