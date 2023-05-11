package com.ruoyi.travels.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 用户浏览记录对象 tb_user_records
 *
 * @author Yifun
 * @date 2023-05-10
 */
public class Record extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 访问类型 */
    @Excel(name = "访问类型")
    private Long type;

    /** 路线id */
    @Excel(name = "路线id")
    private Long routeId;

    /** 访问次数 */
    @Excel(name = "访问次数")
    private Integer counts;

    /** 收藏情况 */
    @Excel(name = "收藏情况")
    private Boolean isFavorite;

    /** 评分 */
    @Excel(name = "评分")
    private BigDecimal rating;

    /** 路线对应Tag */
    @Excel(name = "路线Tag")
    private String tags;


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
    public void setRouteId(Long routeId)
    {
        this.routeId = routeId;
    }

    public Long getRouteId()
    {
        return routeId;
    }
    public void setCounts(Integer counts)
    {
        this.counts = counts;
    }

    public Integer getCounts()
    {
        return counts;
    }
    public void setIsFavorite(Boolean isFavorite)
    {
        this.isFavorite = isFavorite;
    }

    public Boolean getIsFavorite()
    {
        return isFavorite;
    }
    public void setRating(BigDecimal rating)
    {
        this.rating = rating;
    }

    public BigDecimal getRating()
    {
        return rating;
    }
    public void setTags(String tags)
    {
        this.tags = tags;
    }

    public String getTags()
    {
        return tags;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("userId", getUserId())
                .append("type", getType())
                .append("routeId", getRouteId())
                .append("counts", getCounts())
                .append("isFavorite", getIsFavorite())
                .append("rating", getRating())
                .append("tags", getTags())
                .append("createTime", getCreateTime())
                .toString();
    }
}
