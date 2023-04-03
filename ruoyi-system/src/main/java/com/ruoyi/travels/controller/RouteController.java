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
import com.ruoyi.travels.domain.Route;
import com.ruoyi.travels.service.IRouteService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 路线Controller
 * 
 * @author Yifun
 * @date 2023-03-11
 */
@RestController
@RequestMapping("/route/route")
public class RouteController extends BaseController
{
    @Autowired
    private IRouteService routeService;

    /**
     * 查询路线列表
     */
    @PreAuthorize("@ss.hasPermi('route:route:list')")
    @GetMapping("/list")
    public TableDataInfo list(Route route)
    {
        startPage();
        List<Route> list = routeService.selectRouteList(route);
        return getDataTable(list);
    }

    /**
     * 获取相应天数限制内的列表
     */
    @PreAuthorize("@ss.hasPermi('route:route:list')")
    @PostMapping("/listByDay")
    public AjaxResult getListByDay(@RequestBody Route route)
    {
        return success(routeService.selectRouteByDay(route));
    }

    /**
     * 获取相应花费限制内的列表
     */
    @PreAuthorize("@ss.hasPermi('route:route:list')")
    @PostMapping("/listByPrice")
    public AjaxResult getListByPrice(@RequestBody Route route)
    {
        return success(routeService.selectRouteByPrice(route));
    }

    /**
     * 导出路线列表
     */
    @PreAuthorize("@ss.hasPermi('route:route:export')")
    @Log(title = "路线", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Route route)
    {
        List<Route> list = routeService.selectRouteList(route);
        ExcelUtil<Route> util = new ExcelUtil<Route>(Route.class);
        util.exportExcel(response, list, "路线数据");
    }

    /**
     * 获取路线详细信息
     */
    @PreAuthorize("@ss.hasPermi('route:route:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(routeService.selectRouteById(id));
    }

    /**
     * 新增路线
     */
    @PreAuthorize("@ss.hasPermi('route:route:add')")
    @Log(title = "路线", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Route route)
    {
        return toAjax(routeService.insertRoute(route));
    }

    /**
     * 修改路线
     */
    @PreAuthorize("@ss.hasPermi('route:route:edit')")
    @Log(title = "路线", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Route route)
    {
        return toAjax(routeService.updateRoute(route));
    }

    /**
     * 删除路线
     */
    @PreAuthorize("@ss.hasPermi('route:route:remove')")
    @Log(title = "路线", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(routeService.deleteRouteByIds(ids));
    }

    /**
     * 上传路线封面图
    @Log(title = "路线封面图", businessType = BusinessType.INSERT)
    @PostMapping('/coverImg')
    public AjaxResult uploadCoverImg(@RequestParam("coverImg") MultipartFile file) throws Exception
    {
        if (!file.isEmpty())
        {

        }
    }*/
}
