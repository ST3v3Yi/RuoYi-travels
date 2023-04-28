package com.ruoyi.travels.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 房间设施对象 tb_room_facilities
 * 
 * @author Yifun
 * @date 2023-04-28
 */
public class RoomFacilities extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 房间id */
    @Excel(name = "房间id")
    private Long roomId;

    /** 设施id */
    @Excel(name = "设施id")
    private Long facilityId;

    /** 是否免费（0：不免费 1：免费） */
    @Excel(name = "是否免费", readConverterExp = "0=：不免费,1=：免费")
    private Integer isFree;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRoomId(Long roomId) 
    {
        this.roomId = roomId;
    }

    public Long getRoomId() 
    {
        return roomId;
    }
    public void setFacilityId(Long facilityId) 
    {
        this.facilityId = facilityId;
    }

    public Long getFacilityId() 
    {
        return facilityId;
    }
    public void setIsFree(Integer isFree) 
    {
        this.isFree = isFree;
    }

    public Integer getIsFree() 
    {
        return isFree;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("roomId", getRoomId())
            .append("facilityId", getFacilityId())
            .append("isFree", getIsFree())
            .toString();
    }
}
