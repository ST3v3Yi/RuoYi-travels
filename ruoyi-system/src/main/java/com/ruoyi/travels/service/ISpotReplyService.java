package com.ruoyi.travels.service;

import java.util.List;
import com.ruoyi.travels.domain.SpotReply;

/**
 * 景区回复表Service接口
 * 
 * @author Yifun
 * @date 2023-04-02
 */
public interface ISpotReplyService 
{
    /**
     * 查询景区回复表
     * 
     * @param id 景区回复表主键
     * @return 景区回复表
     */
    public SpotReply selectSpotReplyById(Long id);

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
     * 批量删除景区回复表
     * 
     * @param ids 需要删除的景区回复表主键集合
     * @return 结果
     */
    public int deleteSpotReplyByIds(Long[] ids);

    /**
     * 删除景区回复表信息
     * 
     * @param id 景区回复表主键
     * @return 结果
     */
    public int deleteSpotReplyById(Long id);
}
