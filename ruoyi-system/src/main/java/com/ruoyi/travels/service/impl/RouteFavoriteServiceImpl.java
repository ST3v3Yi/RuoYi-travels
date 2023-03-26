package com.ruoyi.travels.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travels.mapper.RouteFavoriteMapper;
import com.ruoyi.travels.domain.RouteFavorite;
import com.ruoyi.travels.service.IRouteFavoriteService;

/**
 * 路线收藏Service业务层处理
 * 
 * @author Yifun
 * @date 2023-03-27
 */
@Service
public class RouteFavoriteServiceImpl implements IRouteFavoriteService 
{
    @Autowired
    private RouteFavoriteMapper routeFavoriteMapper;

    /**
     * 查询路线收藏
     * 
     * @param userId 路线收藏主键
     * @return 路线收藏
     */
    @Override
    public RouteFavorite selectRouteFavoriteByUserId(Long userId)
    {
        return routeFavoriteMapper.selectRouteFavoriteByUserId(userId);
    }

    /**
     * 查询路线收藏列表
     * 
     * @param routeFavorite 路线收藏
     * @return 路线收藏
     */
    @Override
    public List<RouteFavorite> selectRouteFavoriteList(RouteFavorite routeFavorite)
    {
        return routeFavoriteMapper.selectRouteFavoriteList(routeFavorite);
    }

    /**
     * 新增路线收藏
     * 
     * @param routeFavorite 路线收藏
     * @return 结果
     */
    @Override
    public int insertRouteFavorite(RouteFavorite routeFavorite)
    {
        routeFavorite.setCreateTime(DateUtils.getNowDate());
        return routeFavoriteMapper.insertRouteFavorite(routeFavorite);
    }

    /**
     * 修改路线收藏
     * 
     * @param routeFavorite 路线收藏
     * @return 结果
     */
    @Override
    public int updateRouteFavorite(RouteFavorite routeFavorite)
    {
        return routeFavoriteMapper.updateRouteFavorite(routeFavorite);
    }

    /**
     * 批量删除路线收藏
     * 
     * @param userIds 需要删除的路线收藏主键
     * @return 结果
     */
    @Override
    public int deleteRouteFavoriteByUserIds(Long[] userIds)
    {
        return routeFavoriteMapper.deleteRouteFavoriteByUserIds(userIds);
    }

    /**
     * 删除路线收藏信息
     * 
     * @param userId 路线收藏主键
     * @return 结果
     */
    @Override
    public int deleteRouteFavoriteByUserId(Long userId)
    {
        return routeFavoriteMapper.deleteRouteFavoriteByUserId(userId);
    }
}
