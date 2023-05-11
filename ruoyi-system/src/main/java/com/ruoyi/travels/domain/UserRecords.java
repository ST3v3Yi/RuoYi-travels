package com.ruoyi.travels.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户浏览记录对象 tb_user_records
 * 
 * @author Yifun
 * @date 2023-05-10
 */
public class UserRecords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 访问类型 */
    @Excel(name = "访问类型")
    private Long type;

    /** 景点id */
    @Excel(name = "景点id")
    private Long spotId;

    /** 路线id */
    @Excel(name = "路线id")
    private Long routeId;

    /** 酒店id */
    @Excel(name = "酒店id")
    private Long hotelId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setSpotId(Long spotId) 
    {
        this.spotId = spotId;
    }

    public Long getSpotId() 
    {
        return spotId;
    }
    public void setRouteId(Long routeId) 
    {
        this.routeId = routeId;
    }

    public Long getRouteId() 
    {
        return routeId;
    }
    public void setHotelId(Long hotelId) 
    {
        this.hotelId = hotelId;
    }

    public Long getHotelId() 
    {
        return hotelId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("type", getType())
            .append("spotId", getSpotId())
            .append("routeId", getRouteId())
            .append("hotelId", getHotelId())
            .append("createTime", getCreateTime())
            .toString();
    }
}
