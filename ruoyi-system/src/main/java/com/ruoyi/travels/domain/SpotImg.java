package com.ruoyi.travels.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 景区图片对象 tb_spot_img
 * 
 * @author Yifun
 * @date 2023-04-02
 */
public class SpotImg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 图片编号 */
    @Excel(name = "图片编号")
    private Long imgId;

    /** 景区id */
    @Excel(name = "景区id")
    private Long spotId;

    /** 图片路径 */
    @Excel(name = "图片路径")
    private String img;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setImgId(Long imgId) 
    {
        this.imgId = imgId;
    }

    public Long getImgId() 
    {
        return imgId;
    }
    public void setSpotId(Long spotId) 
    {
        this.spotId = spotId;
    }

    public Long getSpotId() 
    {
        return spotId;
    }
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("imgId", getImgId())
            .append("spotId", getSpotId())
            .append("img", getImg())
            .toString();
    }
}
