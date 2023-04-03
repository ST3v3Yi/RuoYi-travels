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
import com.ruoyi.travels.domain.SpotImg;
import com.ruoyi.travels.service.ISpotImgService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 景区图片Controller
 * 
 * @author Yifun
 * @date 2023-04-02
 */
@RestController
@RequestMapping("/spotImg/spotImg")
public class SpotImgController extends BaseController
{
    @Autowired
    private ISpotImgService spotImgService;

    /**
     * 查询景区图片列表
     */
    @PreAuthorize("@ss.hasPermi('spotImg:spotImg:list')")
    @GetMapping("/list")
    public TableDataInfo list(SpotImg spotImg)
    {
        startPage();
        List<SpotImg> list = spotImgService.selectSpotImgList(spotImg);
        return getDataTable(list);
    }

    /**
     * 导出景区图片列表
     */
    @PreAuthorize("@ss.hasPermi('spotImg:spotImg:export')")
    @Log(title = "景区图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SpotImg spotImg)
    {
        List<SpotImg> list = spotImgService.selectSpotImgList(spotImg);
        ExcelUtil<SpotImg> util = new ExcelUtil<SpotImg>(SpotImg.class);
        util.exportExcel(response, list, "景区图片数据");
    }

    /**
     * 获取景区图片详细信息
     */
    @PreAuthorize("@ss.hasPermi('spotImg:spotImg:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(spotImgService.selectSpotImgById(id));
    }

    /**
     * 新增景区图片
     */
    @PreAuthorize("@ss.hasPermi('spotImg:spotImg:add')")
    @Log(title = "景区图片", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SpotImg spotImg)
    {
        return toAjax(spotImgService.insertSpotImg(spotImg));
    }

    /**
     * 修改景区图片
     */
    @PreAuthorize("@ss.hasPermi('spotImg:spotImg:edit')")
    @Log(title = "景区图片", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SpotImg spotImg)
    {
        return toAjax(spotImgService.updateSpotImg(spotImg));
    }

    /**
     * 删除景区图片
     */
    @PreAuthorize("@ss.hasPermi('spotImg:spotImg:remove')")
    @Log(title = "景区图片", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(spotImgService.deleteSpotImgByIds(ids));
    }
}
