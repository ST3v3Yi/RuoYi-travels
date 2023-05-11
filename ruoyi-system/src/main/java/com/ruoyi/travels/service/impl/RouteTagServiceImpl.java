package com.ruoyi.travels.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travels.mapper.RouteTagMapper;
import com.ruoyi.travels.domain.RouteTag;
import com.ruoyi.travels.service.IRouteTagService;

/**
 * 路线TagService业务层处理
 * 
 * @author Yifun
 * @date 2023-05-10
 */
@Service
public class RouteTagServiceImpl implements IRouteTagService 
{
    @Autowired
    private RouteTagMapper routeTagMapper;

    /**
     * 查询路线Tag
     * 
     * @param id 路线Tag主键
     * @return 路线Tag
     */
    @Override
    public RouteTag selectRouteTagById(Long id)
    {
        return routeTagMapper.selectRouteTagById(id);
    }

    /**
     * 查询路线Tag列表
     * 
     * @param routeTag 路线Tag
     * @return 路线Tag
     */
    @Override
    public List<RouteTag> selectRouteTagList(RouteTag routeTag)
    {
        return routeTagMapper.selectRouteTagList(routeTag);
    }

    /**
     * 新增路线Tag
     * 
     * @param routeTag 路线Tag
     * @return 结果
     */
    @Override
    public int insertRouteTag(RouteTag routeTag)
    {
        return routeTagMapper.insertRouteTag(routeTag);
    }

    /**
     * 修改路线Tag
     * 
     * @param routeTag 路线Tag
     * @return 结果
     */
    @Override
    public int updateRouteTag(RouteTag routeTag)
    {
        return routeTagMapper.updateRouteTag(routeTag);
    }

    /**
     * 批量删除路线Tag
     * 
     * @param ids 需要删除的路线Tag主键
     * @return 结果
     */
    @Override
    public int deleteRouteTagByIds(Long[] ids)
    {
        return routeTagMapper.deleteRouteTagByIds(ids);
    }

    /**
     * 删除路线Tag信息
     * 
     * @param id 路线Tag主键
     * @return 结果
     */
    @Override
    public int deleteRouteTagById(Long id)
    {
        return routeTagMapper.deleteRouteTagById(id);
    }
}
