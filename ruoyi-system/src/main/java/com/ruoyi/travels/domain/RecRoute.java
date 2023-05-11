package com.ruoyi.travels.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 路线对象 tb_route, tb_route_comments, tb_route_reply
 *
 * @author Yifun
 * @date 2023-05-09
 */
public class RecRoute extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 封面图 */
    @Excel(name = "封面图")
    private String coverImg;

    /** 收藏数量 */
    @Excel(name = "收藏数量")
    private Integer counts;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date releaseTime;

    /** 是否发布 */
    @Excel(name = "是否发布")
    private Integer isDeleted;

    /** 评论数量 */
    @Excel(name = "评论数量")
    private Integer commentsCount;

    /** 回复数量 */
    @Excel(name = "回复数量")
    private Integer replyCount;

    /** 权重 */
    @Excel(name = "权重")
    private BigDecimal weight;

    /** 日期差距 */
    @Excel(name = "日期差距")
    private Integer dateGap;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
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
    public void setCounts(Integer counts)
    {
        this.counts = counts;
    }

    public Integer getCounts()
    {
        return counts;
    }
    public void setReleaseTime(Date releaseTime)
    {
        this.releaseTime = releaseTime;
    }

    public Date getReleaseTime()
    {
        return releaseTime;
    }
    public void setIsDeleted(Integer isDeleted)
    {
        this.isDeleted = isDeleted;
    }

    public Integer getIsDeleted()
    {
        return isDeleted;
    }
    public void setCommentsCount(Integer commentsCount)
    {
        this.commentsCount = commentsCount;
    }

    public Integer getCommentsCount()
    {
        return commentsCount;
    }
    public void setReplyCount(Integer replyCount)
    {
        this.replyCount = replyCount;
    }

    public Integer getReplyCount()
    {
        return replyCount;
    }
    public void setWeight(BigDecimal weight)
    {
        this.weight = weight;
    }

    public BigDecimal getWeight()
    {
        return weight;
    }
    public void setDateGap(Integer dateGap)
    {
        this.dateGap = dateGap;
    }

    public Integer getDateGap()
    {
        return dateGap;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("title", getTitle())
                .append("coverImg", getCoverImg())
                .append("counts", getCounts())
                .append("releaseTime", getReleaseTime())
                .append("isDeleted", getIsDeleted())
                .append("commentsCount", getCommentsCount())
                .append("replyCount", getReplyCount())
                .append("weight", getWeight())
                .append("dateGap", getDateGap())
                .toString();
    }
}
