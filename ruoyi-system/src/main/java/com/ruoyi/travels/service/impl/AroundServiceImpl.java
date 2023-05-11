package com.ruoyi.travels.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travels.mapper.AroundMapper;
import com.ruoyi.travels.domain.Around;
import com.ruoyi.travels.service.IAroundService;

/**
 * 距离记录Service业务层处理
 * 
 * @author Yifun
 * @date 2023-05-10
 */
@Service
public class AroundServiceImpl implements IAroundService 
{
    @Autowired
    private AroundMapper aroundMapper;

    /**
     * 查询距离记录
     * 
     * @param id 距离记录主键
     * @return 距离记录
     */
    @Override
    public Around selectAroundById(Long id)
    {
        return aroundMapper.selectAroundById(id);
    }

    /**
     * 查询距离记录列表
     * 
     * @param around 距离记录
     * @return 距离记录
     */
    @Override
    public List<Around> selectAroundList(Around around)
    {
        return aroundMapper.selectAroundList(around);
    }

    /**
     * 新增距离记录
     * 
     * @param around 距离记录
     * @return 结果
     */
    @Override
    public int insertAround(Around around)
    {
        around.setCreateTime(DateUtils.getNowDate());
        return aroundMapper.insertAround(around);
    }

    /**
     * 修改距离记录
     * 
     * @param around 距离记录
     * @return 结果
     */
    @Override
    public int updateAround(Around around)
    {
        return aroundMapper.updateAround(around);
    }

    /**
     * 批量删除距离记录
     * 
     * @param ids 需要删除的距离记录主键
     * @return 结果
     */
    @Override
    public int deleteAroundByIds(Long[] ids)
    {
        return aroundMapper.deleteAroundByIds(ids);
    }

    /**
     * 删除距离记录信息
     * 
     * @param id 距离记录主键
     * @return 结果
     */
    @Override
    public int deleteAroundById(Long id)
    {
        return aroundMapper.deleteAroundById(id);
    }
}
