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
import com.ruoyi.travels.domain.RouteReply;
import com.ruoyi.travels.service.IRouteReplyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 路线回复Controller
 * 
 * @author Yifun
 * @date 2023-03-25
 */
@RestController
@RequestMapping("/routeReply/routeReply")
public class RouteReplyController extends BaseController
{
    @Autowired
    private IRouteReplyService routeReplyService;

    /**
     * 查询路线回复列表
     */
    @PreAuthorize("@ss.hasPermi('routeReply:routeReply:list')")
    @GetMapping("/list")
    public TableDataInfo list(RouteReply routeReply)
    {
        startPage();
        List<RouteReply> list = routeReplyService.selectRouteReplyList(routeReply);
        return getDataTable(list);
    }

    /**
     * 导出路线回复列表
     */
    @PreAuthorize("@ss.hasPermi('routeReply:routeReply:export')")
    @Log(title = "路线回复", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RouteReply routeReply)
    {
        List<RouteReply> list = routeReplyService.selectRouteReplyList(routeReply);
        ExcelUtil<RouteReply> util = new ExcelUtil<RouteReply>(RouteReply.class);
        util.exportExcel(response, list, "路线回复数据");
    }

    /**
     * 获取路线回复详细信息
     */
    @PreAuthorize("@ss.hasPermi('routeReply:routeReply:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(routeReplyService.selectRouteReplyById(id));
    }

    /**
     * 新增路线回复
     */
    @PreAuthorize("@ss.hasPermi('routeReply:routeReply:add')")
    @Log(title = "路线回复", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RouteReply routeReply)
    {
        return toAjax(routeReplyService.insertRouteReply(routeReply));
    }

    /**
     * 修改路线回复
     */
    @PreAuthorize("@ss.hasPermi('routeReply:routeReply:edit')")
    @Log(title = "路线回复", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RouteReply routeReply)
    {
        return toAjax(routeReplyService.updateRouteReply(routeReply));
    }

    /**
     * 删除路线回复
     */
    @PreAuthorize("@ss.hasPermi('routeReply:routeReply:remove')")
    @Log(title = "路线回复", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(routeReplyService.deleteRouteReplyByIds(ids));
    }
}
