package com.recruitment.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.recruitment.domain.UserEvaluateCorporation;

import java.util.List;

/**
 * <p>
 * 使用者 服务类
 * </p>
 *
 * @author 王磊
 * @since 2022-05-27
 */
public interface IUserEvaluateCorporationService extends IService<UserEvaluateCorporation> {
/**
 * 判断是否评价过
 */
Boolean isEvaluate(String userId, String corporationId);
/**
 * 增加 评价
 */
Boolean createEvaluate(UserEvaluateCorporation userEvaluateCorporation);
/**
 * 公司平均分数
 */
double getAverageScore(String corporationId);
/**
 * 评价的人数
 */
Integer getEvaluatePerson(String corporationId);
/**
 * 根据公司ID查询所有评论
 */
List getAllEvaluate(String corporationId);

}
