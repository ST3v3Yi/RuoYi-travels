package com.ruoyi.travels.mapper;

import java.util.List;
import com.ruoyi.travels.domain.Facilities;

/**
 * 设施Mapper接口
 * 
 * @author Yifun
 * @date 2023-04-28
 */
public interface FacilitiesMapper 
{
    /**
     * 查询设施
     * 
     * @param id 设施主键
     * @return 设施
     */
    public Facilities selectFacilitiesById(Long id);

    /**
     * 查询设施列表
     * 
     * @param facilities 设施
     * @return 设施集合
     */
    public List<Facilities> selectFacilitiesList(Facilities facilities);

    /**
     * 新增设施
     * 
     * @param facilities 设施
     * @return 结果
     */
    public int insertFacilities(Facilities facilities);

    /**
     * 修改设施
     * 
     * @param facilities 设施
     * @return 结果
     */
    public int updateFacilities(Facilities facilities);

    /**
     * 删除设施
     * 
     * @param id 设施主键
     * @return 结果
     */
    public int deleteFacilitiesById(Long id);

    /**
     * 批量删除设施
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFacilitiesByIds(Long[] ids);
}
