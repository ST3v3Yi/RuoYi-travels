package com.ruoyi.travels.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.travels.domain.RecRoute;
import com.ruoyi.travels.domain.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travels.mapper.RouteMapper;
import com.ruoyi.travels.domain.Route;
import com.ruoyi.travels.service.IRouteService;

/**
 * 路线Service业务层处理
 * 
 * @author Yifun
 * @date 2023-03-11
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
     * 查询发布路线列表
     *
     * @return 路线
     */
    @Override
    public List<Route> selectReleasedRouteList()
    {
        return routeMapper.selectReleasedRouteList();
    }

    /**
     * 获取相应天数限制内的列表
     */
    @Override
    public List<Route> selectRouteByDay(Route route)
    {
        return routeMapper.selectRouteByDay(route);
    }

    /**
     * 获取相应花费限制内的列表
     */
    @Override
    public List<Route> selectRouteByPrice(Route route)
    {
        return routeMapper.selectRouteByPrice(route);
    }

    /**
     * 获取待推荐路线信息
     */
    @Override
    public List<RecRoute> selectRecRoute()
    {
        return routeMapper.selectRecRoute();
    }

    /**
     * 获取最大Id
     */
    @Override
    public Long selectMAXId()
    {
        return routeMapper.selectMAXId();
    }

    /**
     * 获取当前用户近30天的路线浏览及互动信息
     * @return
     */
    @Override
    public List<Record> selectRecordAboutRouteByUserId(Long userId)
    {
        return routeMapper.selectRecordAboutRouteByUserId(userId);
    }

    /**
     * 获取相应用户的路线攻略
     */
    @Override
    public List<Route> selectRouteByUserId(Long userId)
    {
        return routeMapper.selectRouteByUserId(userId);
    }

    /**
     * 获取用户路线数量
     */
    @Override
    public Integer selectRouteNumByUserId(Long userId)
    {
        return routeMapper.selectRouteNumByUserId(userId);
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
