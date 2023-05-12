package com.ruoyi.travels.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.travels.domain.RouteFavorite;
import com.ruoyi.travels.domain.UserSpotFavorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travels.mapper.SpotFavoriteMapper;
import com.ruoyi.travels.domain.SpotFavorite;
import com.ruoyi.travels.service.ISpotFavoriteService;

/**
 * 景区收藏Service业务层处理
 * 
 * @author Yifun
 * @date 2023-04-13
 */
@Service
public class SpotFavoriteServiceImpl implements ISpotFavoriteService 
{
    @Autowired
    private SpotFavoriteMapper spotFavoriteMapper;

    /**
     * 查询景区收藏
     * 
     * @param userId 景区收藏主键
     * @return 景区收藏
     */
    @Override
    public SpotFavorite selectSpotFavoriteByUserId(Long userId)
    {
        return spotFavoriteMapper.selectSpotFavoriteByUserId(userId);
    }

    /**
     * 查询景区收藏列表
     * 
     * @param spotFavorite 景区收藏
     * @return 景区收藏
     */
    @Override
    public List<SpotFavorite> selectSpotFavoriteList(SpotFavorite spotFavorite)
    {
        return spotFavoriteMapper.selectSpotFavoriteList(spotFavorite);
    }

    /** 获取用户是否收藏景点 */
    @Override
    public Boolean selectIsFavorite(SpotFavorite spotFavorite)
    {
        return spotFavoriteMapper.selectIsFavorite(spotFavorite);
    }

    /**
     * 获取用户收藏景点信息
     */
    @Override
    public List<UserSpotFavorite> selectFavoriteSpotByUserId(Long userId)
    {
        return spotFavoriteMapper.selectFavoriteSpotByUserId(userId);
    }

    /**
     * 新增景区收藏
     * 
     * @param spotFavorite 景区收藏
     * @return 结果
     */
    @Override
    public int insertSpotFavorite(SpotFavorite spotFavorite)
    {
        spotFavorite.setCreateTime(DateUtils.getNowDate());
        return spotFavoriteMapper.insertSpotFavorite(spotFavorite);
    }

    /**
     * 修改景区收藏
     * 
     * @param spotFavorite 景区收藏
     * @return 结果
     */
    @Override
    public int updateSpotFavorite(SpotFavorite spotFavorite)
    {
        return spotFavoriteMapper.updateSpotFavorite(spotFavorite);
    }

    /**
     * 批量删除景区收藏
     * 
     * @param userIds 需要删除的景区收藏主键
     * @return 结果
     */
    @Override
    public int deleteSpotFavoriteByUserIds(Long[] userIds)
    {
        return spotFavoriteMapper.deleteSpotFavoriteByUserIds(userIds);
    }

    /**
     * 删除景区收藏信息
     * 
     * @param userId 景区收藏主键
     * @return 结果
     */
    @Override
    public int deleteSpotFavoriteByUserId(Long userId)
    {
        return spotFavoriteMapper.deleteSpotFavoriteByUserId(userId);
    }

    /**
     * 删除景点收藏信息
     *
     */
    @Override
    public int deleteSpotFavorite(SpotFavorite spotFavorite)
    {
        return spotFavoriteMapper.deleteSpotFavorite(spotFavorite);
    }
}
