package com.ruoyi.travels.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travels.mapper.FacilitiesMapper;
import com.ruoyi.travels.domain.Facilities;
import com.ruoyi.travels.service.IFacilitiesService;

/**
 * 设施Service业务层处理
 * 
 * @author Yifun
 * @date 2023-04-28
 */
@Service
public class FacilitiesServiceImpl implements IFacilitiesService 
{
    @Autowired
    private FacilitiesMapper facilitiesMapper;

    /**
     * 查询设施
     * 
     * @param id 设施主键
     * @return 设施
     */
    @Override
    public Facilities selectFacilitiesById(Long id)
    {
        return facilitiesMapper.selectFacilitiesById(id);
    }

    /**
     * 查询设施列表
     * 
     * @param facilities 设施
     * @return 设施
     */
    @Override
    public List<Facilities> selectFacilitiesList(Facilities facilities)
    {
        return facilitiesMapper.selectFacilitiesList(facilities);
    }

    /**
     * 新增设施
     * 
     * @param facilities 设施
     * @return 结果
     */
    @Override
    public int insertFacilities(Facilities facilities)
    {
        return facilitiesMapper.insertFacilities(facilities);
    }

    /**
     * 修改设施
     * 
     * @param facilities 设施
     * @return 结果
     */
    @Override
    public int updateFacilities(Facilities facilities)
    {
        return facilitiesMapper.updateFacilities(facilities);
    }

    /**
     * 批量删除设施
     * 
     * @param ids 需要删除的设施主键
     * @return 结果
     */
    @Override
    public int deleteFacilitiesByIds(Long[] ids)
    {
        return facilitiesMapper.deleteFacilitiesByIds(ids);
    }

    /**
     * 删除设施信息
     * 
     * @param id 设施主键
     * @return 结果
     */
    @Override
    public int deleteFacilitiesById(Long id)
    {
        return facilitiesMapper.deleteFacilitiesById(id);
    }
}
