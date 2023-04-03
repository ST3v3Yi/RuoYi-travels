package com.ruoyi.travels.service;

import java.util.List;
import com.ruoyi.travels.domain.RouteFavorite;

/**
 * 路线收藏Service接口
 * 
 * @author Yifun
 * @date 2023-03-27
 */
public interface IRouteFavoriteService 
{
    /**
     * 查询路线收藏
     * 
     * @param userId 路线收藏主键
     * @return 路线收藏
     */
    public RouteFavorite selectRouteFavoriteByUserId(Long userId);

    /**
     * 查询路线收藏列表
     * 
     * @param routeFavorite 路线收藏
     * @return 路线收藏集合
     */
    public List<RouteFavorite> selectRouteFavoriteList(RouteFavorite routeFavorite);

    /**
     * 获取用户是否收藏路线
     */
    public Boolean selectIsFavorite(RouteFavorite routeFavorite);

    /**
     * 新增路线收藏
     * 
     * @param routeFavorite 路线收藏
     * @return 结果
     */
    public int insertRouteFavorite(RouteFavorite routeFavorite);

    /**
     * 修改路线收藏
     * 
     * @param routeFavorite 路线收藏
     * @return 结果
     */
    public int updateRouteFavorite(RouteFavorite routeFavorite);

    /**
     * 批量删除路线收藏
     * 
     * @param userIds 需要删除的路线收藏主键集合
     * @return 结果
     */
    public int deleteRouteFavoriteByUserIds(Long[] userIds);

    /**
     * 删除路线收藏信息
     * 
     * @param userId 路线收藏主键
     * @return 结果
     */
    public int deleteRouteFavoriteByUserId(Long userId);

    /**
     * 删除路线收藏信息
     *
     */
    public int deleteRouteFavorite(RouteFavorite routeFavorite);
}
