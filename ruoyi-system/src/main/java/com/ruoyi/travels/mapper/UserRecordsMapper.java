package com.ruoyi.travels.mapper;

import java.util.List;
import com.ruoyi.travels.domain.UserRecords;

/**
 * 用户浏览记录Mapper接口
 * 
 * @author Yifun
 * @date 2023-05-10
 */
public interface UserRecordsMapper 
{
    /**
     * 查询用户浏览记录
     * 
     * @param id 用户浏览记录主键
     * @return 用户浏览记录
     */
    public UserRecords selectUserRecordsById(Long id);

    /**
     * 查询用户浏览记录列表
     * 
     * @param userRecords 用户浏览记录
     * @return 用户浏览记录集合
     */
    public List<UserRecords> selectUserRecordsList(UserRecords userRecords);

    /**
     * 新增用户浏览记录
     * 
     * @param userRecords 用户浏览记录
     * @return 结果
     */
    public int insertUserRecords(UserRecords userRecords);

    /**
     * 修改用户浏览记录
     * 
     * @param userRecords 用户浏览记录
     * @return 结果
     */
    public int updateUserRecords(UserRecords userRecords);

    /**
     * 删除用户浏览记录
     * 
     * @param id 用户浏览记录主键
     * @return 结果
     */
    public int deleteUserRecordsById(Long id);

    /**
     * 批量删除用户浏览记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserRecordsByIds(Long[] ids);
}
