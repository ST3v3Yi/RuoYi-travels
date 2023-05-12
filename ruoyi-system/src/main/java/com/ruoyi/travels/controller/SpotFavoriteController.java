package com.ruoyi.travels.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.travels.domain.RouteFavorite;
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
import com.ruoyi.travels.domain.SpotFavorite;
import com.ruoyi.travels.service.ISpotFavoriteService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 景区收藏Controller
 * 
 * @author Yifun
 * @date 2023-04-13
 */
@RestController
@RequestMapping("/spotFavorite/spotFavorite")
public class SpotFavoriteController extends BaseController
{
    @Autowired
    private ISpotFavoriteService spotFavoriteService;

    /**
     * 查询景区收藏列表
     */
    @PreAuthorize("@ss.hasPermi('spotFavorite:spotFavorite:list')")
    @GetMapping("/list")
    public TableDataInfo list(SpotFavorite spotFavorite)
    {
        startPage();
        List<SpotFavorite> list = spotFavoriteService.selectSpotFavoriteList(spotFavorite);
        return getDataTable(list);
    }

    /**
     * 导出景区收藏列表
     */
    @PreAuthorize("@ss.hasPermi('spotFavorite:spotFavorite:export')")
    @Log(title = "景区收藏", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SpotFavorite spotFavorite)
    {
        List<SpotFavorite> list = spotFavoriteService.selectSpotFavoriteList(spotFavorite);
        ExcelUtil<SpotFavorite> util = new ExcelUtil<SpotFavorite>(SpotFavorite.class);
        util.exportExcel(response, list, "景区收藏数据");
    }

    /**
     * 获取景区收藏详细信息
     */
    @PreAuthorize("@ss.hasPermi('spotFavorite:spotFavorite:query')")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        return success(spotFavoriteService.selectSpotFavoriteByUserId(userId));
    }

    /**
     * 获取用户是否收藏景点
     */
    @PreAuthorize("@ss.hasPermi('spotFavorite:spotFavorite:query')")
    @PostMapping(value = "/isFavorite")
    public AjaxResult getIsFavorite(@RequestBody SpotFavorite spotFavorite)
    {
        return success(spotFavoriteService.selectIsFavorite(spotFavorite));
    }

    /**
     * 获取用户收藏景点信息
     */
    @PreAuthorize("@ss.hasPermi('spotFavorite:spotFavorite:query')")
    @GetMapping(value = "/spot/{userId}")
    public AjaxResult getUserFavorite(@PathVariable("userId") Long userId)
    {
        return success(spotFavoriteService.selectFavoriteSpotByUserId(userId));
    }

    /**
     * 新增景区收藏
     */
    @PreAuthorize("@ss.hasPermi('spotFavorite:spotFavorite:add')")
    @Log(title = "景区收藏", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SpotFavorite spotFavorite)
    {
        return toAjax(spotFavoriteService.insertSpotFavorite(spotFavorite));
    }

    /**
     * 修改景区收藏
     */
    @PreAuthorize("@ss.hasPermi('spotFavorite:spotFavorite:edit')")
    @Log(title = "景区收藏", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SpotFavorite spotFavorite)
    {
        return toAjax(spotFavoriteService.updateSpotFavorite(spotFavorite));
    }

    /**
     * 删除景区收藏
     */
    @PreAuthorize("@ss.hasPermi('spotFavorite:spotFavorite:remove')")
    @Log(title = "景区收藏", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds)
    {
        return toAjax(spotFavoriteService.deleteSpotFavoriteByUserIds(userIds));
    }

    /**
     * 删除景点收藏
     */
    @PreAuthorize("@ss.hasPermi('spotFavorite:spotFavorite:remove')")
    @PostMapping("/delFavorite")
    public AjaxResult delFavorite(@RequestBody SpotFavorite spotFavorite)
    {
        return toAjax(spotFavoriteService.deleteSpotFavorite(spotFavorite));
    }
}
