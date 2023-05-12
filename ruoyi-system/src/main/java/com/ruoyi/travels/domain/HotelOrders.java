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
public class HotelOrders extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 住客姓名 */
    @Excel(name = "住客姓名")
    private String userName;

    /** 用户邮箱 */
    private String email;

    /** 用户电话 */
    @Excel(name = "用户电话")
    private String telephone;

    /** 酒店id */
    @Excel(name = "酒店id")
    private Long hotelId;

    /** 酒店方id */
    private Long ownerId;

    /** 房间id */
    @Excel(name = "房间id")
    private Long roomId;

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
    public void setHotelId(Long hotelId) 
    {
        this.hotelId = hotelId;
    }

    public Long getHotelId() 
    {
        return hotelId;
    }
    public void setOwnerId(Long ownerId) 
    {
        this.ownerId = ownerId;
    }

    public Long getOwnerId() 
    {
        return ownerId;
    }
    public void setRoomId(Long roomId) 
    {
        this.roomId = roomId;
    }

    public Long getRoomId() 
    {
        return roomId;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("email", getEmail())
            .append("telephone", getTelephone())
            .append("hotelId", getHotelId())
            .append("ownerId", getOwnerId())
            .append("roomId", getRoomId())
            .append("roomNumber", getRoomNumber())
            .append("fromDate", getFromDate())
            .append("toDate", getToDate())
            .append("arrivalTime", getArrivalTime())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .append("price", getPrice())
            .toString();
    }
}
