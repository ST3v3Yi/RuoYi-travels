package com.ruoyi.travels.mapper;

import java.util.List;
import com.ruoyi.travels.domain.Hotel;

/**
 * 酒店管理Mapper接口
 * 
 * @author Yifun
 * @date 2023-04-22
 */
public interface HotelMapper 
{
    /**
     * 查询酒店管理
     * 
     * @param id 酒店管理主键
     * @return 酒店管理
     */
    public Hotel selectHotelById(Long id);

    /**
     * 查询酒店管理列表
     * 
     * @param hotel 酒店管理
     * @return 酒店管理集合
     */
    public List<Hotel> selectHotelList(Hotel hotel);

    /**
     * 新增酒店管理
     * 
     * @param hotel 酒店管理
     * @return 结果
     */
    public int insertHotel(Hotel hotel);

    /**
     * 修改酒店管理
     * 
     * @param hotel 酒店管理
     * @return 结果
     */
    public int updateHotel(Hotel hotel);

    /**
     * 删除酒店管理
     * 
     * @param id 酒店管理主键
     * @return 结果
     */
    public int deleteHotelById(Long id);

    /**
     * 批量删除酒店管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHotelByIds(Long[] ids);
}
