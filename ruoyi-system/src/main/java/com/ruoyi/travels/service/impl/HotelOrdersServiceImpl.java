package com.ruoyi.travels.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travels.mapper.HotelOrdersMapper;
import com.ruoyi.travels.domain.HotelOrders;
import com.ruoyi.travels.service.IHotelOrdersService;

/**
 * 酒店订单Service业务层处理
 * 
 * @author Yifun
 * @date 2023-05-07
 */
@Service
public class HotelOrdersServiceImpl implements IHotelOrdersService 
{
    @Autowired
    private HotelOrdersMapper hotelOrdersMapper;

    /**
     * 查询酒店订单
     * 
     * @param id 酒店订单主键
     * @return 酒店订单
     */
    @Override
    public HotelOrders selectHotelOrdersById(Long id)
    {
        return hotelOrdersMapper.selectHotelOrdersById(id);
    }

    /**
     * 查询酒店订单列表
     * 
     * @param hotelOrders 酒店订单
     * @return 酒店订单
     */
    @Override
    public List<HotelOrders> selectHotelOrdersList(HotelOrders hotelOrders)
    {
        return hotelOrdersMapper.selectHotelOrdersList(hotelOrders);
    }

    /**
     * 新增酒店订单
     * 
     * @param hotelOrders 酒店订单
     * @return 结果
     */
    @Override
    public int insertHotelOrders(HotelOrders hotelOrders)
    {
        hotelOrders.setCreateTime(DateUtils.getNowDate());
        return hotelOrdersMapper.insertHotelOrders(hotelOrders);
    }

    /**
     * 修改酒店订单
     * 
     * @param hotelOrders 酒店订单
     * @return 结果
     */
    @Override
    public int updateHotelOrders(HotelOrders hotelOrders)
    {
        hotelOrders.setUpdateTime(DateUtils.getNowDate());
        return hotelOrdersMapper.updateHotelOrders(hotelOrders);
    }

    /**
     * 批量删除酒店订单
     * 
     * @param ids 需要删除的酒店订单主键
     * @return 结果
     */
    @Override
    public int deleteHotelOrdersByIds(Long[] ids)
    {
        return hotelOrdersMapper.deleteHotelOrdersByIds(ids);
    }

    /**
     * 删除酒店订单信息
     * 
     * @param id 酒店订单主键
     * @return 结果
     */
    @Override
    public int deleteHotelOrdersById(Long id)
    {
        return hotelOrdersMapper.deleteHotelOrdersById(id);
    }
}
