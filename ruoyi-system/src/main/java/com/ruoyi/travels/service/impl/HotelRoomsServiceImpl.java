package com.ruoyi.travels.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travels.mapper.HotelRoomsMapper;
import com.ruoyi.travels.domain.HotelRooms;
import com.ruoyi.travels.service.IHotelRoomsService;

/**
 * 酒店房间Service业务层处理
 * 
 * @author Yifun
 * @date 2023-04-28
 */
@Service
public class HotelRoomsServiceImpl implements IHotelRoomsService 
{
    @Autowired
    private HotelRoomsMapper hotelRoomsMapper;

    /**
     * 查询酒店房间
     * 
     * @param id 酒店房间主键
     * @return 酒店房间
     */
    @Override
    public HotelRooms selectHotelRoomsById(Long id)
    {
        return hotelRoomsMapper.selectHotelRoomsById(id);
    }

    /**
     * 查询酒店房间列表
     * 
     * @param hotelRooms 酒店房间
     * @return 酒店房间
     */
    @Override
    public List<HotelRooms> selectHotelRoomsList(HotelRooms hotelRooms)
    {
        return hotelRoomsMapper.selectHotelRoomsList(hotelRooms);
    }

    /**
     * 新增酒店房间
     * 
     * @param hotelRooms 酒店房间
     * @return 结果
     */
    @Override
    public int insertHotelRooms(HotelRooms hotelRooms)
    {
        return hotelRoomsMapper.insertHotelRooms(hotelRooms);
    }

    /**
     * 修改酒店房间
     * 
     * @param hotelRooms 酒店房间
     * @return 结果
     */
    @Override
    public int updateHotelRooms(HotelRooms hotelRooms)
    {
        return hotelRoomsMapper.updateHotelRooms(hotelRooms);
    }

    /**
     * 批量删除酒店房间
     * 
     * @param ids 需要删除的酒店房间主键
     * @return 结果
     */
    @Override
    public int deleteHotelRoomsByIds(Long[] ids)
    {
        return hotelRoomsMapper.deleteHotelRoomsByIds(ids);
    }

    /**
     * 删除酒店房间信息
     * 
     * @param id 酒店房间主键
     * @return 结果
     */
    @Override
    public int deleteHotelRoomsById(Long id)
    {
        return hotelRoomsMapper.deleteHotelRoomsById(id);
    }
}
