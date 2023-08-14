package com.recruitment.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.recruitment.controller.PageResult;
import com.recruitment.domain.PostPublicated;

import java.util.List;

/**
 * <p>
 * 使用者 服务类
 * </p>
 *
 * @author 王磊
 * @since 2022-05-14
 */
public interface IPostPublicatedService extends IService<PostPublicated> {
    /**
     * 根据id 增加 职位信息
     */
    Boolean creatPostById(PostPublicated post);
    /**
     * 根据id_useless 修改 职位信息
     */
    Boolean modifyPostByIdUseless(PostPublicated post);
    /**
     * 根据ID 批量 查询 职位信息
     */
    public PageResult getPostById(PageResult pageResult);
    /**
     * 查询所有    职位信息
     */
    public PageResult getAllPostInfo(PageResult pageResult);
    /**
     * 逻辑删除
     */
    Boolean deleteLogicByID(String id);
    /**
     *根据城市位置查询岗位 月薪 降序 创建时间 升序排序
     */
    List<PostPublicated> selectByCityOrderedByMonthSalaryDescendByAddtimeAscend(String city);
    /**
            * 根据城市位置查询岗位 按照  增加时间  降序 ；月薪 降序 排序
     */
    List<PostPublicated> selectByCityOrderedByAddtimeDescendByMonthSalaryDescend(String city);
    /**
     * 根据岗位名字进行模糊搜索
     */
    List<PostPublicated> fuzzySelectByPostName(String name);
    /**
     * 根据id_useless 查询岗位
     */
    List<PostPublicated> selectByIdUseless(String idUseless);
    /**
     * 根据iduseless  单个删除
     */
    Boolean deleteLogicByIDUseless(String idUseless);
    /**
     * 根据 期望月薪资山下浮动 numer(以代码中数值为准)  查询岗位 或者 查询所有岗位
     */
    List<PostPublicated> selectByExpectedSalary(String expectedSalary);
/**
 * 按照  增加时间  降序 ；月薪 降序 排序
 */
public PageResult selectByAddtimeDescendByMonthSalaryDescend(PageResult pageResult);
    /**
     * 根据城市和月薪 联合筛选
     */
    List<PostPublicated> selectByCityAndMonthSalary(String city,String monthSalary);
    /**
     * 查询所有岗位的地理编码
     */
    List selectAllAddressDecode();
    /**
     * 根据地理编码批量查询岗位
     */
    List selectBatchPostByAddressDecode(String AddressDecode);
    /**
     * 查询日结 岗位
     */
    List selectBatchPostByDailySettlement();
}
