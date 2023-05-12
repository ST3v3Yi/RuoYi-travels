package com.ruoyi.travels.mapper;

import java.util.List;

import com.ruoyi.travels.domain.RouteFavorite;
import com.ruoyi.travels.domain.SpotFavorite;
import com.ruoyi.travels.domain.UserSpotFavorite;

/**
 * 景区收藏Mapper接口
 * 
 * @author Yifun
 * @date 2023-04-13
 */
public interface SpotFavoriteMapper 
{
    /**
     * 查询景区收藏
     * 
     * @param userId 景区收藏主键
     * @return 景区收藏
     */
    public SpotFavorite selectSpotFavoriteByUserId(Long userId);

    /**
     * 查询景区收藏列表
     * 
     * @param spotFavorite 景区收藏
     * @return 景区收藏集合
     */
    public List<SpotFavorite> selectSpotFavoriteList(SpotFavorite spotFavorite);

    /** 获取用户是否收藏景点 */
    public Boolean selectIsFavorite(SpotFavorite spotFavorite);

    /**
     * 获取用户收藏景点信息
     */
    public List<UserSpotFavorite> selectFavoriteSpotByUserId(Long userId);

    /**
     * 新增景区收藏
     * 
     * @param spotFavorite 景区收藏
     * @return 结果
     */
    public int insertSpotFavorite(SpotFavorite spotFavorite);

    /**
     * 修改景区收藏
     * 
     * @param spotFavorite 景区收藏
     * @return 结果
     */
    public int updateSpotFavorite(SpotFavorite spotFavorite);

    /**
     * 删除景区收藏
     * 
     * @param userId 景区收藏主键
     * @return 结果
     */
    public int deleteSpotFavoriteByUserId(Long userId);

    /**
     * 批量删除景区收藏
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSpotFavoriteByUserIds(Long[] userIds);

    /**
     * 删除景点收藏
     *
     */
    public int deleteSpotFavorite(SpotFavorite spotFavorite);
}
