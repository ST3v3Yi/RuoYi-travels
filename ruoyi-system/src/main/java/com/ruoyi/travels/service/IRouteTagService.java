package com.ruoyi.travels.service;

import java.util.List;
import com.ruoyi.travels.domain.RouteTag;

/**
 * 路线TagService接口
 * 
 * @author Yifun
 * @date 2023-05-10
 */
public interface IRouteTagService 
{
    /**
     * 查询路线Tag
     * 
     * @param id 路线Tag主键
     * @return 路线Tag
     */
    public RouteTag selectRouteTagById(Long id);

    /**
     * 查询路线Tag列表
     * 
     * @param routeTag 路线Tag
     * @return 路线Tag集合
     */
    public List<RouteTag> selectRouteTagList(RouteTag routeTag);

    /**
     * 新增路线Tag
     * 
     * @param routeTag 路线Tag
     * @return 结果
     */
    public int insertRouteTag(RouteTag routeTag);

    /**
     * 修改路线Tag
     * 
     * @param routeTag 路线Tag
     * @return 结果
     */
    public int updateRouteTag(RouteTag routeTag);

    /**
     * 批量删除路线Tag
     * 
     * @param ids 需要删除的路线Tag主键集合
     * @return 结果
     */
    public int deleteRouteTagByIds(Long[] ids);

    /**
     * 删除路线Tag信息
     * 
     * @param id 路线Tag主键
     * @return 结果
     */
    public int deleteRouteTagById(Long id);
}
