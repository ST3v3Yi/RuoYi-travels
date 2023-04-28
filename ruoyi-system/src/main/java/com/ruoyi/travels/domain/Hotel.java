package com.ruoyi.travels.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 酒店管理对象 tb_hotel
 * 
 * @author Yifun
 * @date 2023-04-22
 */
public class Hotel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 酒店名字 */
    @Excel(name = "酒店名字")
    private String hotelName;

    /** 酒店外文名 */
    private String hotelForeignName;

    /** 酒店封面图 */
    @Excel(name = "酒店封面图")
    private String coverImg;

    /** 酒店图片 */
    private String hotelImg;

    /** 酒店基本信息 */
    private String hotelInfo;

    /** 酒店简介 */
    private String introduction;

    /** 酒店品牌 */
    @Excel(name = "酒店品牌")
    private String hotelBrand;

    /** 酒店位置 */
    @Excel(name = "酒店位置")
    private String location;

    /** 经度 */
    private Double lng;

    /** 纬度 */
    private Double lat;

    /** 是否发布 */
    @Excel(name = "是否发布")
    private Long isDeleted;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setHotelName(String hotelName) 
    {
        this.hotelName = hotelName;
    }

    public String getHotelName() 
    {
        return hotelName;
    }
    public void setHotelForeignName(String hotelForeignName) 
    {
        this.hotelForeignName = hotelForeignName;
    }

    public String getHotelForeignName() 
    {
        return hotelForeignName;
    }
    public void setCoverImg(String coverImg) 
    {
        this.coverImg = coverImg;
    }

    public String getCoverImg() 
    {
        return coverImg;
    }
    public void setHotelImg(String hotelImg) 
    {
        this.hotelImg = hotelImg;
    }

    public String getHotelImg() 
    {
        return hotelImg;
    }
    public void setHotelInfo(String hotelInfo) 
    {
        this.hotelInfo = hotelInfo;
    }

    public String getHotelInfo() 
    {
        return hotelInfo;
    }
    public void setIntroduction(String introduction) 
    {
        this.introduction = introduction;
    }

    public String getIntroduction() 
    {
        return introduction;
    }
    public void setHotelBrand(String hotelBrand) 
    {
        this.hotelBrand = hotelBrand;
    }

    public String getHotelBrand() 
    {
        return hotelBrand;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setLng(Double lng) 
    {
        this.lng = lng;
    }

    public Double getLng() 
    {
        return lng;
    }
    public void setLat(Double lat) 
    {
        this.lat = lat;
    }

    public Double getLat() 
    {
        return lat;
    }
    public void setIsDeleted(Long isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Long getIsDeleted() 
    {
        return isDeleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("hotelName", getHotelName())
            .append("hotelForeignName", getHotelForeignName())
            .append("coverImg", getCoverImg())
            .append("hotelImg", getHotelImg())
            .append("hotelInfo", getHotelInfo())
            .append("introduction", getIntroduction())
            .append("hotelBrand", getHotelBrand())
            .append("location", getLocation())
            .append("lng", getLng())
            .append("lat", getLat())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
