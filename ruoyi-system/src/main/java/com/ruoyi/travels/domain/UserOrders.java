package com.ruoyi.travels.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 酒店订单对象 tb_hotel_orders
 *
 * @author Yifun
 * @date 2023-05-12
 */
public class UserOrders extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 住客姓名 */
    @Excel(name = "住客姓名")
    private String userName;

    /** 用户邮箱 */
    private String email;

    /** 用户电话 */
    @Excel(name = "用户电话")
    private String telephone;

    /** 房间数 */
    @Excel(name = "房间数")
    private Long roomNumber;

    /** 入住日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入住日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fromDate;

    /** 离店日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "离店日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date toDate;

    /** 到店时间 */
    @Excel(name = "到店时间")
    private String arrivalTime;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private Long status;

    /** 订单价格 */
    @Excel(name = "订单价格")
    private BigDecimal price;

    /** 酒店名称 */
    @Excel(name = "酒店名称")
    private String hotelName;

    /** 酒店封面图 */
    @Excel(name = "酒店封面图")
    private String coverImg;

    /** 房间名称 */
    @Excel(name = "房间名称")
    private String roomName;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getTelephone()
    {
        return telephone;
    }
    public void setRoomNumber(Long roomNumber)
    {
        this.roomNumber = roomNumber;
    }

    public Long getRoomNumber()
    {
        return roomNumber;
    }
    public void setFromDate(Date fromDate)
    {
        this.fromDate = fromDate;
    }

    public Date getFromDate()
    {
        return fromDate;
    }
    public void setToDate(Date toDate)
    {
        this.toDate = toDate;
    }

    public Date getToDate()
    {
        return toDate;
    }
    public void setArrivalTime(String arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }

    public String getArrivalTime()
    {
        return arrivalTime;
    }
    public void setStatus(Long status)
    {
        this.status = status;
    }

    public Long getStatus()
    {
        return status;
    }
    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public BigDecimal getPrice()
    {
        return price;
    }
    public void setHotelName(String hotelName)
    {
        this.hotelName = hotelName;
    }

    public String getHotelName()
    {
        return  hotelName;
    }
    public void setCoverImg(String coverImg)
    {
        this.coverImg = coverImg;
    }

    public String getCoverImg()
    {
        return  coverImg;
    }
    public void setRoomName(String roomName)
    {
        this.roomName = roomName;
    }

    public String getRoomName()
    {
        return  roomName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userName", getUserName())
                .append("email", getEmail())
                .append("telephone", getTelephone())
                .append("roomNumber", getRoomNumber())
                .append("fromDate", getFromDate())
                .append("toDate", getToDate())
                .append("arrivalTime", getArrivalTime())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("status", getStatus())
                .append("price", getPrice())
                .append("hotelName", getHotelName())
                .append("coverImg", getCoverImg())
                .append("roomName", getRoomName())
                .toString();
    }
}
