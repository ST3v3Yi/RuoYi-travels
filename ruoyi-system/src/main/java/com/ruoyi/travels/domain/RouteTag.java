package com.ruoyi.travels.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 路线Tag对象 tb_route_tag
 *
 * @author Yifun
 * @date 2023-05-25
 */
public class RouteTag extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 路线id */
    @Excel(name = "路线id")
    private Long routeId;

    /** 路线tag */
    @Excel(name = "路线tag")
    private String tag;

    /** tag类型 */
    @Excel(name = "tag类型")
    private Long type;

    /** 目标id */
    @Excel(name = "目标id")
    private Long targetId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setRouteId(Long routeId)
    {
        this.routeId = routeId;
    }

    public Long getRouteId()
    {
        return routeId;
    }
    public void setTag(String tag)
    {
        this.tag = tag;
    }

    public String getTag()
    {
        return tag;
    }
    public void setType(Long type)
    {
        this.type = type;
    }

    public Long getType()
    {
        return type;
    }
    public void setTargetId(Long targetId)
    {
        this.targetId = targetId;
    }

    public Long getTargetId()
    {
        return targetId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("routeId", getRouteId())
                .append("tag", getTag())
                .append("type", getType())
                .append("targetId", getTargetId())
                .toString();
    }
}
