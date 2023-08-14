package com.recruitment.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.recruitment.dao.CorporationDao;
import com.recruitment.domain.Corporation;
import com.recruitment.service.impl.CorporationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 使用者 前端控制器
 * </p>
 *
 * @author 王磊
 * @since 2022-05-14
 */
@RestController
@RequestMapping("/corporation")
public class CorporationController {
    @Autowired
    private CorporationServiceImpl corporationService;
    /**
     * 根据id 增加 公司信息
     */

    @PostMapping
    public Result creatCorporationById(@RequestBody Corporation corporation) {
        boolean res1 = corporationService.isHavingCorporationById(corporation.getId());
        if (res1){
            return new Result(Code.HavingCorporation_ok, res1, Code.HavingCorporation_ok_msg);
        }
        else{
            Boolean res= corporationService.creatCorporationById(corporation);
            if (res ) {
                return new Result(Code.creatCorporationById_ok, res, Code.creatCorporationById_ok_msg);
            } else {
                return new Result(Code.creatCorporationById_err, res, Code.creatCorporationById_err_msg);
            }
             }
    }
    /**
     * 根据ID 修改 公司信息
     */
    @PutMapping
    public Result modifyCorporationById(@RequestBody Corporation corporation) {
        Boolean res= corporationService.modifyCorporationById(corporation);
        if (res ) {
            return new Result(Code.modifyCorporationById_ok, res, Code.modifyCorporationById_ok_msg);
        } else {
            return new Result(Code.modifyCorporationById_err, res, Code.modifyCorporationById_err_msg);
        }
    }
    /**
     * 根据ID 查询 公司信息
     */
    @GetMapping("/id/{id}")
    public Result getCorporationById(@PathVariable String id) {
        Object res= corporationService.getCorporationById(id);
        if (res!=null) {
            return new Result(Code.getCorporationById_ok, res, Code.getCorporationById_ok_msg);
        } else {
            return new Result(Code.getCorporationById_err, res, Code.getCorporationById_err_msg);
        }
    }
    /**
     * 根据名字 查询 公司信息
     */
    @GetMapping("/name/{name}")
    public Result getCorporationByName(@PathVariable String name) {
        Object res= corporationService.getCorporationByName(name);
        if (res!=null) {
            return new Result(Code.getCorporationByName_ok, res, Code.getCorporationByName_ok_msg);
        } else {
            return new Result(Code.getCorporationByName_err, res, Code.getCorporationByName_err_msg);
        }
    }
    /**
     * 查询所有 公司信息
     */
    @GetMapping()
    public Result getAllCorporationInfo() {
        Object res= corporationService.getAllCorporationInfo();
        if (res!=null) {
            return new Result(Code.getAllCorporationInfo_ok, res, Code.getAllCorporationInfo_ok_msg);
        } else {
            return new Result(Code.getAllCorporationInfo_err, res, Code.getAllCorporationInfo_err_msg);
        }
    }
    /**
     * 根据输入模糊搜索 公司名称 返回公司名字
     */
    @GetMapping("/getCorporationByFuzzyInput/{name}")
    public Result getCorporationByFuzzyInput(@PathVariable String name) {
        Object res= corporationService.getCorporationByFuzzyInput(name);
        if (res!=null) {
            return new Result(Code.getCorporationByFuzzyInput_ok, res, Code.getCorporationByFuzzyInput_ok_msg);
        } else {
            return new Result(Code.getCorporationByFuzzyInput_err, res, Code.getCorporationByFuzzyInput_err_msg);
        }
    }
    /**
     * 查询所有公司的地理位置编码
     */
    @GetMapping("/getAllCorporationAddressDecode")
    public Result getAllCorporationAddressDecode() {
        Object res= corporationService.getAllCorporationAddressDecode();
        if (res!=null) {
            return new Result(Code.getAllCorporationAddressDecode_ok, res, Code.getAllCorporationAddressDecode_ok_msg);
        } else {
            return new Result(Code.getAllCorporationAddressDecode_err, res, Code.getAllCorporationAddressDecode_err_msg);
        }
    }

    /**
     * 根据地理位置编码查询公司
     */
    @GetMapping("/getCorporationByAddressDecode/{addressDecode}")
    public Result getCorporationByAddressDecode(@PathVariable String addressDecode) {
        Object res= corporationService.getCorporationByAddressDecode(addressDecode);
        if (res!=null) {
            return new Result(Code.getCorporationByAddressDecode_ok, res, Code.getCorporationByAddressDecode_ok_msg);
        } else {
            return new Result(Code.getCorporationByAddressDecode_err, res, Code.getCorporationByAddressDecode_err_msg);
        }
    }

    /**
     * 按照行业返回公司信息
     */
    @GetMapping("/getCorporationByCorporationIndustry/{corporationIndustry}")
    public Result getCorporationByCorporationIndustry(@PathVariable String corporationIndustry) {
        Object res= corporationService.getCorporationByCorporationIndustry(corporationIndustry);
        if (res!=null) {
            return new Result(Code.getCorporationByCorporationIndustry_ok, res, Code.getCorporationByCorporationIndustry_ok_msg);
        } else {
            return new Result(Code.getCorporationByCorporationIndustry_err, res, Code.getCorporationByCorporationIndustry_err_msg);
        }
    }
    /**
     * 根据ID 删除 公司信息
     */
    @DeleteMapping("/{id}")
    public Result deleteCorporationById(@PathVariable String id) {
        boolean res= corporationService.deleteCorporationById(id);
        if (res ) {
            return new Result(Code.deleteCorporationById_ok, res, Code.deleteCorporationById_ok_msg);
        } else {
            return new Result(Code.deleteCorporationById_err, res, Code.deleteCorporationById_err_msg);
        }
    }

}

