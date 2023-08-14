package com.recruitment.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.recruitment.domain.Resume;
import com.recruitment.service.impl.ResumeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

/**
 * <p>
 * 简历 前端控制器
 * </p>
 *
 * @author 王磊
 * @since 2022-05-08
 */
@RestController
@RequestMapping("/resume")
@ResponseBody
public class ResumeController {
    @Autowired
    private ResumeServiceImpl resumeService;
    /**
     * 根据用户ID 创建简历 简历中owner 与ID一直
     */
    @PostMapping
    public Result creatResumeByUserId(@RequestBody Resume resume) {
        Boolean res = resumeService.creatResumeByUserId(resume);

        if (res) {
            return new Result(Code.creatResumeByUserId_ok, res, Code.creatResumeByUserId_ok_msg);
        } else {
            return new Result(Code.creatResumeByUserId_err, res, Code.creatResumeByUserId_err_msg);
        }
    }
    /**
     * 根据用户ID 修改简历 简历中owner 与ID一直
     */
    @PutMapping
    public Result modifyResumeByUserId(@RequestBody Resume resume) {
        Boolean res = resumeService.modifyResumeByUserId(resume);
        if (res) {
            return new Result(Code.modifyResumeByUserId_ok, res, Code.modifyResumeByUserId_ok_msg);
        } else {
            return new Result(Code.modifyResumeByUserId_err, res, Code.modifyResumeByUserId_err_msg);
        }
    }
    /**
     * 根据用户ID 查询简历 简历中owner 与ID一直
     */
    @GetMapping("/{id}")
    public Result getResumeByUserId(@PathVariable String id) {
        Object res= resumeService.getResumeByUserId(id);
        if (res!=null) {
            return new Result(Code.getResumeByUserId_ok, res, Code.getResumeByUserId_ok_msg);
        } else {
            return new Result(Code.getResumeByUserId_err, res, Code.getResumeByUserId_err_msg);
        }
    }
    /**
     * 查询所有简历
     */
    @GetMapping
    public Result getAllResume() {
        Object res= resumeService.getAllResume();
        if (res!=null) {
            return new Result(Code.getAllResume_ok, res, Code.getAllResume_ok_msg);
        } else {
            return new Result(Code.getAllResume_err, res, Code.getAllResume_err_msg);
        }
    }
    /**
     * 按照学历筛选简历
     */
    @GetMapping("/getAResumeByEducation/{education}")
    public Result getAResumeByEducation(@PathVariable String education) {
        Object res= resumeService.getAResumeByEducation(education);
        if (res!=null) {
            return new Result(Code.getAResumeByEducation_ok, res, Code.getAResumeByEducation_ok_msg);
        } else {
            return new Result(Code.getAResumeByEducation_err, res, Code.getAResumeByEducation_err_msg);
        }
    }

    /**
     * 按照年龄筛选简历
     */
    @GetMapping("/getResumeByAge")
    public Result getResumeByAge(Integer minAge,Integer maxAge) {
//        获取当前年份
        Object res= resumeService.getResumeByAge(minAge,maxAge);
        if (res!=null) {
            return new Result(Code.getResumeByAge_ok, res, Code.getResumeByAge_ok_msg);
        } else {
            return new Result(Code.getResumeByAge_err, res, Code.getResumeByAge_err_msg);
        }
    }
    /**
     * 根据用户ID 删除简历
     */
    @DeleteMapping("/{id}")
    public Result deleteResumeByUserId(@PathVariable String id) {
        boolean res= resumeService.deleteResumeByUserId(id);
        if (res) {
            return new Result(Code.deleteResumeByUserId_ok, res, Code.deleteResumeByUserId_ok_msg);
        } else {
            return new Result(Code.deleteResumeByUserId_err, res, Code.deleteResumeByUserId_err_msg);
        }
    }
    /**
     * 按照工作经验筛选简历
     */
    @GetMapping("/getResumeByWorkExperience/{workecpericeRequirement}")
    public Result getResumeByWorkExperience(@PathVariable Integer workecpericeRequirement){
        Object res= resumeService.getResumeByWorkExperience(workecpericeRequirement);
        if (res!=null) {
            return new Result(Code.getResumeByWorkExperience_ok, res, Code.getResumeByWorkExperience_ok_msg );
        } else {
            return new Result(Code.getResumeByWorkExperience_err, res, Code.getResumeByWorkExperience_err_msg);
        }

    };


}

