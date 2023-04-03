package com.ruoyi.travels.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travels.mapper.SpotImgMapper;
import com.ruoyi.travels.domain.SpotImg;
import com.ruoyi.travels.service.ISpotImgService;

/**
 * 景区图片Service业务层处理
 * 
 * @author Yifun
 * @date 2023-04-02
 */
@Service
public class SpotImgServiceImpl implements ISpotImgService 
{
    @Autowired
    private SpotImgMapper spotImgMapper;

    /**
     * 查询景区图片
     * 
     * @param id 景区图片主键
     * @return 景区图片
     */
    @Override
    public SpotImg selectSpotImgById(Long id)
    {
        return spotImgMapper.selectSpotImgById(id);
    }

    /**
     * 查询景区图片列表
     * 
     * @param spotImg 景区图片
     * @return 景区图片
     */
    @Override
    public List<SpotImg> selectSpotImgList(SpotImg spotImg)
    {
        return spotImgMapper.selectSpotImgList(spotImg);
    }

    /**
     * 新增景区图片
     * 
     * @param spotImg 景区图片
     * @return 结果
     */
    @Override
    public int insertSpotImg(SpotImg spotImg)
    {
        return spotImgMapper.insertSpotImg(spotImg);
    }

    /**
     * 修改景区图片
     * 
     * @param spotImg 景区图片
     * @return 结果
     */
    @Override
    public int updateSpotImg(SpotImg spotImg)
    {
        return spotImgMapper.updateSpotImg(spotImg);
    }

    /**
     * 批量删除景区图片
     * 
     * @param ids 需要删除的景区图片主键
     * @return 结果
     */
    @Override
    public int deleteSpotImgByIds(Long[] ids)
    {
        return spotImgMapper.deleteSpotImgByIds(ids);
    }

    /**
     * 删除景区图片信息
     * 
     * @param id 景区图片主键
     * @return 结果
     */
    @Override
    public int deleteSpotImgById(Long id)
    {
        return spotImgMapper.deleteSpotImgById(id);
    }
}
