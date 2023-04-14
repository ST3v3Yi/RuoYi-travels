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
import com.ruoyi.travels.domain.SpotReply;
import com.ruoyi.travels.service.ISpotReplyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 景区回复表Controller
 * 
 * @author Yifun
 * @date 2023-04-02
 */
@RestController
@RequestMapping("/spotReply/spotReply")
public class SpotReplyController extends BaseController
{
    @Autowired
    private ISpotReplyService spotReplyService;

    /**
     * 查询景区回复表列表
     */
    @PreAuthorize("@ss.hasPermi('spotReply:spotReply:list')")
    @GetMapping("/list")
    public TableDataInfo list(SpotReply spotReply)
    {
        startPage();
        List<SpotReply> list = spotReplyService.selectSpotReplyList(spotReply);
        return getDataTable(list);
    }

    /**
     * 导出景区回复表列表
     */
    @PreAuthorize("@ss.hasPermi('spotReply:spotReply:export')")
    @Log(title = "景区回复表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SpotReply spotReply)
    {
        List<SpotReply> list = spotReplyService.selectSpotReplyList(spotReply);
        ExcelUtil<SpotReply> util = new ExcelUtil<SpotReply>(SpotReply.class);
        util.exportExcel(response, list, "景区回复表数据");
    }

    /**
     * 获取景区回复表详细信息
     */
    @PreAuthorize("@ss.hasPermi('spotReply:spotReply:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(spotReplyService.selectSpotReplyById(id));
    }

    /**
     * 根据评论ID获取路线回复
     */
    @PreAuthorize("@ss.hasPermi('routeReply:routeReply:query')")
    @GetMapping(value = "/list/{commentId}")
    public AjaxResult getList(@PathVariable("commentId") Long commentId)
    {
        return success(spotReplyService.selectSpotReplyByCommentId(commentId));
    }

    /**
     * 新增景区回复表
     */
    @PreAuthorize("@ss.hasPermi('spotReply:spotReply:add')")
    @Log(title = "景区回复表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SpotReply spotReply)
    {
        return toAjax(spotReplyService.insertSpotReply(spotReply));
    }

    /**
     * 修改景区回复表
     */
    @PreAuthorize("@ss.hasPermi('spotReply:spotReply:edit')")
    @Log(title = "景区回复表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SpotReply spotReply)
    {
        return toAjax(spotReplyService.updateSpotReply(spotReply));
    }

    /**
     * 删除景区回复表
     */
    @PreAuthorize("@ss.hasPermi('spotReply:spotReply:remove')")
    @Log(title = "景区回复表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(spotReplyService.deleteSpotReplyByIds(ids));
    }
}
