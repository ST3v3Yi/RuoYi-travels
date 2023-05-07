package com.ruoyi.travels.mapper;

import java.util.List;
import com.ruoyi.travels.domain.HotelOrders;

/**
 * 酒店订单Mapper接口
 * 
 * @author Yifun
 * @date 2023-05-07
 */
public interface HotelOrdersMapper 
{
    /**
     * 查询酒店订单
     * 
     * @param id 酒店订单主键
     * @return 酒店订单
     */
    public HotelOrders selectHotelOrdersById(Long id);

    /**
     * 查询酒店订单列表
     * 
     * @param hotelOrders 酒店订单
     * @return 酒店订单集合
     */
    public List<HotelOrders> selectHotelOrdersList(HotelOrders hotelOrders);

    /**
     * 新增酒店订单
     * 
     * @param hotelOrders 酒店订单
     * @return 结果
     */
    public int insertHotelOrders(HotelOrders hotelOrders);

    /**
     * 修改酒店订单
     * 
     * @param hotelOrders 酒店订单
     * @return 结果
     */
    public int updateHotelOrders(HotelOrders hotelOrders);

    /**
     * 删除酒店订单
     * 
     * @param id 酒店订单主键
     * @return 结果
     */
    public int deleteHotelOrdersById(Long id);

    /**
     * 批量删除酒店订单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHotelOrdersByIds(Long[] ids);
}
