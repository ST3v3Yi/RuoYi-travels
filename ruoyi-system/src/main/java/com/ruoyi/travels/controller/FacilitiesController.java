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
import com.ruoyi.travels.domain.Facilities;
import com.ruoyi.travels.service.IFacilitiesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设施Controller
 * 
 * @author Yifun
 * @date 2023-04-28
 */
@RestController
@RequestMapping("/travels/facilities")
public class FacilitiesController extends BaseController
{
    @Autowired
    private IFacilitiesService facilitiesService;

    /**
     * 查询设施列表
     */
    @PreAuthorize("@ss.hasPermi('travels:facilities:list')")
    @GetMapping("/list")
    public TableDataInfo list(Facilities facilities)
    {
        startPage();
        List<Facilities> list = facilitiesService.selectFacilitiesList(facilities);
        return getDataTable(list);
    }

    /**
     * 导出设施列表
     */
    @PreAuthorize("@ss.hasPermi('travels:facilities:export')")
    @Log(title = "设施", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Facilities facilities)
    {
        List<Facilities> list = facilitiesService.selectFacilitiesList(facilities);
        ExcelUtil<Facilities> util = new ExcelUtil<Facilities>(Facilities.class);
        util.exportExcel(response, list, "设施数据");
    }

    /**
     * 获取设施详细信息
     */
    @PreAuthorize("@ss.hasPermi('travels:facilities:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(facilitiesService.selectFacilitiesById(id));
    }

    /**
     * 新增设施
     */
    @PreAuthorize("@ss.hasPermi('travels:facilities:add')")
    @Log(title = "设施", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Facilities facilities)
    {
        return toAjax(facilitiesService.insertFacilities(facilities));
    }

    /**
     * 修改设施
     */
    @PreAuthorize("@ss.hasPermi('travels:facilities:edit')")
    @Log(title = "设施", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Facilities facilities)
    {
        return toAjax(facilitiesService.updateFacilities(facilities));
    }

    /**
     * 删除设施
     */
    @PreAuthorize("@ss.hasPermi('travels:facilities:remove')")
    @Log(title = "设施", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(facilitiesService.deleteFacilitiesByIds(ids));
    }
}
