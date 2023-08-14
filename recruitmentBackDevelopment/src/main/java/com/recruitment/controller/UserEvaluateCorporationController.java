package com.recruitment.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.recruitment.dao.UserEvaluateCorporationDao;
import com.recruitment.domain.UserEvaluateCorporation;
import com.recruitment.service.impl.UserEvaluateCorporationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 使用者 前端控制器
 * </p>
 *
 * @author 王磊
 * @since 2022-05-27
 */
@RestController
@RequestMapping("/userEvaluateCorporation")
public class UserEvaluateCorporationController {
    @Autowired
    private UserEvaluateCorporationServiceImpl  userEvaluateCorporationService;

    /**
     * 增加 评价
     */
    @PostMapping
    public Result createEvaluate(@RequestBody  UserEvaluateCorporation userEvaluateCorporation) {
//        判断是否评价过
        boolean res = userEvaluateCorporationService.isEvaluate(userEvaluateCorporation.getUserId(), userEvaluateCorporation.getCorporationId());
        if(res){
            return  new Result(Code.isEvaluate_ok, res, Code.isEvaluate__ok_msg);
        }
        else {
            boolean res1 = userEvaluateCorporationService.createEvaluate(userEvaluateCorporation);
            if (res1) {
                return new Result(Code.createEvaluate_ok, res1, Code.createEvaluate_ok_msg);
            } else {
                return new Result(Code.createEvaluate_err, res1, Code.createEvaluate_err_msg);
            }
        }
    }
    /**
     * 查询公司平均分数
     */
    @GetMapping("/getAverageScore/{corporationId}")
    public Result getAverageScore(@PathVariable String corporationId) {
        double res=  userEvaluateCorporationService.getAverageScore(corporationId);
        ;
        if (res !=0) {
            return new Result(Code.getAverageScore_ok, res, Code.getAverageScore_ok_msg);
        } else {
            return new Result(Code.getAverageScore_err, res, Code.getAverageScore_err_msg);
        }
    }
    /**
     * 查询评价的人数
     */
    @GetMapping("/getEvaluatePerson/{corporationId}")
    public Result getEvaluatePerson(@PathVariable String corporationId) {
        Integer res=  userEvaluateCorporationService.getEvaluatePerson(corporationId);;
        if (res !=0) {
            return new Result(Code.getEvaluatePerson_ok, res, Code.getEvaluatePerson_ok_msg);
        } else {
            return new Result(Code.getEvaluatePerson_err, res, Code.getEvaluatePerson_err_msg);
        }
    }
    /**
     * 根据公司ID查询所有评论
     */
    @GetMapping("/getAllEvaluate/{corporationId}")
    public Result getAllEvaluate(@PathVariable String corporationId) {
        Object res=  userEvaluateCorporationService.getAllEvaluate(corporationId);;
        if (res !=null) {
            return new Result(Code.getAllEvaluate_ok, res, Code.getAllEvaluate_ok_msg);
        } else {
            return new Result(Code.getAllEvaluate_err, res, Code.getAllEvaluate_err_msg);
        }

        }
}

