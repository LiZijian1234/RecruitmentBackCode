package com.recruitment.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.recruitment.dao.PostPublicatedDao;
import com.recruitment.domain.PostPublicated;
import com.recruitment.service.impl.PostPublicatedServiceImpl;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
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
@RequestMapping("/postPublicated")
public class PostPublicatedController {
    @Autowired
    private PostPublicatedServiceImpl postPublicatedService;
    /**
     * 根据id 增加 职位信息
     */
    @PostMapping
    public Result creatPostById(@RequestBody PostPublicated post) {
        Boolean res = postPublicatedService.creatPostById(post);
        if (res) {
            return new Result(Code.creatPostById_ok, res, Code.creatPostById_ok_msg);
        } else {
            return new Result(Code.creatPostById_err, res, Code.creatPostById_err_msg);
        }

    }
    /**
     * 根据id_useless 修改 职位信息
     */
@PutMapping
    public Result modifyPostById(@RequestBody PostPublicated post) {
    Boolean res = postPublicatedService.modifyPostByIdUseless(post);
    if (res) {
        return new Result(Code.modifyPostById_ok, res, Code.modifyPostById_ok_msg);
    } else {
        return new Result(Code.modifyPostById_err, res, Code.modifyPostById_err_msg);
    }

    }
    /**
     * 根据ID批量查询 职位信息
     */
@GetMapping("/getPostsByid")
    public Result getPostById( String id,Integer pageCurrent,Integer pageSize) {
    PageResult pageResult = new PageResult();
    pageResult.setQurreyValue(id);
    pageResult.setSize(pageSize);
    pageResult.setPageCurrent(pageCurrent);
    Object res= postPublicatedService.getPostById(pageResult);
    if (res!=null) {
        return new Result(Code.getPostById_ok, res, Code.getPostById_ok_msg);
    } else {
        return new Result(Code.getPostById_err, res, Code.getPostById_err_msg);
    }
    }
    /**
     * 查询所有    职位信息
     */
@GetMapping("/getAllPostInfo")
    public Result getAllPostInfo(Integer pageCurrent,Integer pageSize) {
    PageResult pageResult = new PageResult();
//    pageResult.setQurreyValue(id);
    pageResult.setSize(pageSize);
    pageResult.setPageCurrent(pageCurrent);

    Object res=postPublicatedService.getAllPostInfo(pageResult);
    if (res!=null) {
        return new Result(Code.getAllPostInfo_ok, res, Code.getAllPostInfo_ok_msg);
    } else {
        return new Result(Code.getAllPostInfo_err, res, Code.getAllPostInfo_err_msg);
    }
    }
    /**
     * 逻辑删除
     */
@DeleteMapping("/deleteById/{id}")
    public Result deleteLogicByID(@PathVariable String id) {
    Boolean res= postPublicatedService.deleteLogicByID(id);
        if (res ) {
        return new Result(Code.deleteLogicByID_ok, res, Code.deleteLogicByID_ok_msg);
    } else {
        return new Result(Code.deleteLogicByID_err, res, Code.deleteLogicByID_err_msg);
    }


    }
    /**
     *根据城市位置查询岗位 月薪 降序 创建时间 升序排序
     */
@GetMapping("/{city}")
    public Result selectByCityOrderedByMonthSalaryDescendByAddtimeAscend(@PathVariable String city) {
    Object res= postPublicatedService.selectByCityOrderedByMonthSalaryDescendByAddtimeAscend(city);
    if (res!=null) {
        return new Result(Code.selectByCityOrderedByMonthSalaryDescendByAddtimeAscend_ok, res, Code.selectByCityOrderedByMonthSalaryDescendByAddtimeAscend_ok_msg);
    } else {
        return new Result(Code.selectByCityOrderedByMonthSalaryDescendByAddtimeAscend_err, res, Code.selectByCityOrderedByMonthSalaryDescendByAddtimeAscend_err_msg);
    }

//        return null;
    }
    /**
     * 根据城市位置查询岗位 按照  增加时间  降序 ；月薪 降序 排序
     */
@GetMapping("/latest/{city}")
    public Result selectByCityOrderedByAddtimeDescendByMonthSalaryDescend(@PathVariable String city) {
    Object res= postPublicatedService.selectByCityOrderedByAddtimeDescendByMonthSalaryDescend(city);
    if (res!=null) {
        return new Result(Code.selectByCityOrderedByAddtimeDescendByMonthSalaryDescend_ok, res, Code.selectByCityOrderedByAddtimeDescendByMonthSalaryDescend_ok_msg);
    } else {
        return new Result(Code.selectByCityOrderedByAddtimeDescendByMonthSalaryDescend_err, res, Code.selectByCityOrderedByAddtimeDescendByMonthSalaryDescend_err_msg);
    }

//        return null;
    }
    /**
     * 根据岗位名字进行模糊搜索
     */
    @GetMapping("/name/{name}")
    public Result fuzzySelectByPostName(@PathVariable String name) {

//        //将字符串转化为UTF8编码 无需设置 浏览器自动采用UTF8编码
//        byte[] bytes = name1.getBytes();
//        String name= new String(bytes, StandardCharsets.UTF_8);

        Object res= postPublicatedService.fuzzySelectByPostName(name);
        if (res!=null) {
            return new Result(Code.fuzzySelectByPostName_ok, res, Code.fuzzySelectByPostName_ok_msg);
        } else {
            return new Result(Code.fuzzySelectByPostName_err, res, Code.fuzzySelectByPostName_err_msg);
        }

    }
    /**
     * 根据id_useless 查询岗位
     */
    @GetMapping("/iduseless/{idUseless}")
    public Result selectByIdUseless(@PathVariable String idUseless) {



        Object res= postPublicatedService.selectByIdUseless(idUseless);
        if (res!=null) {
            return new Result(Code.selectByIdUseless_ok, res, Code.selectByIdUseless_ok_msg);
        } else {
            return new Result(Code.selectByIdUseless_err, res, Code.selectByIdUseless_err_msg);
        }

    }
    /**
     * 根据iduseless  单个删除
     */
    @DeleteMapping("/deleteByIduseless/{idUseless}")
    public Result deleteLogicByIDUseless(@PathVariable String idUseless) {
        Boolean res= postPublicatedService.deleteLogicByIDUseless(idUseless);
        if (res ) {
            return new Result(Code.deleteLogicByIDUseless_ok, res, Code.deleteLogicByIDUseless_ok_msg);
        } else {
            return new Result(Code.deleteLogicByIDUseless_err, res, Code.deleteLogicByIDUseless_err_msg);
        }
    }
    /**
     * 按照  增加时间  降序 ；月薪 降序 排序
     */
    @GetMapping("/addtimeMonthSalary")
    public Result selectByAddtimeDescendByMonthSalaryDescend(Integer pageCurrent,Integer pageSize) {
        PageResult pageResult = new PageResult();
//    pageResult.setQurreyValue(id);
        pageResult.setSize(pageSize);
        pageResult.setPageCurrent(pageCurrent);

        Object res= postPublicatedService.selectByAddtimeDescendByMonthSalaryDescend(pageResult);
        if (res!=null) {
            return new Result(Code. selectByAddtimeDescendByMonthSalaryDescend_ok, res, Code. selectByAddtimeDescendByMonthSalaryDescend_ok_msg);
        } else {
            return new Result(Code. selectByAddtimeDescendByMonthSalaryDescend_err, res, Code. selectByAddtimeDescendByMonthSalaryDescend_err_msg);
        }
    }

    /**
     * 根据城市和月薪 联合筛选
     */
    @GetMapping("/cityMonthSalary")
    public Result selectByCityAndMonthSalary(String city, String monthSalary) {
        Object res= postPublicatedService.selectByCityAndMonthSalary(city,monthSalary);
        if (res!=null) {
            return new Result(Code. selectByCityAndMonthSalary_ok, res, Code. selectByCityAndMonthSalary_ok_msg);
        } else {
            return new Result(Code.selectByCityAndMonthSalary_err, res, Code. selectByCityAndMonthSalary_err_msg);
        }


    }

    /**
     * 根据 期望月薪资山下浮动 numer(以代码中数值为准)  查询岗位 或者 查询所有岗位
     */
    @GetMapping("/expectedSalary/{expectedSalary}")
    public Result selectByExpectedSalary(@PathVariable  String expectedSalary) {
        Object res= postPublicatedService.selectByExpectedSalary(expectedSalary);
        if (res!=null) {
            return new Result(Code. selectByExpectedSalary_ok, res, Code. selectByExpectedSalary_ok_msg);
        } else {
            return new Result(Code. selectByExpectedSalary_err, res, Code. selectByExpectedSalary_err_msg);
        }
    }
    /**
     * 查询所有岗位的地理编码
     */
    @GetMapping("/selectAllAddressDecode")
    public Result selectAllAddressDecode() {
        Object res= postPublicatedService.selectAllAddressDecode();
        if (res!=null) {
            return new Result(Code. selectAllAddressDecode_ok, res, Code.selectAllAddressDecode_ok_msg);
        } else {
            return new Result(Code. selectAllAddressDecode_err, res, Code.selectAllAddressDecode_err_msg);
        }
    }

    /**
     * 根据地理编码批量查询岗位
     */
    @GetMapping("/selectBatchPostByAddressDecode/{addressDecode}")
    public Result selectBatchPostByAddressDecode(@PathVariable String addressDecode) {

        Object res= postPublicatedService.selectBatchPostByAddressDecode(addressDecode);
        if (res!=null) {
            return new Result(Code. selectBatchPostByAddressDecode_ok, res, Code.selectBatchPostByAddressDecode_ok_msg);
        } else {
            return new Result(Code. selectBatchPostByAddressDecode_err, res, Code.selectBatchPostByAddressDecode_err_msg);
        }
    }
    /**
     * 查询日结 岗位
     */
    @GetMapping("/selectBatchPostByDailySettlement")
    public Result selectBatchPostByDailySettlement() {
        Object res= postPublicatedService.selectBatchPostByDailySettlement();
        if (res!=null) {
            return new Result(Code. selectBatchPostByDailySettlement_ok, res, Code.selectBatchPostByDailySettlement_ok_msg);
        } else {
            return new Result(Code. selectBatchPostByDailySettlement_err, res, Code.selectBatchPostByDailySettlement_err_msg);
        }
    }
}

