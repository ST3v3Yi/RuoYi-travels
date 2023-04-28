package com.ruoyi.travels.service;

import java.util.List;
import com.ruoyi.travels.domain.RoomFacilities;

/**
 * 房间设施Service接口
 * 
 * @author Yifun
 * @date 2023-04-28
 */
public interface IRoomFacilitiesService 
{
    /**
     * 查询房间设施
     * 
     * @param id 房间设施主键
     * @return 房间设施
     */
    public RoomFacilities selectRoomFacilitiesById(Long id);

    /**
     * 查询房间设施列表
     * 
     * @param roomFacilities 房间设施
     * @return 房间设施集合
     */
    public List<RoomFacilities> selectRoomFacilitiesList(RoomFacilities roomFacilities);

    /**
     * 新增房间设施
     * 
     * @param roomFacilities 房间设施
     * @return 结果
     */
    public int insertRoomFacilities(RoomFacilities roomFacilities);

    /**
     * 修改房间设施
     * 
     * @param roomFacilities 房间设施
     * @return 结果
     */
    public int updateRoomFacilities(RoomFacilities roomFacilities);

    /**
     * 批量删除房间设施
     * 
     * @param ids 需要删除的房间设施主键集合
     * @return 结果
     */
    public int deleteRoomFacilitiesByIds(Long[] ids);

    /**
     * 删除房间设施信息
     * 
     * @param id 房间设施主键
     * @return 结果
     */
    public int deleteRoomFacilitiesById(Long id);
}
