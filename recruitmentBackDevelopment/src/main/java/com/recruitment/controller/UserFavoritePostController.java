package com.recruitment.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.recruitment.domain.UserFavoritePost;
import com.recruitment.service.impl.UserFavoritePostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 王磊
 * @since 2022-05-24
 */
@RestController
@RequestMapping("/userFavoritePost")
public class UserFavoritePostController {
    @Autowired
    private UserFavoritePostServiceImpl userFavoritePostService;
    /**
     * 添加收藏
     */
    @PostMapping("/createUserFavoritePost")
    public Result createUserFavoritePost(String userIduseless, String postIduseless) {
        boolean res = userFavoritePostService.isUserFavoritePost(userIduseless,postIduseless);
        if(res){
            return  new Result(Code.hasUserFavoritePost_ok, res, Code.hasUserFavoritePost_ok_msg);
        }
        else {
            boolean res1 = userFavoritePostService.createUserFavoritePost(userIduseless, postIduseless);
            if (res1) {
                return new Result(Code.createUserFavoritePost_ok, res, Code.createUserFavoritePost_ok_msg);
            } else {
                return new Result(Code.createUserFavoritePost_err, res, Code.createUserFavoritePost_err_msg);
            }
        }
    }
    /**
     * 很具 用户IDuseless 查询 收藏的职位 id
     */
    @GetMapping("/selectUserFavoritePost/{userIduseless}")
    public Result selectUserFavoritePost(@PathVariable  String userIduseless) {
        Object res= userFavoritePostService.selectUserFavoritePost(userIduseless);
        if (res!=null) {
            return new Result(Code.selectUserFavoritePost_ok, res, Code.selectUserFavoritePost_ok_msg);
        } else {
            return new Result(Code.selectUserFavoritePost_err, res, Code.selectUserFavoritePost_err_msg);
        }
    }
    /**
     * 根据 两个iduseless 逻辑删除
     */
    @DeleteMapping
    public Result deleteUserFavoritePost(String userIduseless, String postIduseless) {
        Boolean res= userFavoritePostService.deleteUserFavoritePost(userIduseless,postIduseless);
        if (res) {
            return new Result(Code.deleteUserFavoritePost_ok, res, Code.deleteUserFavoritePost_ok_msg);
        } else {
            return new Result(Code.deleteUserFavoritePost_err, res, Code.deleteUserFavoritePost_err_msg);
        }
    }

}

