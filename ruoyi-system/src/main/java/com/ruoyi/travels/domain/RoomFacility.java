package com.ruoyi.travels.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 房间设施对象 tb_room_facilities
 *
 * @author Yifun
 * @date 2023-04-28
 */
public class RoomFacility extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 设施id */
    @Excel(name = "设施id")
    private Long facilityId;

    /** 是否免费 */
    @Excel(name = "是否免费")
    private Integer isFree;

    /** 设施类别 */
    @Excel(name = "设施类别")
    private String category;

    /** 设施描述 */
    @Excel(name = "设施描述")
    private String description;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setFacilityId(Long facilityId)
    {
        this.facilityId = facilityId;
    }

    public Long getFacilityId()
    {
        return facilityId;
    }
    public void setIsFree(Integer isFree)
    {
        this.isFree = isFree;
    }

    public Integer getIsFree()
    {
        return isFree;
    }
    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getCategory()
    {
        return category;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("facilityId", getFacilityId())
                .append("isFree", getIsFree())
                .append("category", getCategory())
                .append("description", getDescription())
                .toString();
    }
}
