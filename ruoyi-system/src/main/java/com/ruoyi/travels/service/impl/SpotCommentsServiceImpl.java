package com.ruoyi.travels.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.travels.mapper.SpotCommentsMapper;
import com.ruoyi.travels.domain.SpotComments;
import com.ruoyi.travels.service.ISpotCommentsService;

/**
 * 景区评分评论Service业务层处理
 * 
 * @author Yifun
 * @date 2023-04-02
 */
@Service
public class SpotCommentsServiceImpl implements ISpotCommentsService 
{
    @Autowired
    private SpotCommentsMapper spotCommentsMapper;

    /**
     * 查询景区评分评论
     * 
     * @param id 景区评分评论主键
     * @return 景区评分评论
     */
    @Override
    public SpotComments selectSpotCommentsById(Long id)
    {
        return spotCommentsMapper.selectSpotCommentsById(id);
    }

    /**
     * 查询景区评分评论列表
     * 
     * @param spotComments 景区评分评论
     * @return 景区评分评论
     */
    @Override
    public List<SpotComments> selectSpotCommentsList(SpotComments spotComments)
    {
        return spotCommentsMapper.selectSpotCommentsList(spotComments);
    }

    /**
     * 新增景区评分评论
     * 
     * @param spotComments 景区评分评论
     * @return 结果
     */
    @Override
    public int insertSpotComments(SpotComments spotComments)
    {
        spotComments.setCreateTime(DateUtils.getNowDate());
        return spotCommentsMapper.insertSpotComments(spotComments);
    }

    /**
     * 修改景区评分评论
     * 
     * @param spotComments 景区评分评论
     * @return 结果
     */
    @Override
    public int updateSpotComments(SpotComments spotComments)
    {
        return spotCommentsMapper.updateSpotComments(spotComments);
    }

    /**
     * 批量删除景区评分评论
     * 
     * @param ids 需要删除的景区评分评论主键
     * @return 结果
     */
    @Override
    public int deleteSpotCommentsByIds(Long[] ids)
    {
        return spotCommentsMapper.deleteSpotCommentsByIds(ids);
    }

    /**
     * 删除景区评分评论信息
     * 
     * @param id 景区评分评论主键
     * @return 结果
     */
    @Override
    public int deleteSpotCommentsById(Long id)
    {
        return spotCommentsMapper.deleteSpotCommentsById(id);
    }
}
