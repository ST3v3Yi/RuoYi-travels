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
import com.ruoyi.travels.domain.Spot;
import com.ruoyi.travels.service.ISpotService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 景区Controller
 *
 * @author Yifun
 * @date 2023-04-11
 */
@RestController
@RequestMapping("/spot/spot")
public class SpotController extends BaseController
{
    @Autowired
    private ISpotService spotService;

    /**
     * 查询景区列表
     */
    @PreAuthorize("@ss.hasPermi('spot:spot:list')")
    @GetMapping("/list")
    public TableDataInfo list(Spot spot)
    {
        startPage();
        List<Spot> list = spotService.selectSpotList(spot);
        return getDataTable(list);
    }

    /**
     * 导出景区列表
     */
    @PreAuthorize("@ss.hasPermi('spot:spot:export')")
    @Log(title = "景区", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Spot spot)
    {
        List<Spot> list = spotService.selectSpotList(spot);
        ExcelUtil<Spot> util = new ExcelUtil<Spot>(Spot.class);
        util.exportExcel(response, list, "景区数据");
    }

    /**
     * 获取景区详细信息
     */
    @PreAuthorize("@ss.hasPermi('spot:spot:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(spotService.selectSpotById(id));
    }

    /**
     * 新增景区
     */
    @PreAuthorize("@ss.hasPermi('spot:spot:add')")
    @Log(title = "景区", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Spot spot)
    {
        return toAjax(spotService.insertSpot(spot));
    }

    /**
     * 修改景区
     */
    @PreAuthorize("@ss.hasPermi('spot:spot:edit')")
    @Log(title = "景区", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Spot spot)
    {
        return toAjax(spotService.updateSpot(spot));
    }

    /**
     * 删除景区
     */
    @PreAuthorize("@ss.hasPermi('spot:spot:remove')")
    @Log(title = "景区", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(spotService.deleteSpotByIds(ids));
    }
}
