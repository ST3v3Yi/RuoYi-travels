package com.ruoyi.travels.service;

import java.util.List;
import com.ruoyi.travels.domain.Facilities;

/**
 * 设施Service接口
 * 
 * @author Yifun
 * @date 2023-04-28
 */
public interface IFacilitiesService 
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
     * 批量删除设施
     * 
     * @param ids 需要删除的设施主键集合
     * @return 结果
     */
    public int deleteFacilitiesByIds(Long[] ids);

    /**
     * 删除设施信息
     * 
     * @param id 设施主键
     * @return 结果
     */
    public int deleteFacilitiesById(Long id);
}
