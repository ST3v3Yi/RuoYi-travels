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
import com.ruoyi.travels.domain.SpotComments;
import com.ruoyi.travels.service.ISpotCommentsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 景区评分评论Controller
 * 
 * @author Yifun
 * @date 2023-04-02
 */
@RestController
@RequestMapping("/spotComments/spotComments")
public class SpotCommentsController extends BaseController
{
    @Autowired
    private ISpotCommentsService spotCommentsService;

    /**
     * 查询景区评分评论列表
     */
    @PreAuthorize("@ss.hasPermi('spotComments:spotComments:list')")
    @GetMapping("/list")
    public TableDataInfo list(SpotComments spotComments)
    {
        startPage();
        List<SpotComments> list = spotCommentsService.selectSpotCommentsList(spotComments);
        return getDataTable(list);
    }

    /**
     * 导出景区评分评论列表
     */
    @PreAuthorize("@ss.hasPermi('spotComments:spotComments:export')")
    @Log(title = "景区评分评论", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SpotComments spotComments)
    {
        List<SpotComments> list = spotCommentsService.selectSpotCommentsList(spotComments);
        ExcelUtil<SpotComments> util = new ExcelUtil<SpotComments>(SpotComments.class);
        util.exportExcel(response, list, "景区评分评论数据");
    }

    /**
     * 获取景区评分评论详细信息
     */
    @PreAuthorize("@ss.hasPermi('spotComments:spotComments:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(spotCommentsService.selectSpotCommentsById(id));
    }

    /**
     * 新增景区评分评论
     */
    @PreAuthorize("@ss.hasPermi('spotComments:spotComments:add')")
    @Log(title = "景区评分评论", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SpotComments spotComments)
    {
        return toAjax(spotCommentsService.insertSpotComments(spotComments));
    }

    /**
     * 修改景区评分评论
     */
    @PreAuthorize("@ss.hasPermi('spotComments:spotComments:edit')")
    @Log(title = "景区评分评论", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SpotComments spotComments)
    {
        return toAjax(spotCommentsService.updateSpotComments(spotComments));
    }

    /**
     * 删除景区评分评论
     */
    @PreAuthorize("@ss.hasPermi('spotComments:spotComments:remove')")
    @Log(title = "景区评分评论", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(spotCommentsService.deleteSpotCommentsByIds(ids));
    }
}
