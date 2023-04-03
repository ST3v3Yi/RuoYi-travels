package com.ruoyi.travels.service;

import java.util.List;
import com.ruoyi.travels.domain.SpotComments;

/**
 * 景区评分评论Service接口
 * 
 * @author Yifun
 * @date 2023-04-02
 */
public interface ISpotCommentsService 
{
    /**
     * 查询景区评分评论
     * 
     * @param id 景区评分评论主键
     * @return 景区评分评论
     */
    public SpotComments selectSpotCommentsById(Long id);

    /**
     * 查询景区评分评论列表
     * 
     * @param spotComments 景区评分评论
     * @return 景区评分评论集合
     */
    public List<SpotComments> selectSpotCommentsList(SpotComments spotComments);

    /**
     * 新增景区评分评论
     * 
     * @param spotComments 景区评分评论
     * @return 结果
     */
    public int insertSpotComments(SpotComments spotComments);

    /**
     * 修改景区评分评论
     * 
     * @param spotComments 景区评分评论
     * @return 结果
     */
    public int updateSpotComments(SpotComments spotComments);

    /**
     * 批量删除景区评分评论
     * 
     * @param ids 需要删除的景区评分评论主键集合
     * @return 结果
     */
    public int deleteSpotCommentsByIds(Long[] ids);

    /**
     * 删除景区评分评论信息
     * 
     * @param id 景区评分评论主键
     * @return 结果
     */
    public int deleteSpotCommentsById(Long id);
}
