package com.ruoyi.travels.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 景区对象 tb_spot
 * 
 * @author Yifun
 * @date 2023-04-02
 */
public class Spot extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 景区名字 */
    @Excel(name = "景区名字")
    private String spotName;

    /** 景区简介 */
    private String introduction;

    /** 联系电话 */
    private String telephone;

    /** 用时参考  */
    private Long playtime;

    /** 交通方式 */
    private String traffic;

    /** 门票情况 */
    private String tickets;

    /** 开放时间 */
    private String openingHours;

    /** 景区位置 */
    private String location;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private Long isDeleted;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSpotName(String spotName) 
    {
        this.spotName = spotName;
    }

    public String getSpotName() 
    {
        return spotName;
    }
    public void setIntroduction(String introduction) 
    {
        this.introduction = introduction;
    }

    public String getIntroduction() 
    {
        return introduction;
    }
    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getTelephone() 
    {
        return telephone;
    }
    public void setPlaytime(Long playtime) 
    {
        this.playtime = playtime;
    }

    public Long getPlaytime() 
    {
        return playtime;
    }
    public void setTraffic(String traffic) 
    {
        this.traffic = traffic;
    }

    public String getTraffic() 
    {
        return traffic;
    }
    public void setTickets(String tickets) 
    {
        this.tickets = tickets;
    }

    public String getTickets() 
    {
        return tickets;
    }
    public void setOpeningHours(String openingHours) 
    {
        this.openingHours = openingHours;
    }

    public String getOpeningHours() 
    {
        return openingHours;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setIsDeleted(Long isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Long getIsDeleted() 
    {
        return isDeleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("spotName", getSpotName())
            .append("introduction", getIntroduction())
            .append("telephone", getTelephone())
            .append("playtime", getPlaytime())
            .append("traffic", getTraffic())
            .append("tickets", getTickets())
            .append("openingHours", getOpeningHours())
            .append("location", getLocation())
            .append("createTime", getCreateTime())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
