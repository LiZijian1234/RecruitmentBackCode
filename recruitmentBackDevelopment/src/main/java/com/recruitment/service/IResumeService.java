package com.recruitment.service;

import com.recruitment.domain.Resume;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 简历 服务类
 * </p>
 *
 * @author 王磊
 * @since 2022-05-08
 */
@Transactional
//@Service
public interface IResumeService {
    /**
     * 根据用户ID 创建简历 简历中Id与ID一直
     */
Boolean creatResumeByUserId(Resume resume);
/**
 * 根据用户ID 修改简历 简历中Id 与ID一直
 */
Boolean modifyResumeByUserId(Resume resume);
/**
 * 根据用户ID 查询简历 简历中Id与ID一直
 */
Resume getResumeByUserId(String owner);
/**
 * 查询所有简历
 */
List<Resume> getAllResume();
    /**
     * 按照学历筛选简历
     */
    List<Resume> getAResumeByEducation(String education);
    /**
     * 按照年龄筛选简历
     */
    List<Resume> getResumeByAge(Integer minAge,Integer maxAge) ;
    /**
     * 根据用户ID 删除简历
     */
    Boolean deleteResumeByUserId(String id);
/**
 * 按照工作经验筛选简历
 */
List<Resume> getResumeByWorkExperience(Integer workecpericeRequirement);

}
