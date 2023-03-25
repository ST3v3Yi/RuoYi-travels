package com.ruoyi.travels.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 路线回复对象 tb_route_reply
 * 
 * @author Yifun
 * @date 2023-03-25
 */
public class RouteReply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 回复id */
    private Long id;

    /** 回复用户id */
    @Excel(name = "回复用户id")
    private Long userId;

    /** 路线id */
    @Excel(name = "路线id")
    private Long routeId;

    /** 评论id */
    @Excel(name = "评论id")
    private Long commentId;

    /** 被回复用户id */
    @Excel(name = "被回复用户id")
    private Long toUserId;

    /** 回复内容 */
    @Excel(name = "回复内容")
    private String content;

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
    public void setRouteId(Long routeId) 
    {
        this.routeId = routeId;
    }

    public Long getRouteId() 
    {
        return routeId;
    }
    public void setCommentId(Long commentId) 
    {
        this.commentId = commentId;
    }

    public Long getCommentId() 
    {
        return commentId;
    }
    public void setToUserId(Long toUserId) 
    {
        this.toUserId = toUserId;
    }

    public Long getToUserId() 
    {
        return toUserId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("routeId", getRouteId())
            .append("commentId", getCommentId())
            .append("toUserId", getToUserId())
            .append("content", getContent())
            .append("createTime", getCreateTime())
            .toString();
    }
}
