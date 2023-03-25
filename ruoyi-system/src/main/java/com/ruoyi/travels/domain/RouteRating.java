package com.ruoyi.travels.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 路线评分对象 tb_route_rating
 * 
 * @author Yifun
 * @date 2023-03-24
 */
public class RouteRating extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 路线ID */
    @Excel(name = "路线ID")
    private Long routeId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 评分 */
    @Excel(name = "评分")
    private BigDecimal rating;

    public void setRouteId(Long routeId) 
    {
        this.routeId = routeId;
    }

    public Long getRouteId() 
    {
        return routeId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setRating(BigDecimal rating)
    {
        this.rating = rating;
    }

    public BigDecimal getRating()
    {
        return rating;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("routeId", getRouteId())
                .append("userId", getUserId())
                .append("rating", getRating())
                .toString();
    }
}
