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
import com.ruoyi.travels.domain.RouteTag;
import com.ruoyi.travels.service.IRouteTagService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 路线TagController
 * 
 * @author Yifun
 * @date 2023-05-10
 */
@RestController
@RequestMapping("/route/routeTag")
public class RouteTagController extends BaseController
{
    @Autowired
    private IRouteTagService routeTagService;

    /**
     * 查询路线Tag列表
     */
    @PreAuthorize("@ss.hasPermi('route:routeTag:list')")
    @GetMapping("/list")
    public TableDataInfo list(RouteTag routeTag)
    {
        startPage();
        List<RouteTag> list = routeTagService.selectRouteTagList(routeTag);
        return getDataTable(list);
    }

    /**
     * 导出路线Tag列表
     */
    @PreAuthorize("@ss.hasPermi('route:routeTag:export')")
    @Log(title = "路线Tag", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RouteTag routeTag)
    {
        List<RouteTag> list = routeTagService.selectRouteTagList(routeTag);
        ExcelUtil<RouteTag> util = new ExcelUtil<RouteTag>(RouteTag.class);
        util.exportExcel(response, list, "路线Tag数据");
    }

    /**
     * 获取路线Tag详细信息
     */
    @PreAuthorize("@ss.hasPermi('route:routeTag:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(routeTagService.selectRouteTagById(id));
    }

    /**
     * 新增路线Tag
     */
    @PreAuthorize("@ss.hasPermi('route:routeTag:add')")
    @Log(title = "路线Tag", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RouteTag routeTag)
    {
        return toAjax(routeTagService.insertRouteTag(routeTag));
    }

    /**
     * 修改路线Tag
     */
    @PreAuthorize("@ss.hasPermi('route:routeTag:edit')")
    @Log(title = "路线Tag", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RouteTag routeTag)
    {
        return toAjax(routeTagService.updateRouteTag(routeTag));
    }

    /**
     * 删除路线Tag
     */
    @PreAuthorize("@ss.hasPermi('route:routeTag:remove')")
    @Log(title = "路线Tag", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(routeTagService.deleteRouteTagByIds(ids));
    }
}
