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
import com.ruoyi.travels.domain.RouteComments;
import com.ruoyi.travels.service.IRouteCommentsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 路线评论Controller
 * 
 * @author Yifun
 * @date 2023-03-25
 */
@RestController
@RequestMapping("/routeComments/routeComments")
public class RouteCommentsController extends BaseController
{
    @Autowired
    private IRouteCommentsService routeCommentsService;

    /**
     * 查询路线评论列表
     */
    @PreAuthorize("@ss.hasPermi('routeComments:routeComments:list')")
    @GetMapping("/list")
    public TableDataInfo list(RouteComments routeComments)
    {
        startPage();
        List<RouteComments> list = routeCommentsService.selectRouteCommentsList(routeComments);
        return getDataTable(list);
    }

    /**
     * 导出路线评论列表
     */
    @PreAuthorize("@ss.hasPermi('routeComments:routeComments:export')")
    @Log(title = "路线评论", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RouteComments routeComments)
    {
        List<RouteComments> list = routeCommentsService.selectRouteCommentsList(routeComments);
        ExcelUtil<RouteComments> util = new ExcelUtil<RouteComments>(RouteComments.class);
        util.exportExcel(response, list, "路线评论数据");
    }

    /**
     * 获取路线评论详细信息
     */
    @PreAuthorize("@ss.hasPermi('routeComments:routeComments:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(routeCommentsService.selectRouteCommentsById(id));
    }

    /**
     * 查询指定路线的评论列表
     */
    @PreAuthorize("@ss.hasPermi('routeComments:routeComments:list')")
    @GetMapping("/list/{routeId}")
    public AjaxResult getList(@PathVariable("routeId") Long routeId)
    {
        return success(routeCommentsService.selectRouteCommentsListByRouteId(routeId));
    }

    /**
     * 获取相应用户的评论
     */
    @PreAuthorize("@ss.hasPermi('routeComments:routeComments:query')")
    @GetMapping("/user/{userId}")
    public AjaxResult getUserComments(@PathVariable("userId") Long userId)
    {
        return success(routeCommentsService.selectRouteCommentsByUserId(userId));
    }

    /**
     * 获取用户评论数量
     */
    @PreAuthorize("@ss.hasPermi('routeComments:routeComments:query')")
    @GetMapping("/userComments/{userId}")
    public AjaxResult getUserCommentsNum(@PathVariable("userId") Long userId)
    {
        return success(routeCommentsService.selectRouteCommentsNumByUserId(userId));
    }

    /**
     * 新增路线评论
     */
    @PreAuthorize("@ss.hasPermi('routeComments:routeComments:add')")
    @Log(title = "路线评论", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RouteComments routeComments)
    {
        return toAjax(routeCommentsService.insertRouteComments(routeComments));
    }

    /**
     * 修改路线评论
     */
    @PreAuthorize("@ss.hasPermi('routeComments:routeComments:edit')")
    @Log(title = "路线评论", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RouteComments routeComments)
    {
        return toAjax(routeCommentsService.updateRouteComments(routeComments));
    }

    /**
     * 删除路线评论
     */
    @PreAuthorize("@ss.hasPermi('routeComments:routeComments:remove')")
    @Log(title = "路线评论", businessType = BusinessType.DELETE)
	@DeleteMapping("/del/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(routeCommentsService.deleteRouteCommentsByIds(ids));
    }
}
