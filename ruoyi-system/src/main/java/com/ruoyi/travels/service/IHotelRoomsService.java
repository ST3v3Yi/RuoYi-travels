package com.ruoyi.travels.service;

import java.util.List;
import com.ruoyi.travels.domain.HotelRooms;

/**
 * 酒店房间Service接口
 *
 * @author Yifun
 * @date 2023-04-29
 */
public interface IHotelRoomsService
{
    /**
     * 查询酒店房间
     *
     * @param id 酒店房间主键
     * @return 酒店房间
     */
    public HotelRooms selectHotelRoomsById(Long id);

    /**
     * 获取相应酒店的房间信息
     */
    public List<HotelRooms> selectHotelRoomsByHotelId(Long hotelId);

    /**
     * 获取相应酒店的最低价格
     */
    public double selectHotelMinPriceByHotelId(Long hotelId);

    /**
     * 获取具有对应房型的酒店ID
     */
    public List<HotelRooms> selectHotelIdByRoomType(Long type);

    /**
     *
     * 贪心算法求得酒店可行性
     * 第一步：
     * 获取所有酒店ID
     * getAllHotelId
     *
     */
    public List<Long> selectAllHotelId();

    /**
     * 查询酒店房间列表
     *
     * @param hotelRooms 酒店房间
     * @return 酒店房间集合
     */
    public List<HotelRooms> selectHotelRoomsList(HotelRooms hotelRooms);

    /**
     * 新增酒店房间
     *
     * @param hotelRooms 酒店房间
     * @return 结果
     */
    public int insertHotelRooms(HotelRooms hotelRooms);

    /**
     * 修改酒店房间
     *
     * @param hotelRooms 酒店房间
     * @return 结果
     */
    public int updateHotelRooms(HotelRooms hotelRooms);

    /**
     * 批量删除酒店房间
     *
     * @param ids 需要删除的酒店房间主键集合
     * @return 结果
     */
    public int deleteHotelRoomsByIds(Long[] ids);

    /**
     * 删除酒店房间信息
     *
     * @param id 酒店房间主键
     * @return 结果
     */
    public int deleteHotelRoomsById(Long id);
}
