package com.ruoyi.travels.mapper;

import java.util.List;
import com.ruoyi.travels.domain.SpotImg;

/**
 * 景区图片Mapper接口
 * 
 * @author Yifun
 * @date 2023-04-02
 */
public interface SpotImgMapper 
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
     * 删除景区图片
     * 
     * @param id 景区图片主键
     * @return 结果
     */
    public int deleteSpotImgById(Long id);

    /**
     * 批量删除景区图片
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSpotImgByIds(Long[] ids);
}
