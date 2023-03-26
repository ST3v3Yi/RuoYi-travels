package com.ruoyi.travels.service;

import java.util.List;
import com.ruoyi.travels.domain.RouteReply;
import com.ruoyi.travels.domain.RouteReplyList;

/**
 * 路线回复Service接口
 * 
 * @author Yifun
 * @date 2023-03-25
 */
public interface IRouteReplyService 
{
    /**
     * 查询路线回复
     * 
     * @param id 路线回复主键
     * @return 路线回复
     */
    public RouteReply selectRouteReplyById(Long id);

    /**
     * 根据评论ID查询回复
     */
    public List<RouteReplyList> selectRouteReplyByCommentId(Long commentId);

    /**
     * 查询路线回复列表
     * 
     * @param routeReply 路线回复
     * @return 路线回复集合
     */
    public List<RouteReply> selectRouteReplyList(RouteReply routeReply);

    /**
     * 新增路线回复
     * 
     * @param routeReply 路线回复
     * @return 结果
     */
    public int insertRouteReply(RouteReply routeReply);

    /**
     * 修改路线回复
     * 
     * @param routeReply 路线回复
     * @return 结果
     */
    public int updateRouteReply(RouteReply routeReply);

    /**
     * 批量删除路线回复
     * 
     * @param ids 需要删除的路线回复主键集合
     * @return 结果
     */
    public int deleteRouteReplyByIds(Long[] ids);

    /**
     * 删除路线回复信息
     * 
     * @param id 路线回复主键
     * @return 结果
     */
    public int deleteRouteReplyById(Long id);
}
