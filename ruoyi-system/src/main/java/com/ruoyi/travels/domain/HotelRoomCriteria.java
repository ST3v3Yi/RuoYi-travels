package com.ruoyi.travels.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 酒店房间筛选条件
 *
 * @author Yifun
 * @date 2023-05-03
 */
public class HotelRoomCriteria extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 酒店ID */
    @Excel(name = "酒店ID")
    private Long hotelId;

    /** 目标房间数 */
    @Excel(name = "目标房间数")
    private Long roomNumber;

    /** 目标人数 */
    @Excel(name = "目标人数")
    private Long peopleNumber;

    public void setHotelId(Long hotelId)
    {
        this.hotelId = hotelId;
    }

    public Long getHotelId()
    {
        return hotelId;
    }
    public void setRoomNumber(Long roomNumber)
    {
        this.roomNumber = roomNumber;
    }

    public Long getRoomNumber()
    {
        return roomNumber;
    }
    public void setPeopleNumber(Long peopleNumber)
    {
        this.peopleNumber = peopleNumber;
    }

    public Long getPeopleNumber()
    {
        return peopleNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("roomNumber", getRoomNumber())
                .append("peopleNumber", getPeopleNumber())
                .toString();
    }
}