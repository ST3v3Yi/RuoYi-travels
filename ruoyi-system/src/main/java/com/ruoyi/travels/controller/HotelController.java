package com.ruoyi.travels.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.travels.domain.Hotel;
import com.ruoyi.travels.service.IHotelService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 酒店管理Controller
 * 
 * @author Yifun
 * @date 2023-04-22
 */
@RestController
@RequestMapping("/hotel/hotel")
public class HotelController extends BaseController
{
    @Autowired
    private IHotelService hotelService;

    /**
     * 查询酒店管理列表
     */
    @PreAuthorize("@ss.hasPermi('hotel:hotel:list')")
    @GetMapping("/list")
    public TableDataInfo list(Hotel hotel)
    {
        startPage();
        List<Hotel> list = hotelService.selectHotelList(hotel);
        return getDataTable(list);
    }

    /**
     * 导出酒店管理列表
     */
    @PreAuthorize("@ss.hasPermi('hotel:hotel:export')")
    @Log(title = "酒店管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Hotel hotel)
    {
        List<Hotel> list = hotelService.selectHotelList(hotel);
        ExcelUtil<Hotel> util = new ExcelUtil<Hotel>(Hotel.class);
        util.exportExcel(response, list, "酒店管理数据");
    }

    /**
     * 获取酒店管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('hotel:hotel:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(hotelService.selectHotelById(id));
    }

    /**
     * 新增酒店管理
     */
    @PreAuthorize("@ss.hasPermi('hotel:hotel:add')")
    @Log(title = "酒店管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Hotel hotel)
    {
        return toAjax(hotelService.insertHotel(hotel));
    }

    /**
     * 修改酒店管理
     */
    @PreAuthorize("@ss.hasPermi('hotel:hotel:edit')")
    @Log(title = "酒店管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Hotel hotel)
    {
        return toAjax(hotelService.updateHotel(hotel));
    }

    /**
     * 删除酒店管理
     */
    @PreAuthorize("@ss.hasPermi('hotel:hotel:remove')")
    @Log(title = "酒店管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hotelService.deleteHotelByIds(ids));
    }
}
