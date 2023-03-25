package com.ruoyi.travels.mapper;

import java.util.List;
import com.ruoyi.travels.domain.RouteReply;

/**
 * 路线回复Mapper接口
 * 
 * @author Yifun
 * @date 2023-03-25
 */
public interface RouteReplyMapper 
{
    /**
     * 查询路线回复
     * 
     * @param id 路线回复主键
     * @return 路线回复
     */
    public RouteReply selectRouteReplyById(Long id);

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
     * 删除路线回复
     * 
     * @param id 路线回复主键
     * @return 结果
     */
    public int deleteRouteReplyById(Long id);

    /**
     * 批量删除路线回复
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRouteReplyByIds(Long[] ids);
}
