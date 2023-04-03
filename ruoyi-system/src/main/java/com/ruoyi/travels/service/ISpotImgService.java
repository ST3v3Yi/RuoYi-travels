package com.ruoyi.travels.service;

import java.util.List;
import com.ruoyi.travels.domain.SpotImg;

/**
 * 景区图片Service接口
 * 
 * @author Yifun
 * @date 2023-04-02
 */
public interface ISpotImgService 
{
    /**
     * 查询景区图片
     * 
     * @param id 景区图片主键
     * @return 景区图片
     */
    public SpotImg selectSpotImgById(Long id);

    /**
     * 查询景区图片列表
     * 
     * @param spotImg 景区图片
     * @return 景区图片集合
     */
    public List<SpotImg> selectSpotImgList(SpotImg spotImg);

    /**
     * 新增景区图片
     * 
     * @param spotImg 景区图片
     * @return 结果
     */
    public int insertSpotImg(SpotImg spotImg);

    /**
     * 修改景区图片
     * 
     * @param spotImg 景区图片
     * @return 结果
     */
    public int updateSpotImg(SpotImg spotImg);

    /**
     * 批量删除景区图片
     * 
     * @param ids 需要删除的景区图片主键集合
     * @return 结果
     */
    public int deleteSpotImgByIds(Long[] ids);

    /**
     * 删除景区图片信息
     * 
     * @param id 景区图片主键
     * @return 结果
     */
    public int deleteSpotImgById(Long id);
}
