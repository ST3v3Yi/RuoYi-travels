package com.ruoyi.travels.controller;

import java.time.Duration;
import java.time.Instant;
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
import com.ruoyi.travels.domain.UserRecords;
import com.ruoyi.travels.service.IUserRecordsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户浏览记录Controller
 * 
 * @author Yifun
 * @date 2023-05-10
 */
@RestController
@RequestMapping("/userRecords/userRecords")
public class UserRecordsController extends BaseController
{
    @Autowired
    private IUserRecordsService userRecordsService;

    private Instant lastInsertTime = Instant.now();

    /**
     * 查询用户浏览记录列表
     */
    @PreAuthorize("@ss.hasPermi('userRecords:userRecords:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserRecords userRecords)
    {
        startPage();
        List<UserRecords> list = userRecordsService.selectUserRecordsList(userRecords);
        return getDataTable(list);
    }

    /**
     * 导出用户浏览记录列表
     */
    @PreAuthorize("@ss.hasPermi('userRecords:userRecords:export')")
    @Log(title = "用户浏览记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserRecords userRecords)
    {
        List<UserRecords> list = userRecordsService.selectUserRecordsList(userRecords);
        ExcelUtil<UserRecords> util = new ExcelUtil<UserRecords>(UserRecords.class);
        util.exportExcel(response, list, "用户浏览记录数据");
    }

    /**
     * 获取用户浏览记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('userRecords:userRecords:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(userRecordsService.selectUserRecordsById(id));
    }

    /**
     * 新增用户浏览记录
     */
    @PreAuthorize("@ss.hasPermi('userRecords:userRecords:add')")
    @Log(title = "用户浏览记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserRecords userRecords)
    {
        Duration duration = Duration.between(lastInsertTime, Instant.now());
        System.out.println(lastInsertTime);
        System.out.println(Instant.now());
        lastInsertTime = Instant.now(); // 更新时间戳为当前时间
        if (duration.getSeconds() < 5) {
            // 时间戳差小于5秒，不允许插入
            return toAjax(0);
        } else {
            return toAjax(userRecordsService.insertUserRecords(userRecords));
        }
    }

    /**
     * 修改用户浏览记录
     */
    @PreAuthorize("@ss.hasPermi('userRecords:userRecords:edit')")
    @Log(title = "用户浏览记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserRecords userRecords)
    {
        return toAjax(userRecordsService.updateUserRecords(userRecords));
    }

    /**
     * 删除用户浏览记录
     */
    @PreAuthorize("@ss.hasPermi('userRecords:userRecords:remove')")
    @Log(title = "用户浏览记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userRecordsService.deleteUserRecordsByIds(ids));
    }
}
