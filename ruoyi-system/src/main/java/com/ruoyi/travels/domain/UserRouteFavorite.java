package com.ruoyi.travels.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 路线收藏对象 tb_route_favorite
 *
 * @author Yifun
 * @date 2023-05-12
 */
public class UserRouteFavorite extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 路线id */
    @Excel(name = "路线id")
    private Long routeId;

    /** 路线标题 */
    @Excel(name = "路线标题")
    private String title;

    /** 路线封面图 */
    @Excel(name = "路线封面图")
    private String coverImg;

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setRouteId(Long routeId)
    {
        this.routeId = routeId;
    }

    public Long getRouteId()
    {
        return routeId;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setCoverImg(String coverImg)
    {
        this.coverImg = coverImg;
    }

    public String getCoverImg()
    {
        return coverImg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("userId", getUserId())
                .append("routeId", getRouteId())
                .append("title", getTitle())
                .append("coverImg", getCoverImg())
                .append("createTime", getCreateTime())
                .toString();
    }
}