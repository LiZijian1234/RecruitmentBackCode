package com.recruitment.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.recruitment.dao.CorporationDao;
import com.recruitment.domain.Corporation;
import com.recruitment.service.ICorporationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
public class CorporationServiceImpl  implements ICorporationService {
    @Autowired
    private CorporationDao corporationDao;
    /**
     * 根据id 增加 公司信息
     */

    @Override
    public Boolean creatCorporationById(Corporation corporation) {
        return corporationDao.insert(corporation)>0;
    }
    /**
     * 根据ID 修改 公司信息
     */
    @Override
    public Boolean modifyCorporationById(Corporation corporation) {
        return corporationDao.updateById(corporation)>0;
    }
    /**
     * 根据ID 查询 公司信息
     */
    @Override
    public List<Corporation> getCorporationById(String id) {
        LambdaQueryWrapper<Corporation> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Corporation::getId,id);
        List list =corporationDao.selectList(lqw);
        return list;
    }
    /**
     * 根据名字 查询 公司信息
     */
    @Override
    public Corporation getCorporationByName(String name) {
        return corporationDao.selectByName(name);
    }
    /**
     * 查询所有 公司信息
     */
    @Override
    public List<Corporation> getAllCorporationInfo() {
        return corporationDao.selectList(null);
    }
    /**
     * 判断hr 是否存在公司
     */
    @Override
    public boolean isHavingCorporationById(String id) {
        LambdaQueryWrapper<Corporation> lqw = new LambdaQueryWrapper<>();
        lqw.select(Corporation::getId).eq(Corporation::getId,id);
        return corporationDao.selectCount(lqw)>0;
    }
    /**
     * 根据输入模糊搜索 公司名称 返回公司名字
     */
    @Override
    public List getCorporationByFuzzyInput(String name) {
        LambdaQueryWrapper<Corporation> lqw = new LambdaQueryWrapper<>();
        lqw.select(Corporation::getCorporationName).like(Corporation::getCorporationName,name);
        return corporationDao.selectObjs(lqw);
    }

    /**
     * 查询所有公司的地理位置编码
     */
    @Override
    public List getAllCorporationAddressDecode() {
        LambdaQueryWrapper<Corporation> lqw = new LambdaQueryWrapper<>();
        lqw.select(Corporation::getCorporationLocationDecode);
        return corporationDao.selectObjs(lqw);
    }

    /**
     * 根据地理位置编码查询公司
     */
    @Override
    public List getCorporationByAddressDecode(String addressDecode) {
        LambdaQueryWrapper<Corporation> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Corporation::getCorporationLocationDecode,addressDecode);
        return corporationDao.selectList(lqw);
    }

    /**
     * 按照行业返回公司信息
     */
    @Override
    public List getCorporationByCorporationIndustry(String corporationIndustry) {
        LambdaQueryWrapper<Corporation> lqw = new LambdaQueryWrapper<>();
        lqw.like(Corporation::getCorporationIndustry,corporationIndustry);
        return corporationDao.selectList(lqw);
    }

    /**
     * 根据ID 删除 公司信息
     */
    public Boolean deleteCorporationById(String id) {
        return corporationDao.deleteById(id)>0;
    }

    /**
     * 下面暂时用不到
     */
    @Override
    public boolean saveBatch(Collection<Corporation> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Corporation> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Corporation> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Corporation entity) {
        return false;
    }

    @Override
    public Corporation getOne(Wrapper<Corporation> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Corporation> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<Corporation> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<Corporation> getBaseMapper() {
        return null;
    }

    @Override
    public Class<Corporation> getEntityClass() {
        return null;
    }
}
