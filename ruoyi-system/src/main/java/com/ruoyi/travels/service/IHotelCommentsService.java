package com.ruoyi.travels.service;

import java.util.List;
import com.ruoyi.travels.domain.HotelComments;

/**
 * 酒店点评Service接口
 * 
 * @author Yifun
 * @date 2023-05-01
 */
public interface IHotelCommentsService 
{
    /**
     * 查询酒店点评
     * 
     * @param id 酒店点评主键
     * @return 酒店点评
     */
    public HotelComments selectHotelCommentsById(Long id);

    /**
     * 查询酒店点评列表
     * 
     * @param hotelComments 酒店点评
     * @return 酒店点评集合
     */
    public List<HotelComments> selectHotelCommentsList(HotelComments hotelComments);

    /**
     * 获取酒店点评列表
     */
    public List<HotelComments> selectHotelCommentsByHotelId(Long hotelId);

    /**
     * 获取酒店评分
     */
    public HotelComments selectHotelRatingByHotelId(Long hotelId);

    /**
     * 新增酒店点评
     * 
     * @param hotelComments 酒店点评
     * @return 结果
     */
    public int insertHotelComments(HotelComments hotelComments);

    /**
     * 修改酒店点评
     * 
     * @param hotelComments 酒店点评
     * @return 结果
     */
    public int updateHotelComments(HotelComments hotelComments);

    /**
     * 批量删除酒店点评
     * 
     * @param ids 需要删除的酒店点评主键集合
     * @return 结果
     */
    public int deleteHotelCommentsByIds(Long[] ids);

    /**
     * 删除酒店点评信息
     * 
     * @param id 酒店点评主键
     * @return 结果
     */
    public int deleteHotelCommentsById(Long id);
}
