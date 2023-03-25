package com.ruoyi.travels.mapper;

import java.math.BigDecimal;
import java.util.List;
import com.ruoyi.travels.domain.RouteRating;

/**
 * 路线评分Mapper接口
 *
 * @author Yifun
 * @date 2023-03-25
 */
public interface RouteRatingMapper
{
    /**
     * 查询路线评分
     *
     * @param routeId 路线评分主键
     * @return 路线评分
     */
    public RouteRating selectRouteRatingByRouteId(Long routeId);

    /**
     *
     * 查询路线平均分
     */
    public BigDecimal selectAVGRatingByRouteId(Long routeId);

    /**
     * 查询路线评分列表
     *
     * @param routeRating 路线评分
     * @return 路线评分集合
     */
    public List<RouteRating> selectRouteRatingList(RouteRating routeRating);

    /**
     * 新增路线评分
     *
     * @param routeRating 路线评分
     * @return 结果
     */
    public int insertRouteRating(RouteRating routeRating);

    /**
     * 修改路线评分
     *
     * @param routeRating 路线评分
     * @return 结果
     */
    public int updateRouteRating(RouteRating routeRating);

    /**
     * 删除路线评分
     *
     * @param routeId 路线评分主键
     * @return 结果
     */
    public int deleteRouteRatingByRouteId(Long routeId);

    /**
     * 批量删除路线评分
     *
     * @param routeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRouteRatingByRouteIds(Long[] routeIds);
}