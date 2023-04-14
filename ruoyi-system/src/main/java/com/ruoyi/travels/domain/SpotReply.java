package com.ruoyi.travels.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 景区回复表对象 tb_spot_reply
 * 
 * @author Yifun
 * @date 2023-04-02
 */
public class SpotReply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 回复用户 */
    @Excel(name = "回复用户")
    private Long userId;

    /** 景区id */
    @Excel(name = "景区id")
    private Long spotId;

    /** 评论id */
    @Excel(name = "评论id")
    private Long commentId;

    /** 被回复用户 */
    @Excel(name = "被回复用户")
    private Long toUserId;

    /** 回复内容 */
    @Excel(name = "回复内容")
    private String content;

    /** 回复用户昵称 */
    @Excel(name = "回复用户昵称")
    private String userName;

    /** 被回复用户昵称 */
    @Excel(name = "被回复用户昵称")
    private String toUserName;

    /** 回复用户头像 */
    @Excel(name = "回复用户头像")
    private String avatar;

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
    public void setSpotId(Long spotId) 
    {
        this.spotId = spotId;
    }

    public Long getSpotId() 
    {
        return spotId;
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
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setToUserName(String toUserName)
    {
        this.toUserName = toUserName;
    }

    public String getToUserName()
    {
        return toUserName;
    }
    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getAvatar()
    {
        return avatar;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("spotId", getSpotId())
            .append("commentId", getCommentId())
            .append("toUserId", getToUserId())
            .append("content", getContent())
            .append("createTime", getCreateTime())
            .append("userName", getUserName())
            .append("toUserName", getToUserName())
            .append("avatar", getAvatar())
            .toString();
    }
}
