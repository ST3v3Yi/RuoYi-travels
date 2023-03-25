package com.ruoyi.travels.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travels.mapper.RouteReplyMapper;
import com.ruoyi.travels.domain.RouteReply;
import com.ruoyi.travels.service.IRouteReplyService;

/**
 * 路线回复Service业务层处理
 * 
 * @author Yifun
 * @date 2023-03-25
 */
@Service
public class RouteReplyServiceImpl implements IRouteReplyService 
{
    @Autowired
    private RouteReplyMapper routeReplyMapper;

    /**
     * 查询路线回复
     * 
     * @param id 路线回复主键
     * @return 路线回复
     */
    @Override
    public RouteReply selectRouteReplyById(Long id)
    {
        return routeReplyMapper.selectRouteReplyById(id);
    }

    /**
     * 查询路线回复列表
     * 
     * @param routeReply 路线回复
     * @return 路线回复
     */
    @Override
    public List<RouteReply> selectRouteReplyList(RouteReply routeReply)
    {
        return routeReplyMapper.selectRouteReplyList(routeReply);
    }

    /**
     * 新增路线回复
     * 
     * @param routeReply 路线回复
     * @return 结果
     */
    @Override
    public int insertRouteReply(RouteReply routeReply)
    {
        routeReply.setCreateTime(DateUtils.getNowDate());
        return routeReplyMapper.insertRouteReply(routeReply);
    }

    /**
     * 修改路线回复
     * 
     * @param routeReply 路线回复
     * @return 结果
     */
    @Override
    public int updateRouteReply(RouteReply routeReply)
    {
        return routeReplyMapper.updateRouteReply(routeReply);
    }

    /**
     * 批量删除路线回复
     * 
     * @param ids 需要删除的路线回复主键
     * @return 结果
     */
    @Override
    public int deleteRouteReplyByIds(Long[] ids)
    {
        return routeReplyMapper.deleteRouteReplyByIds(ids);
    }

    /**
     * 删除路线回复信息
     * 
     * @param id 路线回复主键
     * @return 结果
     */
    @Override
    public int deleteRouteReplyById(Long id)
    {
        return routeReplyMapper.deleteRouteReplyById(id);
    }
}
