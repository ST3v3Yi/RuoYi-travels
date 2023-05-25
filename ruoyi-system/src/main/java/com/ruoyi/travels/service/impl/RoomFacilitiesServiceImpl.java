package com.ruoyi.travels.service.impl;

import java.util.List;

import com.ruoyi.travels.domain.RoomFacility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travels.mapper.RoomFacilitiesMapper;
import com.ruoyi.travels.domain.RoomFacilities;
import com.ruoyi.travels.service.IRoomFacilitiesService;

/**
 * 房间设施Service业务层处理
 * 
 * @author Yifun
 * @date 2023-04-28
 */
@Service
public class RoomFacilitiesServiceImpl implements IRoomFacilitiesService 
{
    @Autowired
    private RoomFacilitiesMapper roomFacilitiesMapper;

    /**
     * 查询房间设施
     * 
     * @param id 房间设施主键
     * @return 房间设施
     */
    @Override
    public RoomFacilities selectRoomFacilitiesById(Long id)
    {
        return roomFacilitiesMapper.selectRoomFacilitiesById(id);
    }

    /**
     * 查询房间设施列表
     * 
     * @param roomFacilities 房间设施
     * @return 房间设施
     */
    @Override
    public List<RoomFacilities> selectRoomFacilitiesList(RoomFacilities roomFacilities)
    {
        return roomFacilitiesMapper.selectRoomFacilitiesList(roomFacilities);
    }

    /**
     * 获取相应房间的设施信息
     */
    @Override
    public List<RoomFacility> selectRoomFacilitiesByRoomId(Long roomId)
    {
        return roomFacilitiesMapper.selectRoomFacilitiesByRoomId(roomId);
    }

    /**
     * 新增房间设施
     * 
     * @param roomFacilities 房间设施
     * @return 结果
     */
    @Override
    public int insertRoomFacilities(RoomFacilities roomFacilities)
    {
        return roomFacilitiesMapper.insertRoomFacilities(roomFacilities);
    }

    /**
     * 修改房间设施
     * 
     * @param roomFacilities 房间设施
     * @return 结果
     */
    @Override
    public int updateRoomFacilities(RoomFacilities roomFacilities)
    {
        return roomFacilitiesMapper.updateRoomFacilities(roomFacilities);
    }

    /**
     * 批量删除房间设施
     * 
     * @param ids 需要删除的房间设施主键
     * @return 结果
     */
    @Override
    public int deleteRoomFacilitiesByIds(Long[] ids)
    {
        return roomFacilitiesMapper.deleteRoomFacilitiesByIds(ids);
    }

    /**
     * 删除房间设施信息
     * 
     * @param id 房间设施主键
     * @return 结果
     */
    @Override
    public int deleteRoomFacilitiesById(Long id)
    {
        return roomFacilitiesMapper.deleteRoomFacilitiesById(id);
    }
}
