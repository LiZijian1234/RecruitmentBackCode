package com.recruitment.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.recruitment.domain.Referrer;
import com.recruitment.domain.Resume;

import java.util.List;

/**
 * <p>
 * 使用者 服务类
 * </p>
 *
 * @author 王磊
 * @since 2022-06-18
 */
public interface IReferrerService extends IService<Referrer> {
    /**
     * 增加推荐人
     */
    Boolean creatRecommendedMember(String referrerId,String RecommendMemberId,String recommendedPostiduseless);
    /**
     * 判断 是否已经增加
     */
    Boolean isCreated(String referrerId,String RecommendMemberId,String recommendedPostiduseless);
    /**
     * 增加 已提现金额
     */
    Boolean creatWithdrawCash(String referrerId,Integer withdrawCash);
    /**
     * 查询园长的总积分
     */
    Integer selectReferrerTotalCash(String referrerId);
    /**
     * 查询园长 已提现金额
     */
    Integer selectWithdrawCash(String referrerId);
    /**
     * 查询所有园长的信息
     */
    List selectAllReferrerInfo( );
    /**
     * 查询所有被推荐人的简历进度
     */
    List selectRecommendedMemberInfo(String referrerId);

}
