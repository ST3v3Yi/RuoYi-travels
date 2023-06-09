package com.ruoyi.travels.service;

import java.util.List;

import com.ruoyi.travels.domain.RecRoute;
import com.ruoyi.travels.domain.Record;
import com.ruoyi.travels.domain.Route;

/**
 * 路线Service接口
 * 
 * @author Yifun
 * @date 2023-03-11
 */
public interface IRouteService 
{
    /**
     * 查询路线
     * 
     * @param id 路线主键
     * @return 路线
     */
    public Route selectRouteById(Long id);

    /**
     * 查询路线列表
     * 
     * @param route 路线
     * @return 路线集合
     */
    public List<Route> selectRouteList(Route route);

    /**
     * 查询发布路线列表
     *
     * @return 路线集合
     */
    public List<Route> selectReleasedRouteList();

    /**
     * 获取相应天数限制内的列表
     */
    public List<Route> selectRouteByDay(Route route);

    /**
     * 获取相应花费限制内的列表
     */
    public List<Route> selectRouteByPrice(Route route);

    /**
     * 获取待推荐路线信息
     */
    public List<RecRoute> selectRecRoute();

    /**
     * 获取最大Id
     */
    public Long selectMAXId();

    /**
     * 获取当前用户近30天的路线浏览及互动信息
     * @return
     */
    public List<Record> selectRecordAboutRouteByUserId(Long userId);

    /**
     * 获取相应用户的路线攻略
     */
    public List<Route> selectRouteByUserId(Long userId);

    /**
     * 获取用户路线数量
     */
    public Integer selectRouteNumByUserId(Long userId);

    /**
     * 新增路线
     * 
     * @param route 路线
     * @return 结果
     */
    public int insertRoute(Route route);

    /**
     * 修改路线
     * 
     * @param route 路线
     * @return 结果
     */
    public int updateRoute(Route route);

    /**
     * 批量删除路线
     * 
     * @param ids 需要删除的路线主键集合
     * @return 结果
     */
    public int deleteRouteByIds(Long[] ids);

    /**
     * 删除路线信息
     * 
     * @param id 路线主键
     * @return 结果
     */
    public int deleteRouteById(Long id);
}
