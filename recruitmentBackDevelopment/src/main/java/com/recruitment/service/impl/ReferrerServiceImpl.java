package com.recruitment.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.recruitment.dao.HrResumeUserDao;
import com.recruitment.dao.ReferrerDao;
import com.recruitment.dao.UserDao;
import com.recruitment.domain.HrResumeUser;
import com.recruitment.domain.Referrer;
import com.recruitment.domain.Resume;
import com.recruitment.domain.User;
import com.recruitment.service.IReferrerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.recruitment.constCode.ResumeStatusCashCountConstCode.*;

/**
 * <p>
 * 使用者 服务实现类
 * </p>
 *
 * @author 王磊
 * @since 2022-06-18
 */
@Service
public class ReferrerServiceImpl extends ServiceImpl<ReferrerDao, Referrer> implements IReferrerService {
    @Autowired
    private ReferrerDao referrerDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private HrResumeUserDao hrResumeUserDao;
    /**
     * 根据简历状态 返回积分 函数
     */
    public Integer countCashByResumeStatus(String resumeStatus){
        if(resumeStatus.equals(UNHANDLE)){
            return UNHANDLECOUNT;
        }
        else if(resumeStatus.equals(UNAPPROVED)){
            return UNAPPROVEDCOUNT;
        }
        else if(resumeStatus.equals(UNINTERVIEW)){
            return UNINTERVIEWCOUNT;
        }
        else {
            return UNSUBMITCOUNT;
        }
    }


    /**
     * 增加推荐人
     */
    @Override
    public Boolean creatRecommendedMember(String referrerId, String RecommendMemberId,String recommendedPostiduseless) {
        Referrer referrer = new Referrer();
        referrer.setRecommendedMemberId(RecommendMemberId);
        referrer.setId(referrerId);
        referrer.setRecommendedPostiduseless(recommendedPostiduseless);
        return referrerDao.insert(referrer)>0;
    }
    /**
     * 判断 是否已经增加
     */
    @Override
    public Boolean isCreated(String referrerId, String RecommendMemberId, String recommendedPostiduseless) {
        LambdaQueryWrapper<Referrer> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Referrer::getRecommendedMemberId,RecommendMemberId).eq(Referrer::getRecommendedPostiduseless,recommendedPostiduseless).eq(Referrer::getId,referrerId);
        return referrerDao.selectCount(lqw)>0;
    }


    /**
     * 增加 已提现金额 放在tbl_user表里
     */
    @Override
    public Boolean creatWithdrawCash(String referrerId, Integer withdrawCash) {
//        创建新的User
        User user1 = new User();
//        获取已有的体现金额
        LambdaQueryWrapper<User> lqw1 = new LambdaQueryWrapper<>();
        lqw1.select(User::getWithdrawCash).eq(User::getId,referrerId);
        User user = userDao.selectOne(lqw1);

            Integer preWithdrawcash  = user.getWithdrawCash();
//        进行金额相加 和 更新
            user1.setId(referrerId);
            user1.setWithdrawCash(withdrawCash+preWithdrawcash);



        return userDao.updateById(user1)>0;
    }

    /**
     * 查询园长的总积分
     */
    @Override
    public Integer selectReferrerTotalCash(String referrerId) {
        int sum =0;
//        提取园长所有的被推荐人id 和 被推荐岗位
        LambdaQueryWrapper<Referrer> lqw = new LambdaQueryWrapper<>();

        lqw.select(Referrer::getRecommendedMemberId,Referrer::getRecommendedPostiduseless).eq(Referrer::getId,referrerId);
        List<Referrer> recommendedIdAndRecommendedPostiduseless = referrerDao.selectList(lqw);
        System.out.println(recommendedIdAndRecommendedPostiduseless);
//        被推荐人id去重（不需要了）
////        set去重
//        Set set = new HashSet();
//        for (Object value : recommendedId) {
//            set.add(value);
//        }

//        遍历所有被推荐人id 和 RecommendedPostiduseless 查询其简历状态 并计算积分
        for (int i = 0; i < recommendedIdAndRecommendedPostiduseless.size(); i++) {

            //提取 被推荐人id 和 RecommendedPostiduseless 对应的单个简历
            LambdaQueryWrapper<HrResumeUser> lqw1 = new LambdaQueryWrapper<>();
            lqw1.select(HrResumeUser::getResumeStatus)
                 .eq(HrResumeUser::getResumeId,recommendedIdAndRecommendedPostiduseless.get(i).getRecommendedMemberId())
                    .eq(HrResumeUser::getPostIduseless,recommendedIdAndRecommendedPostiduseless.get(i).getRecommendedPostiduseless());
            List<Object> objects = hrResumeUserDao.selectObjs(lqw1);
            // 单个简历对应的积分 由于返回默认数列 只好进行循环 其实数列里只有一个
            for (int i1 = 0; i1 < objects.size(); i1++) {
                sum += countCashByResumeStatus((String) objects.get(i1));

            }

    }
        return sum;
    }
    /**
     * 查询园长 已提现金额
     */
    @Override
    public Integer selectWithdrawCash(String referrerId) {
        LambdaQueryWrapper<User> lqw1 = new LambdaQueryWrapper<>();
        lqw1.select(User::getWithdrawCash).eq(User::getId,referrerId);
        User user = userDao.selectOne(lqw1);
        Integer preWithdrawcash  = user.getWithdrawCash();

        return preWithdrawcash;
    }
    /**
     * 查询所有园长的信息
     */
    @Override
    public List selectAllReferrerInfo( ) {
//        LambdaQueryWrapper<Referrer> lqw = new LambdaQueryWrapper<>();
//        lqw.eq(Referrer::getId,referrerId);
        return referrerDao.selectList(null);
    }
    /**
     * 查询所有被推荐人的简历进度
     */
    @Override
    public List selectRecommendedMemberInfo(String referrerId) {
        int sum = 0;
//        提取园长所有的被推荐人id 和 被推荐岗位
        LambdaQueryWrapper<Referrer> lqw = new LambdaQueryWrapper<>();

        lqw.select(Referrer::getRecommendedMemberId, Referrer::getRecommendedPostiduseless).eq(Referrer::getId, referrerId);
        List<Referrer> recommendedIdAndRecommendedPostiduseless = referrerDao.selectList(lqw);
        System.out.println(recommendedIdAndRecommendedPostiduseless);


//        遍历所有被推荐人id 和 RecommendedPostiduseless 查询其简历状态 并计算积分
        List<HrResumeUser> resumeStatusLists = null;
        for (int i = 0; i < recommendedIdAndRecommendedPostiduseless.size(); i++) {

            //提取 被推荐人id 和 RecommendedPostiduseless 对应的单个简历
            LambdaQueryWrapper<HrResumeUser> lqw1 = new LambdaQueryWrapper<>();
            lqw1.eq(HrResumeUser::getResumeId, recommendedIdAndRecommendedPostiduseless.get(i).getRecommendedMemberId())
                    .eq(HrResumeUser::getPostIduseless, recommendedIdAndRecommendedPostiduseless.get(i).getRecommendedPostiduseless());
            List<HrResumeUser> objects = hrResumeUserDao.selectList(lqw1);
//            合并数列
            if(resumeStatusLists == null){
                resumeStatusLists = objects;
            }
            else {
                resumeStatusLists.addAll(objects);

            }
        }
        return resumeStatusLists;
    }
}
