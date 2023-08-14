package com.recruitment.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.recruitment.domain.HrResumeUser;
import com.recruitment.domain.Referrer;
import com.recruitment.domain.User;
import com.recruitment.service.impl.ReferrerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 使用者 前端控制器
 * </p>
 *
 * @author 王磊
 * @since 2022-06-18
 */
@RestController
@RequestMapping("/referrer")
public class ReferrerController {
    @Autowired
    private ReferrerServiceImpl referrerService;
    /**
     * 增加推荐人
     */
    @PostMapping("/creatRecommendedMember")
    public Result creatRecommendedMember(String referrerId, String recommendMemberId,String recommendedPostiduseless) {
        if (referrerService.isCreated(referrerId,recommendMemberId,recommendedPostiduseless)){
            return new Result(Code. isCreated_ok, true, Code.isCreated_ok_msg);
        }
        else {Object res= referrerService.creatRecommendedMember(referrerId,recommendMemberId,recommendedPostiduseless);
            if (res!=null) {
                return new Result(Code. creatRecommendedMember_ok, res, Code. creatRecommendedMember_ok_msg);
            } else {
                return new Result(Code.creatRecommendedMember_err, res, Code. creatRecommendedMember_err_msg);
            }}


    }
    /**
     * 增加 已提现金额 放在tbl_user表里
     */
    @PutMapping("/creatWithdrawCash")
    public Result creatWithdrawCash(String referrerId, Integer withdrawCash) {
        Object res= referrerService.creatWithdrawCash(referrerId,withdrawCash);
        if (res!=null) {
            return new Result(Code.creatWithdrawCash_ok, res, Code.creatWithdrawCash_ok_msg);
        } else {
            return new Result(Code.creatWithdrawCash_err, res, Code.creatWithdrawCash_err_msg);
        }
    }

    /**
     * 查询园长的总积分
     */
    @GetMapping("/selectReferrerTotalCash/{referrerId}")
    public Result selectReferrerTotalCash(@PathVariable String referrerId) {
        Object res = referrerService.selectReferrerTotalCash(referrerId);
        if (res != null) {
            return new Result(Code.selectReferrerTotalCash_ok, res, Code.selectReferrerTotalCash_ok_msg);
        } else {
            return new Result(Code.selectReferrerTotalCash_err, res, Code.selectReferrerTotalCash_err_msg);
        }
    }
    /**
     * 查询园长 已提现金额
     */
    @GetMapping("/selectWithdrawCash/{referrerId}")
    public Result selectWithdrawCash(@PathVariable String referrerId) {
            Object res= referrerService.selectWithdrawCash(referrerId);
            if (res!=null) {
                return new Result(Code.selectWithdrawCash_ok, res, Code.selectWithdrawCash_ok_msg);
            } else {
                return new Result(Code.selectWithdrawCash_err, res, Code.selectWithdrawCash_err_msg);
            }
        }



    /**
     * 查询所有园长的信息
     */
    @GetMapping("/selectAllReferrerInfo")
    public Result selectAllReferrerInfo( ) {
        Object res= referrerService.selectAllReferrerInfo( );
        if (res!=null) {
            return new Result(Code.selectAllReferrerInfo_ok, res, Code.selectAllReferrerInfo_ok_msg);
        } else {
            return new Result(Code.selectAllReferrerInfo_err, res, Code.selectAllReferrerInfo_err_msg);
        }

    }
    /**
     * 查询该园长所有被推荐人的简历进度
     */
    @GetMapping("/selectRecommendedMemberInfo/{referrerId}")
    public Result selectRecommendedMemberInfo(@PathVariable String referrerId){
        Object res= referrerService.selectRecommendedMemberInfo(referrerId);
        if (res!=null) {
            return new Result(Code.selectRecommendedMemberInfo_ok, res, Code. selectRecommendedMemberInfo_ok_msg);
        } else {
            return new Result(Code.selectRecommendedMemberInfo_err, res, Code.selectRecommendedMemberInfo_err_msg);
        }

    }
    /**
     * 查询园长 可提现金额
     */
    @GetMapping("/selectRemainedWithdrawCash/{referrerId}")
    public Result selectRemainedWithdrawCash(@PathVariable String referrerId) {

        int i = referrerService.selectReferrerTotalCash(referrerId) - referrerService.selectWithdrawCash(referrerId);
        Object res = i ;
        if (res !=null) {
            return new Result(Code.selectRemainedWithdrawCash_ok, res, Code.selectRemainedWithdrawCash_ok_msg);
        } else {
            return new Result(Code.selectRemainedWithdrawCash_err, res, Code.selectRemainedWithdrawCash_err_msg);
        }
    }

}

