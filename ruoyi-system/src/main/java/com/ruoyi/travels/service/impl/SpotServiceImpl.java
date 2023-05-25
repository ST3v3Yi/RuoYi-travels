package com.ruoyi.travels.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travels.mapper.SpotMapper;
import com.ruoyi.travels.domain.Spot;
import com.ruoyi.travels.service.ISpotService;

/**
 * 景区Service业务层处理
 *
 * @author Yifun
 * @date 2023-04-11
 */
@Service
public class SpotServiceImpl implements ISpotService
{
    @Autowired
    private SpotMapper spotMapper;

    /**
     * 查询景区
     *
     * @param id 景区主键
     * @return 景区
     */
    @Override
    public Spot selectSpotById(Long id)
    {
        return spotMapper.selectSpotById(id);
    }

    /**
     * 查询景区列表
     *
     * @param spot 景区
     * @return 景区
     */
    @Override
    public List<Spot> selectSpotList(Spot spot)
    {
        return spotMapper.selectSpotList(spot);
    }

    /**
     * 根据名字获取id
     */
    @Override
    public Long selectSpotIdBySpotName(String spotName)
    {
        return spotMapper.selectSpotIdBySpotName(spotName);
    }

    /**
     * 新增景区
     *
     * @param spot 景区
     * @return 结果
     */
    @Override
    public int insertSpot(Spot spot)
    {
        spot.setCreateTime(DateUtils.getNowDate());
        return spotMapper.insertSpot(spot);
    }

    /**
     * 修改景区
     *
     * @param spot 景区
     * @return 结果
     */
    @Override
    public int updateSpot(Spot spot)
    {
        spot.setUpdateTime(DateUtils.getNowDate());
        return spotMapper.updateSpot(spot);
    }

    /**
     * 批量删除景区
     *
     * @param ids 需要删除的景区主键
     * @return 结果
     */
    @Override
    public int deleteSpotByIds(Long[] ids)
    {
        return spotMapper.deleteSpotByIds(ids);
    }

    /**
     * 删除景区信息
     *
     * @param id 景区主键
     * @return 结果
     */
    @Override
    public int deleteSpotById(Long id)
    {
        return spotMapper.deleteSpotById(id);
    }
}
