package com.ruoyi.travels.mapper;

import java.util.List;

import com.ruoyi.travels.domain.RouteReplyList;
import com.ruoyi.travels.domain.SpotReply;

/**
 * 景区回复表Mapper接口
 * 
 * @author Yifun
 * @date 2023-04-02
 */
public interface SpotReplyMapper 
{
    /**
     * 查询景区回复表
     * 
     * @param id 景区回复表主键
     * @return 景区回复表
     */
    public SpotReply selectSpotReplyById(Long id);

    /**
     * 根据评论ID查询回复
     */
    public List<SpotReply> selectSpotReplyByCommentId(Long commentId);

    /**
     * 查询景区回复表列表
     * 
     * @param spotReply 景区回复表
     * @return 景区回复表集合
     */
    public List<SpotReply> selectSpotReplyList(SpotReply spotReply);

    /**
     * 新增景区回复表
     * 
     * @param spotReply 景区回复表
     * @return 结果
     */
    public int insertSpotReply(SpotReply spotReply);

    /**
     * 修改景区回复表
     * 
     * @param spotReply 景区回复表
     * @return 结果
     */
    public int updateSpotReply(SpotReply spotReply);

    /**
     * 删除景区回复表
     * 
     * @param id 景区回复表主键
     * @return 结果
     */
    public int deleteSpotReplyById(Long id);

    /**
     * 批量删除景区回复表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSpotReplyByIds(Long[] ids);
}
