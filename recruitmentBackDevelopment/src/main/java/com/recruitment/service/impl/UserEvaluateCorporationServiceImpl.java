package com.recruitment.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.recruitment.dao.UserEvaluateCorporationDao;
import com.recruitment.domain.UserEvaluateCorporation;
import com.recruitment.service.IUserEvaluateCorporationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 使用者 服务实现类
 * </p>
 *
 * @author 王磊
 * @since 2022-05-27
 */
@Service
public class UserEvaluateCorporationServiceImpl extends ServiceImpl<UserEvaluateCorporationDao, UserEvaluateCorporation> implements IUserEvaluateCorporationService {
    @Autowired
    private UserEvaluateCorporationDao userEvaluateCorporationDao;
    /**
     * 判断是否评价过
     */
    @Override
    public Boolean isEvaluate(String userId, String corporationId) {
        LambdaQueryWrapper<UserEvaluateCorporation> lqw = new LambdaQueryWrapper<>();
        lqw.select(UserEvaluateCorporation::getIdUseless).eq(UserEvaluateCorporation::getUserId,userId).eq(UserEvaluateCorporation::getCorporationId,corporationId);
        return userEvaluateCorporationDao.selectCount(lqw)>0;
    }
    /**
     * 增加 评价
     */
    @Override
    public Boolean createEvaluate(UserEvaluateCorporation userEvaluateCorporation) {
        return userEvaluateCorporationDao.insert(userEvaluateCorporation)>0;
    }
    /**
     * 公司平均分数
     */
    @Override
    public double getAverageScore(String corporationId) {
        LambdaQueryWrapper<UserEvaluateCorporation> lqw1 = new LambdaQueryWrapper<>();
        //根据公司id 查询所有用户评分 计算分数总和

        lqw1.select(UserEvaluateCorporation::getUserScore).eq(UserEvaluateCorporation::getCorporationId,corporationId);

        double personNumber =  userEvaluateCorporationDao.selectCount(lqw1);
        if(personNumber== 0){
            return 0;
        }

        List scoreList =  userEvaluateCorporationDao.selectObjs(lqw1);
        double sum =0.0;
        for (int i = 0; i < scoreList.size(); i++) {
            sum += Double.parseDouble((String) scoreList.get(i));
//        
        }
        return sum/personNumber;
    }
    /**
     * 评价的人数
     */
    @Override
    public Integer getEvaluatePerson(String corporationId) {
        LambdaQueryWrapper<UserEvaluateCorporation> lqw1 = new LambdaQueryWrapper<>();
       lqw1.select(UserEvaluateCorporation::getUserScore).eq(UserEvaluateCorporation::getCorporationId,corporationId);

        int personNumber =  userEvaluateCorporationDao.selectCount(lqw1);
        return personNumber;
    }
    /**
     * 根据公司ID查询所有评论
     */
    @Override
    public List getAllEvaluate(String corporationId) {
        LambdaQueryWrapper<UserEvaluateCorporation> lqw = new LambdaQueryWrapper<>();
        lqw.eq(UserEvaluateCorporation::getCorporationId,corporationId);
       return userEvaluateCorporationDao.selectList(lqw);
    }
}
