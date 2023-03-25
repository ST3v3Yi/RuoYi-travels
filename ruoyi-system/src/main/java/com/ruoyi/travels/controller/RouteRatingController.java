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
import com.ruoyi.travels.domain.RouteRating;
import com.ruoyi.travels.service.IRouteRatingService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 路线评分Controller
 *
 * @author Yifun
 * @date 2023-03-25
 */
@RestController
@RequestMapping("/routeRating/routeRating")
public class RouteRatingController extends BaseController
{
    @Autowired
    private IRouteRatingService routeRatingService;

    /**
     * 查询路线评分列表
     */
    @PreAuthorize("@ss.hasPermi('routeRating:routeRating:list')")
    @GetMapping("/list")
    public TableDataInfo list(RouteRating routeRating)
    {
        startPage();
        List<RouteRating> list = routeRatingService.selectRouteRatingList(routeRating);
        return getDataTable(list);
    }

    /**
     * 导出路线评分列表
     */
    @PreAuthorize("@ss.hasPermi('routeRating:routeRating:export')")
    @Log(title = "路线评分", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RouteRating routeRating)
    {
        List<RouteRating> list = routeRatingService.selectRouteRatingList(routeRating);
        ExcelUtil<RouteRating> util = new ExcelUtil<RouteRating>(RouteRating.class);
        util.exportExcel(response, list, "路线评分数据");
    }

    /**
     * 获取路线评分详细信息
     */
    @PreAuthorize("@ss.hasPermi('routeRating:routeRating:query')")
    @GetMapping(value = "/{routeId}")
    public AjaxResult getInfo(@PathVariable("routeId") Long routeId)
    {
        return success(routeRatingService.selectRouteRatingByRouteId(routeId));
    }

    /**
     * 新增路线评分
     */
    @PreAuthorize("@ss.hasPermi('routeRating:routeRating:add')")
    @Log(title = "路线评分", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RouteRating routeRating)
    {
        return toAjax(routeRatingService.insertRouteRating(routeRating));
    }

    /**
     * 修改路线评分
     */
    @PreAuthorize("@ss.hasPermi('routeRating:routeRating:edit')")
    @Log(title = "路线评分", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RouteRating routeRating)
    {
        return toAjax(routeRatingService.updateRouteRating(routeRating));
    }

    /**
     * 删除路线评分
     */
    @PreAuthorize("@ss.hasPermi('routeRating:routeRating:remove')")
    @Log(title = "路线评分", businessType = BusinessType.DELETE)
    @DeleteMapping("/{routeIds}")
    public AjaxResult remove(@PathVariable Long[] routeIds)
    {
        return toAjax(routeRatingService.deleteRouteRatingByRouteIds(routeIds));
    }
}