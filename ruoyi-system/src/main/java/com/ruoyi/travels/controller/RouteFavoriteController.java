package com.ruoyi.travels.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.travels.domain.RouteFavorite;
import com.ruoyi.travels.service.IRouteFavoriteService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 路线收藏Controller
 * 
 * @author Yifun
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/routeFavorite/routeFavorite")
public class RouteFavoriteController extends BaseController
{
    @Autowired
    private IRouteFavoriteService routeFavoriteService;

    /**
     * 查询路线收藏列表
     */
    @PreAuthorize("@ss.hasPermi('routeFavorite:routeFavorite:list')")
    @GetMapping("/list")
    public TableDataInfo list(RouteFavorite routeFavorite)
    {
        startPage();
        List<RouteFavorite> list = routeFavoriteService.selectRouteFavoriteList(routeFavorite);
        return getDataTable(list);
    }

    /**
     * 导出路线收藏列表
     */
    @PreAuthorize("@ss.hasPermi('routeFavorite:routeFavorite:export')")
    @Log(title = "路线收藏", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RouteFavorite routeFavorite)
    {
        List<RouteFavorite> list = routeFavoriteService.selectRouteFavoriteList(routeFavorite);
        ExcelUtil<RouteFavorite> util = new ExcelUtil<RouteFavorite>(RouteFavorite.class);
        util.exportExcel(response, list, "路线收藏数据");
    }

    /**
     * 获取路线收藏详细信息
     */
    @PreAuthorize("@ss.hasPermi('routeFavorite:routeFavorite:query')")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        return success(routeFavoriteService.selectRouteFavoriteByUserId(userId));
    }

    /**
     * 获取用户是否收藏路线
     */
    @PreAuthorize("@ss.hasPermi('routeFavorite:routeFavorite:query')")
    @PostMapping(value = "/isFavorite")
    public AjaxResult getIsFavorite(@RequestBody RouteFavorite routeFavorite)
    {
        return success(routeFavoriteService.selectIsFavorite(routeFavorite));
    }

    /**
     * 获取用户收藏路线信息
     */
    @PreAuthorize("@ss.hasPermi('routeFavorite:routeFavorite:query')")
    @GetMapping(value = "/route/{userId}")
    public AjaxResult getUserFavorite(@PathVariable("userId") Long userId)
    {
        return success(routeFavoriteService.selectFavoriteRouteByUserId(userId));
    }

    /**
     * 新增路线收藏
     */
    @PreAuthorize("@ss.hasPermi('routeFavorite:routeFavorite:add')")
    @Log(title = "路线收藏", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RouteFavorite routeFavorite)
    {
        return toAjax(routeFavoriteService.insertRouteFavorite(routeFavorite));
    }

    /**
     * 修改路线收藏
     */
    @PreAuthorize("@ss.hasPermi('routeFavorite:routeFavorite:edit')")
    @Log(title = "路线收藏", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RouteFavorite routeFavorite)
    {
        return toAjax(routeFavoriteService.updateRouteFavorite(routeFavorite));
    }

    /**
     * 删除路线收藏
     */
    @PreAuthorize("@ss.hasPermi('routeFavorite:routeFavorite:remove')")
    @Log(title = "路线收藏", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds)
    {
        return toAjax(routeFavoriteService.deleteRouteFavoriteByUserIds(userIds));
    }

    /**
     * 删除路线收藏
     */
    @PreAuthorize("@ss.hasPermi('routeFavorite:routeFavorite:remove')")
    @PostMapping("/delFavorite")
    public AjaxResult delFavorite(@RequestBody RouteFavorite routeFavorite)
    {
        return toAjax(routeFavoriteService.deleteRouteFavorite(routeFavorite));
    }
}
