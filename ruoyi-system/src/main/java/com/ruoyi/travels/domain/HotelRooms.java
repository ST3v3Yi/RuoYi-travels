package com.ruoyi.travels.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 酒店房间对象 tb_hotel_rooms
 *
 * @author Yifun
 * @date 2023-04-29
 */
public class HotelRooms extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 酒店id */
    @Excel(name = "酒店id")
    private Long hotelId;

    /** 房间名称 */
    @Excel(name = "房间名称")
    private String roomName;

    /** 房间类型（0：双床房 1：大床房 2：多床房） */
    @Excel(name = "房间类型", readConverterExp = "0=：双床房,1=：大床房,2=：多床房")
    private Long type;

    /** 房间大小 */
    @Excel(name = "房间大小")
    private Long size;

    /** 房间人数 */
    @Excel(name = "房间人数")
    private Long number;

    /** 床铺情况 */
    private String bed;

    /** 房间价格 */
    @Excel(name = "房间价格")
    private BigDecimal price;

    /** 房间数 */
    @Excel(name = "房间数")
    private Long counts;

    /** 房间图片 */
    @Excel(name = "房间图片")
    private String img;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setHotelId(Long hotelId)
    {
        this.hotelId = hotelId;
    }

    public Long getHotelId()
    {
        return hotelId;
    }
    public void setRoomName(String roomName)
    {
        this.roomName = roomName;
    }

    public String getRoomName()
    {
        return roomName;
    }
    public void setType(Long type)
    {
        this.type = type;
    }

    public Long getType()
    {
        return type;
    }
    public void setSize(Long size)
    {
        this.size = size;
    }

    public Long getSize()
    {
        return size;
    }
    public void setNumber(Long number)
    {
        this.number = number;
    }

    public Long getNumber()
    {
        return number;
    }
    public void setBed(String bed)
    {
        this.bed = bed;
    }

    public String getBed()
    {
        return bed;
    }
    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public BigDecimal getPrice()
    {
        return price;
    }
    public void setCounts(Long counts)
    {
        this.counts = counts;
    }

    public Long getCounts()
    {
        return counts;
    }
    public void setImg(String img)
    {
        this.img = img;
    }

    public String getImg()
    {
        return img;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("hotelId", getHotelId())
                .append("roomName", getRoomName())
                .append("type", getType())
                .append("size", getSize())
                .append("number", getNumber())
                .append("bed", getBed())
                .append("price", getPrice())
                .append("counts", getCounts())
                .append("img", getImg())
                .toString();
    }
}
