package com.ruoyi.travels.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 景区收藏对象 tb_spot_favorite
 *
 * @author Yifun
 * @date 2023-05-12
 */
public class UserSpotFavorite extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 景点ID */
    @Excel(name = "景点ID")
    private Long spotId;

    /** 景点名称 */
    @Excel(name = "景点名称")
    private String spotName;

    /** 景点外文名称 */
    @Excel(name = "景点外文名称")
    private String spotForeignName;

    /** 景点封面图 */
    @Excel(name = "景点封面图")
    private String coverImg;

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
    public void setSpotName(String spotName)
    {
        this.spotName = spotName;
    }

    public String getSpotName()
    {
        return spotName;
    }
    public void setSpotForeignName(String spotForeignName)
    {
        this.spotForeignName = spotForeignName;
    }

    public String getSpotForeignName()
    {
        return spotForeignName;
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
                .append("spotId", getSpotId())
                .append("spotName", getSpotName())
                .append("spotForeignName", getSpotForeignName())
                .append("coverImg", getCoverImg())
                .append("createTime", getCreateTime())
                .toString();
    }
}