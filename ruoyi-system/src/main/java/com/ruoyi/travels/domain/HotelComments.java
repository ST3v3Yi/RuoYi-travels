package com.ruoyi.travels.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 酒店点评对象 tb_hotel_comments
 * 
 * @author Yifun
 * @date 2023-05-01
 */
public class HotelComments extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 用户昵称 */
    @Excel(name = "用户昵称")
    private String nickName;

    /** 用户头像 */
    @Excel(name = "用户头像")
    private String avatar;

    /** 酒店id */
    @Excel(name = "酒店id")
    private Long hotelId;

    /** 房间id */
    @Excel(name = "房间id")
    private Long roomId;

    /** 房间名称 */
    @Excel(name = "房间名称")
    private String roomName;

    /** 订单id */
    private Long orderId;

    /** 入住时间 */

    /** 总评分 */
    @Excel(name = "总评分")
    private BigDecimal mainRating;

    /** 环境评分 */
    private BigDecimal environmentRating;

    /** 卫生评分 */
    private BigDecimal hygieneRating;

    /** 服务评分 */
    private BigDecimal serviceRating;

    /** 设施评分 */
    private BigDecimal facilityRating;

    /** 点评内容 */
    @Excel(name = "点评内容")
    private String content;

    /** 点评图片 */
    @Excel(name = "点评图片")
    private String img;

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
    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getNickName()
    {
        return nickName;
    }
    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getAvatar()
    {
        return avatar;
    }
    public void setHotelId(Long hotelId) 
    {
        this.hotelId = hotelId;
    }

    public Long getHotelId() 
    {
        return hotelId;
    }
    public void setRoomId(Long roomId) 
    {
        this.roomId = roomId;
    }

    public Long getRoomId() 
    {
        return roomId;
    }
    public void setRoomName(String roomName)
    {
        this.roomName = roomName;
    }

    public String getRoomName()
    {
        return roomName;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setMainRating(BigDecimal mainRating) 
    {
        this.mainRating = mainRating;
    }

    public BigDecimal getMainRating() 
    {
        return mainRating;
    }
    public void setEnvironmentRating(BigDecimal environmentRating) 
    {
        this.environmentRating = environmentRating;
    }

    public BigDecimal getEnvironmentRating() 
    {
        return environmentRating;
    }
    public void setHygieneRating(BigDecimal hygieneRating) 
    {
        this.hygieneRating = hygieneRating;
    }

    public BigDecimal getHygieneRating() 
    {
        return hygieneRating;
    }
    public void setServiceRating(BigDecimal serviceRating) 
    {
        this.serviceRating = serviceRating;
    }

    public BigDecimal getServiceRating() 
    {
        return serviceRating;
    }
    public void setFacilityRating(BigDecimal facilityRating) 
    {
        this.facilityRating = facilityRating;
    }

    public BigDecimal getFacilityRating() 
    {
        return facilityRating;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
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
            .append("userId", getUserId())
            .append("nickName", getNickName())
            .append("avatar", getAvatar())
            .append("hotelId", getHotelId())
            .append("roomId", getRoomId())
            .append("roomName", getRoomName())
            .append("orderId", getOrderId())
            .append("mainRating", getMainRating())
            .append("environmentRating", getEnvironmentRating())
            .append("hygieneRating", getHygieneRating())
            .append("serviceRating", getServiceRating())
            .append("facilityRating", getFacilityRating())
            .append("content", getContent())
            .append("img", getImg())
            .append("createTime", getCreateTime())
            .toString();
    }
}
