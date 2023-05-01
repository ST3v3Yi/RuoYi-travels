package com.ruoyi.travels.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travels.mapper.HotelCommentsMapper;
import com.ruoyi.travels.domain.HotelComments;
import com.ruoyi.travels.service.IHotelCommentsService;

/**
 * 酒店点评Service业务层处理
 * 
 * @author Yifun
 * @date 2023-05-01
 */
@Service
public class HotelCommentsServiceImpl implements IHotelCommentsService 
{
    @Autowired
    private HotelCommentsMapper hotelCommentsMapper;

    /**
     * 查询酒店点评
     * 
     * @param id 酒店点评主键
     * @return 酒店点评
     */
    @Override
    public HotelComments selectHotelCommentsById(Long id)
    {
        return hotelCommentsMapper.selectHotelCommentsById(id);
    }

    /**
     * 查询酒店点评列表
     * 
     * @param hotelComments 酒店点评
     * @return 酒店点评
     */
    @Override
    public List<HotelComments> selectHotelCommentsList(HotelComments hotelComments)
    {
        return hotelCommentsMapper.selectHotelCommentsList(hotelComments);
    }

    /**
     * 获取酒店点评列表
     */
    @Override
    public List<HotelComments> selectHotelCommentsByHotelId(Long hotelId)
    {
        return hotelCommentsMapper.selectHotelCommentsByHotelId(hotelId);
    }

    /**
     * 获取酒店评分
     */
    @Override
    public HotelComments selectHotelRatingByHotelId(Long hotelId)
    {
        return hotelCommentsMapper.selectHotelRatingByHotelId(hotelId);
    }

    /**
     * 新增酒店点评
     * 
     * @param hotelComments 酒店点评
     * @return 结果
     */
    @Override
    public int insertHotelComments(HotelComments hotelComments)
    {
        hotelComments.setCreateTime(DateUtils.getNowDate());
        return hotelCommentsMapper.insertHotelComments(hotelComments);
    }

    /**
     * 修改酒店点评
     * 
     * @param hotelComments 酒店点评
     * @return 结果
     */
    @Override
    public int updateHotelComments(HotelComments hotelComments)
    {
        return hotelCommentsMapper.updateHotelComments(hotelComments);
    }

    /**
     * 批量删除酒店点评
     * 
     * @param ids 需要删除的酒店点评主键
     * @return 结果
     */
    @Override
    public int deleteHotelCommentsByIds(Long[] ids)
    {
        return hotelCommentsMapper.deleteHotelCommentsByIds(ids);
    }

    /**
     * 删除酒店点评信息
     * 
     * @param id 酒店点评主键
     * @return 结果
     */
    @Override
    public int deleteHotelCommentsById(Long id)
    {
        return hotelCommentsMapper.deleteHotelCommentsById(id);
    }
}
