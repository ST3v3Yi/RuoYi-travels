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
import com.ruoyi.travels.domain.Around;
import com.ruoyi.travels.service.IAroundService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 距离记录Controller
 * 
 * @author Yifun
 * @date 2023-05-10
 */
@RestController
@RequestMapping("/around/around")
public class AroundController extends BaseController
{
    @Autowired
    private IAroundService aroundService;

    /**
     * 查询距离记录列表
     */
    @PreAuthorize("@ss.hasPermi('around:around:list')")
    @GetMapping("/list")
    public TableDataInfo list(Around around)
    {
        startPage();
        List<Around> list = aroundService.selectAroundList(around);
        return getDataTable(list);
    }

    /**
     * 导出距离记录列表
     */
    @PreAuthorize("@ss.hasPermi('around:around:export')")
    @Log(title = "距离记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Around around)
    {
        List<Around> list = aroundService.selectAroundList(around);
        ExcelUtil<Around> util = new ExcelUtil<Around>(Around.class);
        util.exportExcel(response, list, "距离记录数据");
    }

    /**
     * 获取距离记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('around:around:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(aroundService.selectAroundById(id));
    }

    /**
     * 新增距离记录
     */
    @PreAuthorize("@ss.hasPermi('around:around:add')")
    @Log(title = "距离记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Around around)
    {
        return toAjax(aroundService.insertAround(around));
    }

    /**
     * 修改距离记录
     */
    @PreAuthorize("@ss.hasPermi('around:around:edit')")
    @Log(title = "距离记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Around around)
    {
        return toAjax(aroundService.updateAround(around));
    }

    /**
     * 删除距离记录
     */
    @PreAuthorize("@ss.hasPermi('around:around:remove')")
    @Log(title = "距离记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(aroundService.deleteAroundByIds(ids));
    }
}
