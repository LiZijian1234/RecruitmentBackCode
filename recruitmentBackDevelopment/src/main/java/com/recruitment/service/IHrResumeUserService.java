package com.recruitment.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.recruitment.domain.HrResumeUser;

import java.util.List;

/**
 * <p>
 * 使用者 服务类
 * </p>
 *
 * @author 王磊
 * @since 2022-05-25
 */
public interface IHrResumeUserService extends IService<HrResumeUser> {
    /**
     * 判断 是否已经投递
     */

    Boolean isSubmitResume(String hrId, String postIduseless,String resumeId);
    /**
     * 投递简历
     */
    Boolean submitResume(String hrId, String postIduseless,String resumeId);
    /**
     * 根据hr id 批量查询已收简历
     */
    List getResumeByHrId(String HrId);
    /**
     * 根据hr id 统计已收简历
     */
    Integer countResumeByHrId(String HrId);
    /**
     * 根据hr id 批量查询未审核的简历
     */
    List getUnhandleResumeByHrId(String HrId);
    /**
     * 根据hr id 统计未审核的简历
     */
   Integer countUnhandleResumeByHrId(String HrId);

    /**
     *  逻辑删除
     */
    Boolean deleteSubmitResume(String postIduseless,String resumeId);

    /**
     * 根据resumeid查询投的岗位iduseless
     */
    List getPostByResumeId(String resumeId);
    /**
     * 根据岗位查询投的简历id
     */
    List getResumeByPostIduseless(String PostIduseless);
    /**
     * 用户查询自己的简历状态码
     */
    List getResumeStatusByPostIduseless(String PostIduseless,String resumeId);
    /**
     * hr 对简历处理 审核通过
     */
    Boolean passResumeStatusByPostIduseless(String resumeId, String postIduseless);
    /**
     * hr 对简历处理 审核不通过
     */
    Boolean rejectResumeStatusByPostIduseless(String resumeId, String postIduseless);
    /**
     * 根据 单个用户ID 查询简历状态
     */
    List<Object> selectResumeStatusByid(String resumeId);




}
