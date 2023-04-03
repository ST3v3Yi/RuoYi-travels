package com.ruoyi.travels.service.impl;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travels.mapper.RouteRatingMapper;
import com.ruoyi.travels.domain.RouteRating;
import com.ruoyi.travels.service.IRouteRatingService;

/**
 * 路线评分Service业务层处理
 *
 * @author Yifun
 * @date 2023-03-25
 */
@Service
public class RouteRatingServiceImpl implements IRouteRatingService
{
    @Autowired
    private RouteRatingMapper routeRatingMapper;

    /**
     * 查询路线评分
     *
     * @param routeId 路线评分主键
     * @return 路线评分
     */
    @Override
    public RouteRating selectRouteRatingByRouteId(Long routeId)
    {
        return routeRatingMapper.selectRouteRatingByRouteId(routeId);
    }

    /**
     *
     * 查询路线平均分
     */
    @Override
    public BigDecimal selectAVGRatingByRouteId(Long routeId)
    {
        return routeRatingMapper.selectAVGRatingByRouteId(routeId);
    }

    /**
     * 查询当前用户对该路线的评分
     */
    public BigDecimal selectRating(RouteRating routeRating)
    {
        return routeRatingMapper.selectRating(routeRating);
    }

    /**
     * 查询路线评分列表
     *
     * @param routeRating 路线评分
     * @return 路线评分
     */
    @Override
    public List<RouteRating> selectRouteRatingList(RouteRating routeRating)
    {
        return routeRatingMapper.selectRouteRatingList(routeRating);
    }

    /**
     * 新增路线评分
     *
     * @param routeRating 路线评分
     * @return 结果
     */
    @Override
    public int insertRouteRating(RouteRating routeRating)
    {
        return routeRatingMapper.insertRouteRating(routeRating);
    }

    /**
     * 修改路线评分
     *
     * @param routeRating 路线评分
     * @return 结果
     */
    @Override
    public int updateRouteRating(RouteRating routeRating)
    {
        return routeRatingMapper.updateRouteRating(routeRating);
    }

    /**
     * 批量删除路线评分
     *
     * @param routeIds 需要删除的路线评分主键
     * @return 结果
     */
    @Override
    public int deleteRouteRatingByRouteIds(Long[] routeIds)
    {
        return routeRatingMapper.deleteRouteRatingByRouteIds(routeIds);
    }

    /**
     * 删除路线评分信息
     *
     * @param routeId 路线评分主键
     * @return 结果
     */
    @Override
    public int deleteRouteRatingByRouteId(Long routeId)
    {
        return routeRatingMapper.deleteRouteRatingByRouteId(routeId);
    }
}