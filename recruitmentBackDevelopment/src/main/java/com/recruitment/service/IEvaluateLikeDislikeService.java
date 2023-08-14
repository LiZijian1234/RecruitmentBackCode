package com.recruitment.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.recruitment.domain.EvaluateLikeDislike;

/**
 * <p>
 * 使用者 服务类
 * </p>
 *
 * @author 王磊
 * @since 2022-06-08
 */
public interface IEvaluateLikeDislikeService extends IService<EvaluateLikeDislike> {
    /**
     *判端数据是否存在
     */
    boolean isExist(String evaluateOwner,String oprationer,String evaluateCorporation);
    /**
     * 新增 数据
     */
    boolean createData(String evaluateOwner,String oprationer,String evaluateCorporation);
    /**
     * 判断是否已经点赞
     */
    boolean isLike(String evaluateOwner,String oprationer,String evaluateCorporation);
    /**
     * 判断是否已经踩
     */
    boolean isDislike(String evaluateOwner,String oprationer,String evaluateCorporation);
    /**
     * 踩
     */
    boolean dislike(String evaluateOwner,String oprationer,String evaluateCorporation);
    /**
     * 点赞
     */
    boolean like(String evaluateOwner,String oprationer,String evaluateCorporation);
    /**
     * 取消踩
     */
    boolean cancelDislike(String evaluateOwner,String oprationer,String evaluateCorporation);
    /**
     * 取消点赞
     */
    boolean cancelLike(String evaluateOwner,String oprationer,String evaluateCorporation);
    /**
     * 统计某个评价点赞数
     */
    Integer countLikePeople(String evaluateOwner,String evaluateCorporation);
    /**
     * 统计某个评价踩数
     */
    Integer countDislikePeople(String evaluateOwner,String evaluateCorporation);
}
