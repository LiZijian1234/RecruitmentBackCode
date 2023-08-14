package com.recruitment.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.recruitment.dao.HrResumeUserDao;
import com.recruitment.domain.HrResumeUser;
import com.recruitment.service.IHrResumeUserService;
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
 * @since 2022-05-25
 */
@Service
public class HrResumeUserServiceImpl  implements IHrResumeUserService {
    @Autowired
    private HrResumeUserDao hrResumeUserDao;
    /**
     * 判断 是否已经投递
     */
    @Override
    public Boolean isSubmitResume(String hrId, String postIduseless, String resumeId) {
        LambdaQueryWrapper<HrResumeUser> lqw = new LambdaQueryWrapper<>();
        lqw.select(HrResumeUser::getIdUseless).eq(HrResumeUser::getResumeId,resumeId).eq(HrResumeUser::getHrId,hrId).eq(HrResumeUser::getPostIduseless,postIduseless);
//        System.out.println(hrResumeUserDao.selectObjs(lqw));
        return hrResumeUserDao.selectCount(lqw) >0;
    }
    /**
     * 投递简历
     */
    @Override
    public Boolean submitResume(String hrId, String postIduseless, String resumeId) {
        HrResumeUser hrResumeUser = new HrResumeUser();
        hrResumeUser.setResumeId(resumeId);
        hrResumeUser.setHrId(hrId);
        hrResumeUser.setPostIduseless(Long.valueOf(postIduseless));
        try {
            return hrResumeUserDao.insert(hrResumeUser)>0;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * 根据hr id 批量查询已收简历
     */
    @Override
    public List getResumeByHrId(String HrId) {
        LambdaQueryWrapper<HrResumeUser> lqw = new LambdaQueryWrapper<>();
        lqw.select(HrResumeUser::getResumeId).eq(HrResumeUser::getHrId,HrId);
        return  hrResumeUserDao.selectObjs(lqw);

    }
    /**
     * 根据hr id 统计已收简历
     */
    @Override
    public Integer countResumeByHrId(String HrId) {
        LambdaQueryWrapper<HrResumeUser> lqw = new LambdaQueryWrapper<>();
        lqw.select(HrResumeUser::getResumeId).eq(HrResumeUser::getHrId,HrId);
        return  hrResumeUserDao.selectCount(lqw);
    }
    /**
     * 根据hr id 批量查询未审核的简历
     */
    @Override
    public List getUnhandleResumeByHrId(String HrId) {
        LambdaQueryWrapper<HrResumeUser> lqw = new LambdaQueryWrapper<>();
        lqw.select(HrResumeUser::getResumeId).eq(HrResumeUser::getHrId,HrId).eq(HrResumeUser::getResumeStatus,1);
        return  hrResumeUserDao.selectObjs(lqw);
    }
    /**
     * 根据hr id 统计未审核的简历
     */
    @Override
    public Integer countUnhandleResumeByHrId(String HrId) {
        LambdaQueryWrapper<HrResumeUser> lqw = new LambdaQueryWrapper<>();
        lqw.select(HrResumeUser::getResumeId).eq(HrResumeUser::getHrId,HrId).eq(HrResumeUser::getResumeStatus,1);
        return  hrResumeUserDao.selectCount(lqw);
    }
    /**
     *  逻辑删除
     */
    @Override
    public Boolean deleteSubmitResume(String postIduseless, String resumeId) {
        LambdaQueryWrapper<HrResumeUser> lqw = new LambdaQueryWrapper<>();

        lqw.eq(HrResumeUser::getResumeId,resumeId).eq(HrResumeUser::getPostIduseless,postIduseless);
        return hrResumeUserDao.delete(lqw)>0;

    }
    /**
     * 根据resumeid查询投的岗位iduseless
     */
    @Override
    public List  getPostByResumeId(String resumeId) {
        LambdaQueryWrapper<HrResumeUser> lqw = new LambdaQueryWrapper<>();
        lqw.select(HrResumeUser::getPostIduseless).eq(HrResumeUser::getResumeId,resumeId);
        return  hrResumeUserDao.selectObjs(lqw);

    }
    /**
     * 根据岗位查询投的简历id
     */
    @Override
    public List getResumeByPostIduseless(String PostIduseless) {
        LambdaQueryWrapper<HrResumeUser> lqw = new LambdaQueryWrapper<>();
        lqw.select(HrResumeUser::getResumeId).eq(HrResumeUser::getPostIduseless,PostIduseless);
        return  hrResumeUserDao.selectObjs(lqw);
    }
    /**
     * 用户查询自己的简历状态码
     */
    @Override
    public List getResumeStatusByPostIduseless(String PostIduseless, String resumeId) {
        LambdaQueryWrapper<HrResumeUser> lqw = new LambdaQueryWrapper<>();
        lqw.select(HrResumeUser::getResumeStatus).eq(HrResumeUser::getPostIduseless,PostIduseless).eq(HrResumeUser::getResumeId,resumeId);
        return  hrResumeUserDao.selectObjs(lqw);
    }
    /**
     * hr 对简历处理 审核通过
     */
    @Override
    public Boolean passResumeStatusByPostIduseless(String resumeId, String postIduseless) {
        LambdaUpdateWrapper<HrResumeUser> lqw = new LambdaUpdateWrapper<>();
        lqw.set(HrResumeUser::getResumeStatus,"21").eq(HrResumeUser::getResumeId,resumeId).eq(HrResumeUser::getPostIduseless,postIduseless);
        return hrResumeUserDao.update(null,lqw)>0;
    }
    /**
     * hr 对简历处理 审核不通过
     */
    @Override
    public Boolean rejectResumeStatusByPostIduseless(String resumeId, String postIduseless) {
        LambdaUpdateWrapper<HrResumeUser> lqw = new LambdaUpdateWrapper<>();
        lqw.set(HrResumeUser::getResumeStatus,"20").eq(HrResumeUser::getResumeId,resumeId).eq(HrResumeUser::getPostIduseless,postIduseless);
        return hrResumeUserDao.update(null,lqw)>0;
    }
    /**
     * 根据 单个用户ID 查询简历状态
     */
    @Override
    public List<Object> selectResumeStatusByid(String resumeId){
        LambdaQueryWrapper<HrResumeUser> lqw = new LambdaQueryWrapper<>();
        lqw.select(HrResumeUser::getResumeStatus).eq(HrResumeUser::getResumeId,resumeId);
        return hrResumeUserDao.selectObjs(lqw);
    }


    /**
     * 暂时用不到
     */
    @Override
    public boolean saveBatch(Collection<HrResumeUser> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<HrResumeUser> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<HrResumeUser> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(HrResumeUser entity) {
        return false;
    }

    @Override
    public HrResumeUser getOne(Wrapper<HrResumeUser> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<HrResumeUser> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<HrResumeUser> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<HrResumeUser> getBaseMapper() {
        return null;
    }

    @Override
    public Class<HrResumeUser> getEntityClass() {
        return null;
    }
}
