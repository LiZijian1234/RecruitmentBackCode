package com.recruitment.service.impl;


import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.recruitment.controller.PageResult;
import com.recruitment.dao.PostPublicatedDao;
import com.recruitment.domain.PostPublicated;
import com.recruitment.domain.User;
import com.recruitment.service.IPostPublicatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.ldap.PagedResultsControl;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * <p>
 * 使用者 服务实现类
 * </p>
 *
 * @author 王磊
 * @since 2022-05-14
 */
@Service
@TableName(autoResultMap = true)//json必须加
public class PostPublicatedServiceImpl implements IPostPublicatedService {

@Autowired
private PostPublicatedDao postPublicatedDao;
    /**
     * 根据id 增加 职位信息
     */
    @Override
    public Boolean creatPostById(PostPublicated post) {

        return postPublicatedDao.insert(post)>0;
    }
    /**
     * 根据id_useless 修改 职位信息
     */
    @Override
    public Boolean modifyPostByIdUseless(PostPublicated post) {

        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id_useless", post.getIdUseless());
        return postPublicatedDao.update(post,queryWrapper)>0;
    }
    /**
     * 根据ID 批量查询 职位信息
     */
    @Override
    public PageResult getPostById(PageResult pageResult) {
        Page page = new Page(pageResult.getPageCurrent(), pageResult.getSize());
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", pageResult.getQurreyValue());
        Page page1 = postPublicatedDao.selectPage(page, queryWrapper);
//        获取总记录数
        long total =  page1.getTotal();
//        获取所有记录
        List records = page1.getRecords();
        pageResult.setTotal(total);
        pageResult.setRows(records);
        return pageResult;
    }
    /**
     * 查询所有 长期    职位信息
     */
    @Override
    public PageResult getAllPostInfo(PageResult pageResult) {
        LambdaQueryWrapper< PostPublicated> lqw1 = new LambdaQueryWrapper<>();
        lqw1.eq(PostPublicated::getHiringTime,"长期");

        Page page = new Page(pageResult.getPageCurrent(), pageResult.getSize());
//        QueryWrapper queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("id", pageResult.getQurreyValue());
        Page page1 = postPublicatedDao.selectPage(page, lqw1);
//        获取总记录数
        long total =  page1.getTotal();
//        获取所有记录
        List records = page1.getRecords();
        pageResult.setTotal(total);
        pageResult.setRows(records);
        return pageResult;
    }
    /**
     * 逻辑删除
     */
    @Override
    public Boolean deleteLogicByID(String id) {
        return postPublicatedDao.deleteById(id)>0;
    }
    /**
     *根据城市位置查询岗位 月薪 降序 创建时间 升序排序
     */
    @Override
    public List<PostPublicated> selectByCityOrderedByMonthSalaryDescendByAddtimeAscend(String city) {
        return postPublicatedDao.selectByCityOrderedByMonthSalaryDescendByAddtimeAscend(city);
//        return null;
    }
    /**
     * 根据城市位置查询岗位 按照  增加时间  降序 ；月薪 降序 排序
     */
    @Override
    public List<PostPublicated> selectByCityOrderedByAddtimeDescendByMonthSalaryDescend(String city) {
        return postPublicatedDao.selectByCityOrderedByAddtimeDescendByMonthSalaryDescend(city);
//        return null;
    }
    /**
     * 根据岗位名字进行模糊搜索
     */
    @Override
    public List<PostPublicated> fuzzySelectByPostName(String name) {
        //条件封装
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.like("post_name", name);

        List list = postPublicatedDao.selectList(queryWrapper);

        return list;
    }
    /**
     * 根据id_useless 查询岗位
     */
    @Override
    public List<PostPublicated> selectByIdUseless(String idUseless) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.like("id_useless", idUseless);

        List list = postPublicatedDao.selectList(queryWrapper);
        return list;
    }
    /**
     * 根据iduseless  单个删除
     */
    @Override
    public Boolean deleteLogicByIDUseless(String idUseless) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id_useless", idUseless);


        return postPublicatedDao.delete(queryWrapper)>0;
    }
    /**
     * 根据 期望月薪资山下浮动 numer(以代码中数值为准)  查询岗位 或者 查询所有岗位
     */
    @Override
    public List<PostPublicated> selectByExpectedSalary(String expectedSalary) {
        if(expectedSalary !=null){

            LambdaQueryWrapper<PostPublicated> lqw = new LambdaQueryWrapper<>();
            lqw.between(PostPublicated::getMonthSalary,Math.max(Integer.parseInt(expectedSalary)-1000,0),Integer.parseInt(expectedSalary)+1000);
                List list =postPublicatedDao.selectList(lqw);
                return list;}
        else {
            return postPublicatedDao.selectList(null);
        }
    }
    /**
     * 按照  增加时间  降序 ；月薪 降序 排序
     */
    @Override
    public PageResult selectByAddtimeDescendByMonthSalaryDescend(PageResult pageResult) {
        Page page = new Page(pageResult.getPageCurrent(), pageResult.getSize());
        LambdaQueryWrapper<PostPublicated> lqw = new LambdaQueryWrapper<>();
        lqw.orderByDesc(PostPublicated::getAddtime,PostPublicated::getMonthSalary);
//        QueryWrapper queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("id", pageResult.getQurreyValue());
        Page page1 = postPublicatedDao.selectPage(page, lqw);
//        获取总记录数
        long total =  page1.getTotal();
//        获取所有记录
        List records = page1.getRecords();
        pageResult.setTotal(total);
        pageResult.setRows(records);
        return pageResult;

    }

    /**
     * 根据城市和月薪 联合筛选
     */
    @Override
    public List<PostPublicated> selectByCityAndMonthSalary(String city, String monthSalary) {
        LambdaQueryWrapper<PostPublicated> lqw = new LambdaQueryWrapper<>();
//            把字符串除了 首字母 其他全换为占位符_
//             byte[] a =monthSalary.getBytes(StandardCharsets.UTF_8);
//             for (int i = 1; i < a.length; i++) {a[i] = '_';}
//              String s = new String(a);
            lqw.eq(city !=null,PostPublicated::getPostLocationCity,city).between(monthSalary != null,PostPublicated::getMonthSalary,Math.max(Integer.parseInt(monthSalary)-1000,0),Integer.parseInt(monthSalary)+1000);
            List list = postPublicatedDao.selectList(lqw);
            return list;


    }

    /**
     * 查询所有岗位的地理编码
     */
    @Override
    public List selectAllAddressDecode() {
        LambdaQueryWrapper<PostPublicated> lqw = new LambdaQueryWrapper<>();
        lqw.select(PostPublicated::getLocationDecode);
        return postPublicatedDao.selectObjs(lqw);
    }

    /**
     * 根据地理编码批量查询岗位
     */
    @Override
    public List selectBatchPostByAddressDecode(String AddressDecode) {

        LambdaQueryWrapper<PostPublicated> lqw = new LambdaQueryWrapper<>();
        lqw.select(PostPublicated::getPostName).eq(PostPublicated::getLocationDecode,AddressDecode);
        return postPublicatedDao.selectObjs(lqw);
    }

    /**
     * 查询日结 岗位
     */
    public List selectBatchPostByDailySettlement() {
        LambdaQueryWrapper<PostPublicated> lqw = new LambdaQueryWrapper<>();
        lqw.eq(PostPublicated::getHiringTime,"日结");
        return postPublicatedDao.selectList(lqw);
    }

    /**
     *下面暂时用不到
     */
    @Override
    public boolean saveBatch(Collection<PostPublicated> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<PostPublicated> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<PostPublicated> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(PostPublicated entity) {
        return false;
    }

    @Override
    public PostPublicated getOne(Wrapper<PostPublicated> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<PostPublicated> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<PostPublicated> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<PostPublicated> getBaseMapper() {
        return null;
    }

    @Override
    public Class<PostPublicated> getEntityClass() {
        return null;
    }
}
