package com.recruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.recruitment.dao.ResumeDao;
import com.recruitment.domain.PostPublicated;
import com.recruitment.domain.Resume;
import com.recruitment.domain.UserEvaluateCorporation;
import com.recruitment.service.IResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * <p>
 * 简历 服务实现类
 * </p>
 *
 * @author 王磊
 * @since 2022-05-08
 */
@Service
public class ResumeServiceImpl implements IResumeService {
    @Autowired
    private ResumeDao resumeDao;


    @Override
    public Boolean creatResumeByUserId(Resume resume) {

        try {
            return resumeDao.insert(resume)>0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean modifyResumeByUserId(Resume resume) {
        return resumeDao.updateById(resume)>0;

//        try {
//            return resumeDao.updateById(resume)>0;
//        } catch (Exception e) {
//            return false;
//        }
    }

    @Override
    public Resume getResumeByUserId(String id) {
        return resumeDao.selectById(id);
    }

    @Override
    public List<Resume> getAllResume() {
        return resumeDao.selectList(null);
    }

    /**
     * 按照学历筛选简历
     */
    @Override
    public List<Resume> getAResumeByEducation(String education) {
        LambdaQueryWrapper<Resume> lqw = new LambdaQueryWrapper<>();
        lqw.ge(Resume::getEducation,education);
        return resumeDao.selectList(lqw);
    }

    /**
     * 按照年龄筛选简历
     */
    @Override
    public List<Resume> getResumeByAge(Integer minAge,Integer maxAge) {
//        获取当前年份
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);

        LambdaQueryWrapper<Resume> lqw = new LambdaQueryWrapper<>();
        lqw.ge(Resume::getBornYear,(year-maxAge)).le(Resume::getBornYear,(year-minAge));
        return resumeDao.selectList(lqw);
    }

    /**
     * 根据用户ID 删除简历
     */
    @Override
    public Boolean deleteResumeByUserId(String id) {
        return resumeDao.deleteById(id)>0;
    }
    /**
     * 按照工作经验筛选简历
     */
    @Override
    public List<Resume> getResumeByWorkExperience(Integer workecpericeRequirement){
        LambdaQueryWrapper<Resume> lqw = new LambdaQueryWrapper<>();
        lqw.gt(Resume::getWorkTime,workecpericeRequirement);
        return resumeDao.selectList(lqw);

    };


}
