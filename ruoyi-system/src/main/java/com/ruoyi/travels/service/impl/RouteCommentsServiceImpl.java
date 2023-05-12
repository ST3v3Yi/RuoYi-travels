package com.ruoyi.travels.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.travels.domain.UserRouteComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travels.mapper.RouteCommentsMapper;
import com.ruoyi.travels.domain.RouteComments;
import com.ruoyi.travels.service.IRouteCommentsService;

/**
 * 路线评论Service业务层处理
 * 
 * @author Yifun
 * @date 2023-03-25
 */
@Service
public class RouteCommentsServiceImpl implements IRouteCommentsService 
{
    @Autowired
    private RouteCommentsMapper routeCommentsMapper;

    /**
     * 查询路线评论
     * 
     * @param id 路线评论主键
     * @return 路线评论
     */
    @Override
    public RouteComments selectRouteCommentsById(Long id)
    {
        return routeCommentsMapper.selectRouteCommentsById(id);
    }

    /**
     * 查询路线评论列表
     * 
     * @param routeComments 路线评论
     * @return 路线评论
     */
    @Override
    public List<RouteComments> selectRouteCommentsList(RouteComments routeComments)
    {
        return routeCommentsMapper.selectRouteCommentsList(routeComments);
    }

    /**
     * 获取指定路线的评论列表 List
     *
     */
    public List<RouteComments> selectRouteCommentsListByRouteId(Long routeId)
    {
        return routeCommentsMapper.selectRouteCommentsListByRouteId(routeId);
    }

    /**
     * 获取相应用户的评论
     */
    public List<UserRouteComments> selectRouteCommentsByUserId(Long userId)
    {
        return routeCommentsMapper.selectRouteCommentsByUserId(userId);
    }

    /**
     * 获取用户评论数量
     */
    public Integer selectRouteCommentsNumByUserId(Long userId)
    {
        return routeCommentsMapper.selectRouteCommentsNumByUserId(userId);
    }

    /**
     * 新增路线评论
     * 
     * @param routeComments 路线评论
     * @return 结果
     */
    @Override
    public int insertRouteComments(RouteComments routeComments)
    {
        routeComments.setCreateTime(DateUtils.getNowDate());
        return routeCommentsMapper.insertRouteComments(routeComments);
    }

    /**
     * 修改路线评论
     * 
     * @param routeComments 路线评论
     * @return 结果
     */
    @Override
    public int updateRouteComments(RouteComments routeComments)
    {
        return routeCommentsMapper.updateRouteComments(routeComments);
    }

    /**
     * 批量删除路线评论
     * 
     * @param ids 需要删除的路线评论主键
     * @return 结果
     */
    @Override
    public int deleteRouteCommentsByIds(Long[] ids)
    {
        return routeCommentsMapper.deleteRouteCommentsByIds(ids);
    }

    /**
     * 删除路线评论信息
     * 
     * @param id 路线评论主键
     * @return 结果
     */
    @Override
    public int deleteRouteCommentsById(Long id)
    {
        return routeCommentsMapper.deleteRouteCommentsById(id);
    }
}
