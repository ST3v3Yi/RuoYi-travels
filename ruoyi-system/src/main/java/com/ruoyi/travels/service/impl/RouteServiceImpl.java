package com.ruoyi.travels.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travels.mapper.RouteMapper;
import com.ruoyi.travels.domain.Route;
import com.ruoyi.travels.service.IRouteService;

/**
 * 路线Service业务层处理
 * 
 * @author Yifun
 * @date 2023-03-09
 */
@Service
public class RouteServiceImpl implements IRouteService 
{
    @Autowired
    private RouteMapper routeMapper;

    /**
     * 查询路线
     * 
     * @param id 路线主键
     * @return 路线
     */
    @Override
    public Route selectRouteById(Long id)
    {
        return routeMapper.selectRouteById(id);
    }

    /**
     * 查询路线列表
     * 
     * @param route 路线
     * @return 路线
     */
    @Override
    public List<Route> selectRouteList(Route route)
    {
        return routeMapper.selectRouteList(route);
    }

    /**
     * 新增路线
     * 
     * @param route 路线
     * @return 结果
     */
    @Override
    public int insertRoute(Route route)
    {
        route.setCreateTime(DateUtils.getNowDate());
        return routeMapper.insertRoute(route);
    }

    /**
     * 修改路线
     * 
     * @param route 路线
     * @return 结果
     */
    @Override
    public int updateRoute(Route route)
    {
        route.setUpdateTime(DateUtils.getNowDate());
        return routeMapper.updateRoute(route);
    }

    /**
     * 批量删除路线
     * 
     * @param ids 需要删除的路线主键
     * @return 结果
     */
    @Override
    public int deleteRouteByIds(Long[] ids)
    {
        return routeMapper.deleteRouteByIds(ids);
    }

    /**
     * 删除路线信息
     * 
     * @param id 路线主键
     * @return 结果
     */
    @Override
    public int deleteRouteById(Long id)
    {
        return routeMapper.deleteRouteById(id);
    }
}