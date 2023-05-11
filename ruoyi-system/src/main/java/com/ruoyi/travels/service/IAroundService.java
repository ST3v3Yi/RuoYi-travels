package com.ruoyi.travels.service;

import java.util.List;
import com.ruoyi.travels.domain.Around;

/**
 * 距离记录Service接口
 * 
 * @author Yifun
 * @date 2023-05-10
 */
public interface IAroundService 
{
    /**
     * 查询距离记录
     * 
     * @param id 距离记录主键
     * @return 距离记录
     */
    public Around selectAroundById(Long id);

    /**
     * 查询距离记录列表
     * 
     * @param around 距离记录
     * @return 距离记录集合
     */
    public List<Around> selectAroundList(Around around);

    /**
     * 新增距离记录
     * 
     * @param around 距离记录
     * @return 结果
     */
    public int insertAround(Around around);

    /**
     * 修改距离记录
     * 
     * @param around 距离记录
     * @return 结果
     */
    public int updateAround(Around around);

    /**
     * 批量删除距离记录
     * 
     * @param ids 需要删除的距离记录主键集合
     * @return 结果
     */
    public int deleteAroundByIds(Long[] ids);

    /**
     * 删除距离记录信息
     * 
     * @param id 距离记录主键
     * @return 结果
     */
    public int deleteAroundById(Long id);
}
