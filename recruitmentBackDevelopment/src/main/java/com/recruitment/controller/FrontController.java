package com.recruitment.controller;


import com.recruitment.domain.Front;
import com.recruitment.service.impl.FrontServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 使用者 前端控制器
 * </p>
 *
 * @author 王磊
 * @since 2022-06-24
 */
@RestController
@RequestMapping("/front")
public class FrontController {
    @Autowired
    private FrontServiceImpl frontService;
    /**
     * 更新内容
     */
    @PutMapping("/updateContent")
    public Result updateContent(@RequestBody Front front) {
        Object res= frontService.updateContent(front);
        if (res!=null) {
            return new Result(Code.updateContent_ok, res, Code.updateContent_ok_msg);
        } else {
            return new Result(Code.updateContent_err, res, Code.updateContent_err_msg);
        }
    }
    /**
     * 查询所有
     */
    @GetMapping
    public Result getAll() {
        Object res= frontService.getAll();
        if (res!=null) {
            return new Result(Code.getAll_ok, res, Code.getAll_ok_msg);
        } else {
            return new Result(Code.getAll_err, res, Code.getAll_err_msg);
        }
    }

}

