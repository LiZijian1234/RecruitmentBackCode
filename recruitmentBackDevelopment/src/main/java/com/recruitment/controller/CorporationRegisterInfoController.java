package com.recruitment.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.recruitment.domain.CorporationRegisterInfo;
import com.recruitment.domain.PostPublicated;
import com.recruitment.service.impl.CorporationRegisterInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 使用者 前端控制器
 * </p>
 *
 * @author 王磊
 * @since 2022-05-20
 */
@RestController
@RequestMapping("/corporationRegisterInfo")
public class CorporationRegisterInfoController {
    @Autowired
    private CorporationRegisterInfoServiceImpl corporationRegisterInfoService;

    /**
 * 根据hrId增加
 */
@PostMapping
public Result registerCorporationById(@RequestBody CorporationRegisterInfo corporationRegisterInfo) {
    Boolean res = corporationRegisterInfoService.registerCorporationById(corporationRegisterInfo);
    if (res) {
        return new Result(Code.registerCorporationById_ok, res, Code.registerCorporationById_ok_msg);
    } else {
        return new Result(Code.registerCorporationById_err, res, Code.registerCorporationById_err_msg);
    }

}

    /**
     * 逻辑删除_根据id删除
     */
@DeleteMapping("/{id}")
    public Result corporationRegisterDeleteLogicByID(@PathVariable String id) {
    Boolean res = corporationRegisterInfoService.deleteLogicByID(id);
    if (res) {
        return new Result(Code. corporationRegisterDeleteLogicByID_ok, res, Code.corporationRegisterDeleteLogicByID_ok_msg);
    } else {
        return new Result(Code. corporationRegisterDeleteLogicByID_err, res, Code. corporationRegisterDeleteLogicByID_err_msg);
    }

}

    /**
     * 根据Id（批量）查询公司注册信息
     */
@GetMapping("/{id}")
    public Result getCorporationRegisterInfoById(@PathVariable String id) {
    Object res= corporationRegisterInfoService.getCorporationRegisterInfoById(id);
    if (res!=null) {
        return new Result(Code.getCorporationRegisterInfoById_ok, res, Code.getCorporationRegisterInfoById_ok_msg);
    } else {
        return new Result(Code.getCorporationRegisterInfoById_err, res, Code.getCorporationRegisterInfoById_err_msg);
    }

    }
    /**
     * 查询所有公司注册信息
     */
@GetMapping
    public Result getAllCorporationRegisterInfo() {
    Object res= corporationRegisterInfoService.getAllCorporationRegisterInfo();
    if (res!=null) {
        return new Result(Code. getAllCorporationRegisterInfo_ok, res, Code. getAllCorporationRegisterInfo_ok_msg);
    } else {
        return new Result(Code. getAllCorporationRegisterInfo_err, res, Code. getAllCorporationRegisterInfo_err_msg);
    }
    }


}

