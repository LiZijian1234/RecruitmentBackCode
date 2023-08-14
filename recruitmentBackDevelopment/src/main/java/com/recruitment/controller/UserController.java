package com.recruitment.controller;


import com.recruitment.domain.User;
import com.recruitment.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 使用者 前端控制器
 * </p>
 *
 * @author 王磊
 * @since 2022-05-08
 */
@RestController
@RequestMapping("/user")
@ResponseBody
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    /**
     * 创建新用户
     */
    @PostMapping

    public Result createNewUser(@RequestBody User user) {
        Boolean res = userService.createNewUser(user);
        if (res) {
            return new Result(Code.createNewUser_ok, res, Code.createNewUser_ok_msg);
        } else {
            return new Result(Code.createNewUser_err, res, Code.createNewUser_err_msg);
        }
    }
    /**
     * 通过ID修改用户信息
     */

    @PutMapping
//    @ResponseBody
    public Result modifyUserInfoById(@RequestBody  User user) {
        Boolean res = userService.modifyUserInfoById(user);
        if (res) {
            return new Result(Code.modifyUserInfoById_ok, res, Code.modifyUserInfoById_ok_msg);
        } else {
            return new Result(Code.modifyUserInfoById_err, res, Code.modifyUserInfoById_err_msg);
        }
    }
    /**
     * 按照ID查询
     */
    @GetMapping("/{id}")
//    @ResponseBody
    public Result getById(@PathVariable String id) {
        Object res= userService.getUserInfoById(id);
        if (res!=null) {
            return new Result(Code.getUserInfoById_ok, res, Code.getUserInfoById_ok_msg);
        } else {
            return new Result(Code.getUserInfoById_err, res, Code.getUserInfoById_err_msg);
        }
    }

    /**
     * 查看所有用户信息（管理员权限）
     */
    @GetMapping
//    @RequestBody
    public Result getAll() {
        Object res= userService.getAllUserInfo();
        if (res!=null) {
            return new Result(Code.getAllUserInfo_ok, res, Code.getAllUserInfo_ok_msg);
        } else {
            return new Result(Code.getAllUserInfo_err, res, Code.getAllUserInfo_err_msg);
        }
    }
    /**
     * 删除用户信息
     */
    @DeleteMapping("/{id}")
    public Result deleteUserInfoById(@PathVariable String id) {
        Boolean res= userService.deleteUserInfoById(id);
        if (res) {
            return new Result(Code.deleteUserInfoById_ok, res, Code.deleteUserInfoById_ok_msg);
        } else {
            return new Result(Code.deleteUserInfoById_err, res, Code.deleteUserInfoById_err_msg);
        }
    }

}

