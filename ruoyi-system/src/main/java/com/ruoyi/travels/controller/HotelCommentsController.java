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
import com.ruoyi.travels.domain.HotelComments;
import com.ruoyi.travels.service.IHotelCommentsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 酒店点评Controller
 * 
 * @author Yifun
 * @date 2023-05-01
 */
@RestController
@RequestMapping("/hotel/hotelComments")
public class HotelCommentsController extends BaseController
{
    @Autowired
    private IHotelCommentsService hotelCommentsService;

    /**
     * 查询酒店点评列表
     */
    @PreAuthorize("@ss.hasPermi('hotel:hotelComments:list')")
    @GetMapping("/list")
    public TableDataInfo list(HotelComments hotelComments)
    {
        startPage();
        List<HotelComments> list = hotelCommentsService.selectHotelCommentsList(hotelComments);
        return getDataTable(list);
    }

    /**
     * 导出酒店点评列表
     */
    @PreAuthorize("@ss.hasPermi('hotel:hotelComments:export')")
    @Log(title = "酒店点评", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HotelComments hotelComments)
    {
        List<HotelComments> list = hotelCommentsService.selectHotelCommentsList(hotelComments);
        ExcelUtil<HotelComments> util = new ExcelUtil<HotelComments>(HotelComments.class);
        util.exportExcel(response, list, "酒店点评数据");
    }

    /**
     * 获取酒店点评详细信息
     */
    @PreAuthorize("@ss.hasPermi('hotel:hotelComments:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(hotelCommentsService.selectHotelCommentsById(id));
    }

    /**
     * 获取酒店点评列表
     */
    @PreAuthorize("@ss.hasPermi('hotel:hotelComments:list')")
    @GetMapping(value = "/hotel/{hotelId}")
    public AjaxResult getCommentsList(@PathVariable("hotelId") Long hotelId)
    {
        return success(hotelCommentsService.selectHotelCommentsByHotelId(hotelId));
    }

    /**
     * 获取酒店评分
     */
    @PreAuthorize("@ss.hasPermi('hotel:hotelComments:query')")
    @GetMapping(value = "/rating/{hotelId}")
    public AjaxResult getRating(@PathVariable("hotelId") Long hotelId)
    {
        return success(hotelCommentsService.selectHotelRatingByHotelId(hotelId));
    }

    /**
     * 新增酒店点评
     */
    @PreAuthorize("@ss.hasPermi('hotel:hotelComments:add')")
    @Log(title = "酒店点评", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HotelComments hotelComments)
    {
        return toAjax(hotelCommentsService.insertHotelComments(hotelComments));
    }

    /**
     * 修改酒店点评
     */
    @PreAuthorize("@ss.hasPermi('hotel:hotelComments:edit')")
    @Log(title = "酒店点评", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HotelComments hotelComments)
    {
        return toAjax(hotelCommentsService.updateHotelComments(hotelComments));
    }

    /**
     * 删除酒店点评
     */
    @PreAuthorize("@ss.hasPermi('hotel:hotelComments:remove')")
    @Log(title = "酒店点评", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hotelCommentsService.deleteHotelCommentsByIds(ids));
    }
}
