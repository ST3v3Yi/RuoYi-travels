package com.ruoyi.travels.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travels.mapper.HotelMapper;
import com.ruoyi.travels.domain.Hotel;
import com.ruoyi.travels.service.IHotelService;

/**
 * 酒店管理Service业务层处理
 * 
 * @author Yifun
 * @date 2023-04-22
 */
@Service
public class HotelServiceImpl implements IHotelService 
{
    @Autowired
    private HotelMapper hotelMapper;

    /**
     * 查询酒店管理
     * 
     * @param id 酒店管理主键
     * @return 酒店管理
     */
    @Override
    public Hotel selectHotelById(Long id)
    {
        return hotelMapper.selectHotelById(id);
    }

    /**
     * 查询酒店管理列表
     * 
     * @param hotel 酒店管理
     * @return 酒店管理
     */
    @Override
    public List<Hotel> selectHotelList(Hotel hotel)
    {
        return hotelMapper.selectHotelList(hotel);
    }

    /**
     * 新增酒店管理
     * 
     * @param hotel 酒店管理
     * @return 结果
     */
    @Override
    public int insertHotel(Hotel hotel)
    {
        hotel.setCreateTime(DateUtils.getNowDate());
        return hotelMapper.insertHotel(hotel);
    }

    /**
     * 修改酒店管理
     * 
     * @param hotel 酒店管理
     * @return 结果
     */
    @Override
    public int updateHotel(Hotel hotel)
    {
        hotel.setUpdateTime(DateUtils.getNowDate());
        return hotelMapper.updateHotel(hotel);
    }

    /**
     * 批量删除酒店管理
     * 
     * @param ids 需要删除的酒店管理主键
     * @return 结果
     */
    @Override
    public int deleteHotelByIds(Long[] ids)
    {
        return hotelMapper.deleteHotelByIds(ids);
    }

    /**
     * 删除酒店管理信息
     * 
     * @param id 酒店管理主键
     * @return 结果
     */
    @Override
    public int deleteHotelById(Long id)
    {
        return hotelMapper.deleteHotelById(id);
    }
}
