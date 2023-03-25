package com.ruoyi.travels.service;

import java.util.List;
import com.ruoyi.travels.domain.RouteRating;

/**
 * 路线评分Service接口
 *
 * @author Yifun
 * @date 2023-03-25
 */
public interface IRouteRatingService
{
    /**
     * 查询路线评分
     *
     * @param routeId 路线评分主键
     * @return 路线评分
     */
    public RouteRating selectRouteRatingByRouteId(Long routeId);

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
     * 批量删除路线评分
     *
     * @param routeIds 需要删除的路线评分主键集合
     * @return 结果
     */
    public int deleteRouteRatingByRouteIds(Long[] routeIds);

    /**
     * 删除路线评分信息
     *
     * @param routeId 路线评分主键
     * @return 结果
     */
    public int deleteRouteRatingByRouteId(Long routeId);
}