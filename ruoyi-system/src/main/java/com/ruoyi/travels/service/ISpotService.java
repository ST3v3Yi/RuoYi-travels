package com.ruoyi.travels.service;

import java.util.List;
import com.ruoyi.travels.domain.Spot;

/**
 * 景区Service接口
 *
 * @author Yifun
 * @date 2023-04-11
 */
public interface ISpotService
{
    /**
     * 查询景区
     *
     * @param id 景区主键
     * @return 景区
     */
    public Spot selectSpotById(Long id);

    /**
     * 查询景区列表
     *
     * @param spot 景区
     * @return 景区集合
     */
    public List<Spot> selectSpotList(Spot spot);

    /**
     * 根据名字获取id
     */
    public Long selectSpotIdBySpotName(String spotName);

    /**
     * 新增景区
     *
     * @param spot 景区
     * @return 结果
     */
    public int insertSpot(Spot spot);

    /**
     * 修改景区
     *
     * @param spot 景区
     * @return 结果
     */
    public int updateSpot(Spot spot);

    /**
     * 批量删除景区
     *
     * @param ids 需要删除的景区主键集合
     * @return 结果
     */
    public int deleteSpotByIds(Long[] ids);

    /**
     * 删除景区信息
     *
     * @param id 景区主键
     * @return 结果
     */
    public int deleteSpotById(Long id);
}
