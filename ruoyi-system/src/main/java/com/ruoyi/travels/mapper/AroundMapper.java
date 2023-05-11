package com.ruoyi.travels.mapper;

import java.util.List;
import com.ruoyi.travels.domain.Around;

/**
 * 距离记录Mapper接口
 * 
 * @author Yifun
 * @date 2023-05-10
 */
public interface AroundMapper 
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
     * 删除距离记录
     * 
     * @param id 距离记录主键
     * @return 结果
     */
    public int deleteAroundById(Long id);

    /**
     * 批量删除距离记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAroundByIds(Long[] ids);
}
