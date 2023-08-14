package com.recruitment.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.recruitment.dao.CorporationRegisterInfoDao;
import com.recruitment.domain.CorporationRegisterInfo;

import com.recruitment.service.ICorporationRegisterInfoService;

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
 * @since 2022-05-20
 */
@Service
public class CorporationRegisterInfoServiceImpl implements ICorporationRegisterInfoService {
 @Autowired
 private CorporationRegisterInfoDao corporationRegisterInfoDao;
    /**
     * 根据hrId增加
     */
    @Override
    public Boolean registerCorporationById(CorporationRegisterInfo corporationRegisterInfo) {
        try {
            corporationRegisterInfoDao.insert(corporationRegisterInfo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * 逻辑删除_根据id删除
     */
    @Override
    public Boolean deleteLogicByID(String id) {
        return corporationRegisterInfoDao.deleteById(id)>0;
    }
    /**
     * 根据Id（批量）查询公司注册信息
     */
    @Override
    public List<CorporationRegisterInfo> getCorporationRegisterInfoById(String id) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        queryWrapper.eq("status", 1);
        List list = corporationRegisterInfoDao.selectList(queryWrapper);
        return list;

    }
    /**
     * 查询所有公司注册信息
     */
    @Override
    public List<CorporationRegisterInfo> getAllCorporationRegisterInfo() {
        return corporationRegisterInfoDao.selectList(null);
    }

    /**
     * 以下暂时用不到
     */
    @Override
    public boolean saveBatch(Collection<CorporationRegisterInfo> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<CorporationRegisterInfo> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<CorporationRegisterInfo> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(CorporationRegisterInfo entity) {
        return false;
    }

    @Override
    public CorporationRegisterInfo getOne(Wrapper<CorporationRegisterInfo> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<CorporationRegisterInfo> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<CorporationRegisterInfo> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<CorporationRegisterInfo> getBaseMapper() {
        return null;
    }

    @Override
    public Class<CorporationRegisterInfo> getEntityClass() {
        return null;
    }

}



