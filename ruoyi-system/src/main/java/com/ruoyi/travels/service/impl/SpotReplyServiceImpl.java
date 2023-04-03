package com.ruoyi.travels.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travels.mapper.SpotReplyMapper;
import com.ruoyi.travels.domain.SpotReply;
import com.ruoyi.travels.service.ISpotReplyService;

/**
 * 景区回复表Service业务层处理
 * 
 * @author Yifun
 * @date 2023-04-02
 */
@Service
public class SpotReplyServiceImpl implements ISpotReplyService 
{
    @Autowired
    private SpotReplyMapper spotReplyMapper;

    /**
     * 查询景区回复表
     * 
     * @param id 景区回复表主键
     * @return 景区回复表
     */
    @Override
    public SpotReply selectSpotReplyById(Long id)
    {
        return spotReplyMapper.selectSpotReplyById(id);
    }

    /**
     * 查询景区回复表列表
     * 
     * @param spotReply 景区回复表
     * @return 景区回复表
     */
    @Override
    public List<SpotReply> selectSpotReplyList(SpotReply spotReply)
    {
        return spotReplyMapper.selectSpotReplyList(spotReply);
    }

    /**
     * 新增景区回复表
     * 
     * @param spotReply 景区回复表
     * @return 结果
     */
    @Override
    public int insertSpotReply(SpotReply spotReply)
    {
        spotReply.setCreateTime(DateUtils.getNowDate());
        return spotReplyMapper.insertSpotReply(spotReply);
    }

    /**
     * 修改景区回复表
     * 
     * @param spotReply 景区回复表
     * @return 结果
     */
    @Override
    public int updateSpotReply(SpotReply spotReply)
    {
        return spotReplyMapper.updateSpotReply(spotReply);
    }

    /**
     * 批量删除景区回复表
     * 
     * @param ids 需要删除的景区回复表主键
     * @return 结果
     */
    @Override
    public int deleteSpotReplyByIds(Long[] ids)
    {
        return spotReplyMapper.deleteSpotReplyByIds(ids);
    }

    /**
     * 删除景区回复表信息
     * 
     * @param id 景区回复表主键
     * @return 结果
     */
    @Override
    public int deleteSpotReplyById(Long id)
    {
        return spotReplyMapper.deleteSpotReplyById(id);
    }
}
