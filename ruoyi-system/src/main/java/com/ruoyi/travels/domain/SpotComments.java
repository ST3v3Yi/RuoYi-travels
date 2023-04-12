package com.ruoyi.travels.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 景区评分评论对象 tb_spot_comments
 *
 * @author Yifun
 * @date 2023-04-11
 */
public class SpotComments extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 景区id */
    @Excel(name = "景区id")
    private Long spotId;

    /** 评论内容 */
    @Excel(name = "评论内容")
    private String content;

    /** 评分 */
    @Excel(name = "评分")
    private BigDecimal rating;

    /** 评论图片 */
    @Excel(name = "评论图片")
    private String img;

    /** 用户昵称 */
    @Excel(name = "用户昵称")
    private String nickName;

    /** 用户头像 */
    @Excel(name = "用户头像")
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
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setRating(BigDecimal rating)
    {
        this.rating = rating;
    }

    public BigDecimal getRating()
    {
        return rating;
    }
    public void setImg(String img)
    {
        this.img = img;
    }

    public String getImg()
    {
        return img;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userId", getUserId())
                .append("spotId", getSpotId())
                .append("content", getContent())
                .append("rating", getRating())
                .append("img", getImg())
                .append("createTime", getCreateTime())
                .append("nickName", getNickName())
                .append("avatar", getAvatar())
                .toString();
    }
}
