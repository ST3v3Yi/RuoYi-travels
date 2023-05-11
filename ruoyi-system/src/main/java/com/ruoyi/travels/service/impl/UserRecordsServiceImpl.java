package com.ruoyi.travels.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travels.mapper.UserRecordsMapper;
import com.ruoyi.travels.domain.UserRecords;
import com.ruoyi.travels.service.IUserRecordsService;

/**
 * 用户浏览记录Service业务层处理
 * 
 * @author Yifun
 * @date 2023-05-10
 */
@Service
public class UserRecordsServiceImpl implements IUserRecordsService 
{
    @Autowired
    private UserRecordsMapper userRecordsMapper;

    /**
     * 查询用户浏览记录
     * 
     * @param id 用户浏览记录主键
     * @return 用户浏览记录
     */
    @Override
    public UserRecords selectUserRecordsById(Long id)
    {
        return userRecordsMapper.selectUserRecordsById(id);
    }

    /**
     * 查询用户浏览记录列表
     * 
     * @param userRecords 用户浏览记录
     * @return 用户浏览记录
     */
    @Override
    public List<UserRecords> selectUserRecordsList(UserRecords userRecords)
    {
        return userRecordsMapper.selectUserRecordsList(userRecords);
    }

    /**
     * 新增用户浏览记录
     * 
     * @param userRecords 用户浏览记录
     * @return 结果
     */
    @Override
    public int insertUserRecords(UserRecords userRecords)
    {
        userRecords.setCreateTime(DateUtils.getNowDate());
        return userRecordsMapper.insertUserRecords(userRecords);
    }

    /**
     * 修改用户浏览记录
     * 
     * @param userRecords 用户浏览记录
     * @return 结果
     */
    @Override
    public int updateUserRecords(UserRecords userRecords)
    {
        return userRecordsMapper.updateUserRecords(userRecords);
    }

    /**
     * 批量删除用户浏览记录
     * 
     * @param ids 需要删除的用户浏览记录主键
     * @return 结果
     */
    @Override
    public int deleteUserRecordsByIds(Long[] ids)
    {
        return userRecordsMapper.deleteUserRecordsByIds(ids);
    }

    /**
     * 删除用户浏览记录信息
     * 
     * @param id 用户浏览记录主键
     * @return 结果
     */
    @Override
    public int deleteUserRecordsById(Long id)
    {
        return userRecordsMapper.deleteUserRecordsById(id);
    }
}
