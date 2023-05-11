package com.ruoyi.travels.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 距离记录对象 tb_around
 * 
 * @author Yifun
 * @date 2023-05-10
 */
public class Around extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 记录类型（0：景点之间 1：景点酒店之间） */
    @Excel(name = "记录类型", readConverterExp = "0=：景点之间,1=：景点酒店之间")
    private Long type;

    /** 景点1id */
    @Excel(name = "景点1id")
    private Long spotId1;

    /** 景点2id */
    @Excel(name = "景点2id")
    private Long spotId2;

    /** 酒店id */
    @Excel(name = "酒店id")
    private Long hotelId;

    /** 相距距离 */
    @Excel(name = "相距距离")
    private Long distance;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setSpotId1(Long spotId1) 
    {
        this.spotId1 = spotId1;
    }

    public Long getSpotId1() 
    {
        return spotId1;
    }
    public void setSpotId2(Long spotId2) 
    {
        this.spotId2 = spotId2;
    }

    public Long getSpotId2() 
    {
        return spotId2;
    }
    public void setHotelId(Long hotelId) 
    {
        this.hotelId = hotelId;
    }

    public Long getHotelId() 
    {
        return hotelId;
    }
    public void setDistance(Long distance) 
    {
        this.distance = distance;
    }

    public Long getDistance() 
    {
        return distance;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("spotId1", getSpotId1())
            .append("spotId2", getSpotId2())
            .append("hotelId", getHotelId())
            .append("distance", getDistance())
            .append("createTime", getCreateTime())
            .toString();
    }
}
