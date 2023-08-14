package com.recruitment.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.recruitment.constCode.EvaluateLikeDislikeConstCode;
import com.recruitment.domain.EvaluateLikeDislike;
import com.recruitment.service.impl.EvaluateLikeDislikeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 使用者 前端控制器
 * </p>
 *
 * @author 王磊
 * @since 2022-06-08
 */
@RestController
@RequestMapping("/evaluateLikeDislike")
public class EvaluateLikeDislikeController {
    @Autowired
    private EvaluateLikeDislikeServiceImpl evaluateLikeDislikeService;
    /**
     * 判断是否已经点赞或者踩
     */

    @GetMapping("/isLikeOrDislike")
    public Result isLike(String evaluateOwner, String oprationer,String evaluateCorporation) {
//        是否存在
        if(!evaluateLikeDislikeService.isExist(evaluateOwner,oprationer,evaluateCorporation)){
            return new Result(Code.notExist, false, Code.notExist_msg);
        }
        //是否喜欢
       if(evaluateLikeDislikeService.isLike(evaluateOwner,oprationer,evaluateCorporation)){
           return new Result(Code.hasLike, true, Code.hasLike_msg);
       }
       //是否不喜欢
        if(evaluateLikeDislikeService.isDislike(evaluateOwner,oprationer,evaluateCorporation)){
            return new Result(Code.hasDislike, true, Code.hasDislike_msg);
        }
        else {return new Result(Code.abnormal, false, Code.abnormal_msg);}

    }


    /**
     * 踩
     */
    @PutMapping("/dislike")
    public Result dislike(String evaluateOwner, String oprationer,String evaluateCorporation) {
        boolean res;
        //        是否存在 /不存在创建数据 取消其他操作 执行操作   /已存在 取消其他操作  执行该操作
        if(!evaluateLikeDislikeService.isExist(evaluateOwner,oprationer,evaluateCorporation)){
//            创建数据
            evaluateLikeDislikeService.createData(evaluateOwner,oprationer,evaluateCorporation);
//            执行操作
            res = evaluateLikeDislikeService.dislike(evaluateOwner,oprationer,evaluateCorporation);
        }

        else {
//                取消其他操作
            evaluateLikeDislikeService.cancelLike(evaluateOwner, oprationer,evaluateCorporation);
//            执行该操作
             res = evaluateLikeDislikeService.dislike(evaluateOwner, oprationer,evaluateCorporation);
        }
        if (res) {
            return new Result(Code.dislike_ok, res, Code.dislike_ok_msg);
        } else {
            return new Result(Code.dislike_err, res, Code.dislike_err_msg);
        }
    }
    /**
     * 点赞
     */
    @PutMapping("/like")
    public Result like(String evaluateOwner, String oprationer,String evaluateCorporation) {
        boolean res;
        //        是否存在 /不存在创建数据 取消其他操作 执行操作   /已存在 取消其他操作  执行该操作
        if(!evaluateLikeDislikeService.isExist(evaluateOwner,oprationer,evaluateCorporation)){
//            创建数据
            evaluateLikeDislikeService.createData(evaluateOwner,oprationer,evaluateCorporation);
//            执行操作
            res = evaluateLikeDislikeService.like(evaluateOwner,oprationer,evaluateCorporation);
        }
        else {
//                取消其他操作
            evaluateLikeDislikeService.cancelDislike(evaluateOwner, oprationer,evaluateCorporation);
//            执行该操作
            res = evaluateLikeDislikeService.like(evaluateOwner, oprationer,evaluateCorporation);
        }
        if (res) {
            return new Result(Code.like_ok, res, Code.like_ok_msg);
        } else {
            return new Result(Code.like_err, res, Code.like_err_msg);
        }
    }
    /**
     * 取消踩
     */
    @PutMapping("/cancelDislike")
    public Result cancelDislike(String evaluateOwner, String oprationer,String evaluateCorporation) {
        Boolean res = evaluateLikeDislikeService.cancelDislike(evaluateOwner, oprationer,evaluateCorporation);
        if (res) {
            return new Result(Code. cancelDislike_ok, res, Code.cancelDislike_ok_msg);
        } else {
            return new Result(Code. cancelDislike_err, res, Code. cancelDislike_err_msg);
        }
    }
    /**
     * 取消点赞
     */
    @PutMapping("/cancelLike")
    public Result cancelLike(String evaluateOwner, String oprationer,String evaluateCorporation) {
        Boolean res = evaluateLikeDislikeService.cancelLike(  evaluateOwner,  oprationer,evaluateCorporation);
        if (res) {
            return new Result(Code. cancelLike_ok, res, Code.cancelLike_ok_msg);
        } else {
            return new Result(Code. cancelLike_err, res, Code.cancelLike_err_msg);
        }
    }
    /**
     * 统计某个评价点赞数
     */
    @GetMapping("/countLike")
    public Result countLikePeople( String evaluateOwner,String evaluateCorporation) {
        Integer res = evaluateLikeDislikeService.countLikePeople(  evaluateOwner,evaluateCorporation);
        return new Result(Code.countLikePeople_ok, res, Code. countLikePeople_ok_msg);
    }
    /**
     * 统计某个评价踩数
     */
    @GetMapping("/countDislike")
    public Result countDislikePeople( String evaluateOwner,String evaluateCorporation) {
        Integer res = evaluateLikeDislikeService.countDislikePeople(  evaluateOwner,evaluateCorporation);
        return new Result(Code. countDislikePeople_ok, res, Code.countDislikePeople_ok_msg);
    }

}

