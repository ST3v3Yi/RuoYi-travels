package com.ruoyi.travels.service;

import java.util.List;
import com.ruoyi.travels.domain.RouteComments;

/**
 * 路线评论Service接口
 * 
 * @author Yifun
 * @date 2023-03-25
 */
public interface IRouteCommentsService 
{
    /**
     * 查询路线评论
     * 
     * @param id 路线评论主键
     * @return 路线评论
     */
    public RouteComments selectRouteCommentsById(Long id);

    /**
     * 查询路线评论列表
     * 
     * @param routeComments 路线评论
     * @return 路线评论集合
     */
    public List<RouteComments> selectRouteCommentsList(RouteComments routeComments);

    /**
     * 获取指定路线的评论列表 List
     */
    public List<RouteComments> selectRouteCommentsListByRouteId(Long routeId);

    /**
     * 新增路线评论
     * 
     * @param routeComments 路线评论
     * @return 结果
     */
    public int insertRouteComments(RouteComments routeComments);

    /**
     * 修改路线评论
     * 
     * @param routeComments 路线评论
     * @return 结果
     */
    public int updateRouteComments(RouteComments routeComments);

    /**
     * 批量删除路线评论
     * 
     * @param ids 需要删除的路线评论主键集合
     * @return 结果
     */
    public int deleteRouteCommentsByIds(Long[] ids);

    /**
     * 删除路线评论信息
     * 
     * @param id 路线评论主键
     * @return 结果
     */
    public int deleteRouteCommentsById(Long id);
}
