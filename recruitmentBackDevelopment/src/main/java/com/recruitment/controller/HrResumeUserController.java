package com.recruitment.controller;


import com.recruitment.service.impl.HrResumeUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.io.File.separator;

/**
 * <p>
 * 使用者 前端控制器
 * </p>
 *
 * @author 王磊
 * @since 2022-05-25
 */
@RestController
@RequestMapping("/hrResumeUser")
public class HrResumeUserController {
    @Autowired
    private HrResumeUserServiceImpl hrResumeUserService;

    /**
     * 投递简历
     */
    @PostMapping("/submitResume")
    public Result submitResume(String hrId, String postIduseless, String resumeId) {
        boolean res = hrResumeUserService.isSubmitResume(hrId,postIduseless,resumeId);
        if(res){
            return  new Result(Code.hasSubmitResume_ok, res, Code.hasSubmitResume_ok_msg);
        }
        else {
            boolean res1 = hrResumeUserService.submitResume(hrId,postIduseless,resumeId) ;
            if (res1) {
                return new Result(Code.submitResume_ok, res1, Code.submitResume_ok_msg);
            } else {
                return new Result(Code.submitResume_err, res1, Code.submitResume_err_msg);
            }
        }
    }
    /**
     * 根据hr id 批量查询已收简历
     */
    @GetMapping("/getResumeIdByHrId/{HrId}")
    public Result getResumeByHrId(@PathVariable String HrId) {
        Object res= hrResumeUserService.getResumeByHrId(HrId);
        if (res!=null) {
            return new Result(Code.getResumeByHrId_ok, res, Code.getResumeByHrId_ok_msg);
        } else {
            return new Result(Code.getResumeByHrId_err, res, Code.getResumeByHrId_err_msg);
        }

    }
    /**
     * 根据hr id 统计已收简历
     */
    @GetMapping("/countResumeByHrId/{hrid}")
    public Result countResumeByHrId(@PathVariable String hrId) {
        Object res= hrResumeUserService.countResumeByHrId(hrId);
        if (res!=null) {
            return new Result(Code.countResumeByHrId_ok, res, Code.countResumeByHrId_ok_msg);
        } else {
            return new Result(Code.countResumeByHrId_err, res, Code.countResumeByHrId_err_msg);
        }
    }
    /**
     * 根据hr id 批量查询未审核的简历
     *
     */
    @GetMapping("/getUnhandledResumeByHrId/{Hrid}")
    public Result getUnhandledResumeByHrId( @PathVariable String Hrid) {
        Object res= hrResumeUserService.getUnhandleResumeByHrId(Hrid);
        if (res!=null) {
            return new Result(Code.getUnhandleResumeByHrId_ok, res, Code.getUnhandleResumeByHrId_ok_msg);
        } else {
            return new Result(Code.getUnhandleResumeByHrId_err, res, Code.getUnhandleResumeByHrId_err_msg);
        }
    }
    /**
     * 根据hr id 统计未审核的简历
     */
    @GetMapping("/countUnhandleResumeByHrId/{HrId}")
    public Result countUnhandleResumeByHrId(@PathVariable String HrId) {
        Object res= hrResumeUserService.countResumeByHrId(HrId);
        if (res!=null) {
            return new Result(Code.countUnhandleResumeByHrId_ok, res, Code.countUnhandleResumeByHrId_ok_msg);
        } else {
            return new Result(Code.countUnhandleResumeByHrId_err, res, Code.countUnhandleResumeByHrId_err_msg);
        }
    }
    /**
     *  逻辑删除
     */
    @DeleteMapping
    public Result deleteSubmitResume(String postIduseless, String resumeId) {
        boolean res= hrResumeUserService.deleteSubmitResume(postIduseless,resumeId);
        if (res) {
            return new Result(Code.deleteSubmitResume_ok, res, Code.deleteSubmitResume_ok_msg);
        } else {
            return new Result(Code.deleteSubmitResume_err, res, Code.deleteSubmitResume_err_msg);
        }

    }
    /**
     * 根据resumeid查询投的岗位iduseless
     */
    @GetMapping("/getPostByResumeId/{resumeId}")
    public Result  getPostByResumeId(@PathVariable String resumeId) {
        Object res= hrResumeUserService.getPostByResumeId(resumeId);
        if (res!=null) {
            return new Result(Code.getPostByResumeId_ok, res, Code.getPostByResumeId_ok_msg);
        } else {
            return new Result(Code.getPostByResumeId_err, res, Code.getPostByResumeId_err_msg);
        }

    }
    /**
     * 根据岗位查询投的简历id
     */
    @GetMapping("/getResumeByPostIduseless/{PostIduseless}")
    public Result getResumeByPostIduseless(@PathVariable String PostIduseless) {
        Object res= hrResumeUserService.getResumeByPostIduseless(PostIduseless);
        if (res!=null) {
            return new Result(Code.getResumeByPostIduseless_ok, res, Code.getResumeByPostIduseless_ok_msg);
        } else {
            return new Result(Code.getResumeByPostIduseless_err, res, Code.getResumeByPostIduseless_err_msg);
        }
    }

    /**
     * 用户查询自己的简历状态码
     */
    @GetMapping("/getResumeStatusByPostIduseless")
    public Result getResumeStatusByPostIduseless(String postIduseless, String resumeId) {
        Object res=  hrResumeUserService.getResumeStatusByPostIduseless(postIduseless, resumeId);
//        System.out.println(temp);
//        String res = org.apache.commons.lang3.StringUtils.join(temp.toArray(),separator);
        if (res !=null ) {
            return new Result(Code.getResumeStatusByPostIduseless_ok, res, Code.getResumeStatusByPostIduseless_ok_msg);
        } else {
            return new Result(Code.getResumeStatusByPostIduseless_err, res, Code.getResumeStatusByPostIduseless_err_msg);
        }
    }
    /**
     * hr 对简历处理 审核通过
     */
    @PutMapping("/passResumeStatusByPostIduseless")
    public Result passResumeStatusByPostIduseless(String resumeId, String postIduseless ) {
        Boolean res= hrResumeUserService.passResumeStatusByPostIduseless(resumeId,postIduseless);

        if (res) {
            return new Result(Code.passResumeStatusByPostIduseless_ok, res, Code.passResumeStatusByPostIduseless_ok_msg);
        } else {
            return new Result(Code.passResumeStatusByPostIduseless_err, res, Code.passResumeStatusByPostIduseless_err_msg);
        }
    }
    /**
     * hr 对简历处理 审核不通过
     */
    @PutMapping("/rejectResumeStatusByPostIduseless")
    public Result rejectResumeStatusByPostIduseless(String resumeId, String postIduseless) {
        boolean res= hrResumeUserService.rejectResumeStatusByPostIduseless(resumeId,postIduseless);
        if (res) {
            return new Result(Code.rejectResumeStatusByPostIduseless_ok, res, Code.rejectResumeStatusByPostIduseless_ok_msg);
        } else {
            return new Result(Code.rejectResumeStatusByPostIduseless_err, res, Code.rejectResumeStatusByPostIduseless_err_msg);
        }
    }

}

