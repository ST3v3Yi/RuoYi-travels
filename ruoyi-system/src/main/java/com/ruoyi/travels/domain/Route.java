package com.ruoyi.travels.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 路线对象 tb_route
 * 
 * @author Yifun
 * @date 2023-03-11
 */
public class Route extends BaseEntity
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

    /** 路线时间 */
    @Excel(name = "路线时间")
    private Integer day;

    /** 路线时间下限 */
    @Excel(name = "路线时间下限")
    private Integer lower;

    /** 路线时间上限 */
    @Excel(name = "路线时间上限")
    private Integer upper;

    /** 路线花费 */
    @Excel(name = "路线花费")
    private BigDecimal cost;

    /** 路线花费下限 */
    @Excel(name = "路线花费下限")
    private BigDecimal minPrice;

    /** 路线花费上限 */
    @Excel(name = "路线花费上限")
    private BigDecimal maxPrice;


    /** 创建人 */
    private Long userId;

    /** 用户昵称 */
    @Excel(name = "用户昵称")
    private String userName;

    /** 用户头像 */
    @Excel(name = "用户头像")
    private String avatar;

    /** 创建部门 */
    private Long deptId;

    /** 部门名称 */
    private String deptName;

    /** 简介 */
    @Excel(name = "简介")
    private String introduction;

    /** 内容 */
    private String content;

    /** 状态 */
    private Integer status;

    /** 是否发布 */
    @Excel(name = "是否发布")
    private Integer isDeleted;

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
    public void setDay(Integer day) 
    {
        this.day = day;
    }

    public Integer getDay() 
    {
        return day;
    }
    public void setLower(Integer lower)
    {
        this.lower = lower;
    }

    public Integer getLower()
    {
        return lower;
    }
    public void setUpper(Integer upper)
    {
        this.upper = upper;
    }

    public Integer getUpper()
    {
        return upper;
    }
    public void setCost(BigDecimal cost) 
    {
        this.cost = cost;
    }

    public BigDecimal getCost() 
    {
        return cost;
    }
    public void setMinPrice(BigDecimal minPrice)
    {
        this.minPrice = minPrice;
    }

    public BigDecimal getMinPrice()
    {
        return minPrice;
    }
    public void setMaxPrice(BigDecimal maxPrice)
    {
        this.maxPrice = maxPrice;
    }

    public BigDecimal getMaxPrice()
    {
        return maxPrice;
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
    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getAvatar()
    {
        return avatar;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setDeptName(String deptName) 
    {
        this.deptName = deptName;
    }

    public String getDeptName() 
    {
        return deptName;
    }
    public void setIntroduction(String introduction) 
    {
        this.introduction = introduction;
    }

    public String getIntroduction() 
    {
        return introduction;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setIsDeleted(Integer isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Integer getIsDeleted() 
    {
        return isDeleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("coverImg", getCoverImg())
            .append("counts", getCounts())
            .append("releaseTime", getReleaseTime())
            .append("day", getDay())
            .append("lower", getLower())
            .append("upper", getUpper())
            .append("cost", getCost())
            .append("minPrice", getMinPrice())
            .append("maxPrice", getMaxPrice())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("avatar", getAvatar())
            .append("deptId", getDeptId())
            .append("deptName", getDeptName())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("introduction", getIntroduction())
            .append("content", getContent())
            .append("status", getStatus())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
