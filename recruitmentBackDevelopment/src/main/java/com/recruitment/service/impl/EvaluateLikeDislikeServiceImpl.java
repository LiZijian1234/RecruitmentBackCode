package com.recruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.recruitment.constCode.EvaluateLikeDislikeConstCode;
import com.recruitment.dao.EvaluateLikeDislikeDao;
import com.recruitment.domain.EvaluateLikeDislike;
import com.recruitment.domain.HrResumeUser;
import com.recruitment.service.IEvaluateLikeDislikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

/**
 * <p>
 * 使用者 服务实现类
 * </p>
 *
 * @author 王磊
 * @since 2022-06-08
 */
@Service
public class EvaluateLikeDislikeServiceImpl   implements IEvaluateLikeDislikeService {
    @Autowired
    private EvaluateLikeDislikeDao evaluateLikeDislikeDao;

    /**
     * 判端数据是否存在
     */
    @Override
    public boolean isExist(String evaluateOwner, String oprationer,String evaluateCorporation) {
        LambdaQueryWrapper<EvaluateLikeDislike> lqw = new LambdaQueryWrapper<>();
        lqw.eq(EvaluateLikeDislike::getEvaluateOwner,evaluateOwner).eq(EvaluateLikeDislike::getOprationer,oprationer).eq(EvaluateLikeDislike::getEvaluateCorporation,evaluateCorporation);
        return evaluateLikeDislikeDao.selectCount(lqw) >0;
    }

    /**
     * 新增 数据
     */
    @Override
    public boolean createData(String evaluateOwner, String oprationer,String evaluateCorporation) {
        EvaluateLikeDislike evaluateLikeDislike = new EvaluateLikeDislike();
        evaluateLikeDislike.setEvaluateOwner(evaluateOwner);
        evaluateLikeDislike.setOprationer(oprationer);
        evaluateLikeDislike.setEvaluateCorporation(evaluateCorporation);
//        evaluateLikeDislikeDao.insert(evaluateLikeDislike);
        return evaluateLikeDislikeDao.insert(evaluateLikeDislike)>0;
    }

    /**
     * 判断是否已经点赞
     */

    @Override
    public boolean isLike(String evaluateOwner, String oprationer,String evaluateCorporation) {
        LambdaQueryWrapper<EvaluateLikeDislike> lqw = new LambdaQueryWrapper<>();
        lqw.eq(EvaluateLikeDislike::getLile, EvaluateLikeDislikeConstCode.DOLIKE).eq(EvaluateLikeDislike::getEvaluateOwner,evaluateOwner).eq(EvaluateLikeDislike::getOprationer,oprationer).eq(EvaluateLikeDislike::getEvaluateCorporation,evaluateCorporation);
        return evaluateLikeDislikeDao.selectCount(lqw)>0;
    }
    /**
     * 判断是否已经踩
     */
    @Override
    public boolean isDislike(String evaluateOwner, String oprationer,String evaluateCorporation) {
        LambdaQueryWrapper<EvaluateLikeDislike> lqw = new LambdaQueryWrapper<>();
        lqw.eq(EvaluateLikeDislike::getDislike, EvaluateLikeDislikeConstCode.DODISLIKE).eq(EvaluateLikeDislike::getEvaluateOwner,evaluateOwner).eq(EvaluateLikeDislike::getOprationer,oprationer).eq(EvaluateLikeDislike::getEvaluateCorporation,evaluateCorporation);
        return evaluateLikeDislikeDao.selectCount(lqw)>0;
    }

    /**
     * 踩
     */
    @Override
    public boolean dislike(String evaluateOwner, String oprationer,String evaluateCorporation) {
        LambdaUpdateWrapper<EvaluateLikeDislike> lqw = new LambdaUpdateWrapper<>();
        lqw.set(EvaluateLikeDislike::getDislike, EvaluateLikeDislikeConstCode.DODISLIKE).eq(EvaluateLikeDislike::getEvaluateOwner,evaluateOwner).eq(EvaluateLikeDislike::getOprationer,oprationer).eq(EvaluateLikeDislike::getEvaluateCorporation,evaluateCorporation);
        return evaluateLikeDislikeDao.update(null,lqw)>0;
    }
    /**
     * 点赞
     */
    @Override
    public boolean like(String evaluateOwner, String oprationer,String evaluateCorporation) {
        LambdaUpdateWrapper<EvaluateLikeDislike> lqw = new LambdaUpdateWrapper<>();
        lqw.set(EvaluateLikeDislike::getLile, EvaluateLikeDislikeConstCode.DOLIKE).eq(EvaluateLikeDislike::getEvaluateOwner,evaluateOwner).eq(EvaluateLikeDislike::getOprationer,oprationer).eq(EvaluateLikeDislike::getEvaluateCorporation,evaluateCorporation);
        return evaluateLikeDislikeDao.update(null,lqw)>0;
    }
    /**
     * 取消踩
     */
    @Override
    public boolean cancelDislike(String evaluateOwner, String oprationer,String evaluateCorporation) {
        LambdaUpdateWrapper<EvaluateLikeDislike> lqw = new LambdaUpdateWrapper<>();
        lqw.set(EvaluateLikeDislike::getDislike, EvaluateLikeDislikeConstCode.CANCELDISLIKE).eq(EvaluateLikeDislike::getEvaluateOwner,evaluateOwner).eq(EvaluateLikeDislike::getOprationer,oprationer).eq(EvaluateLikeDislike::getEvaluateCorporation,evaluateCorporation);
        return evaluateLikeDislikeDao.update(null,lqw)>0;
    }
    /**
     * 取消点赞
     */
    @Override
    public boolean cancelLike(String evaluateOwner, String oprationer,String evaluateCorporation) {
        LambdaUpdateWrapper<EvaluateLikeDislike> lqw = new LambdaUpdateWrapper<>();
        lqw.set(EvaluateLikeDislike::getLile, EvaluateLikeDislikeConstCode.CANCELLIKE).eq(EvaluateLikeDislike::getEvaluateOwner,evaluateOwner).eq(EvaluateLikeDislike::getOprationer,oprationer).eq(EvaluateLikeDislike::getEvaluateCorporation,evaluateCorporation);
        return evaluateLikeDislikeDao.update(null,lqw)>0;
    }
    /**
     * 统计某个评价点赞数
     */
    @Override
    public Integer countLikePeople(String evaluateOwner,String evaluateCorporation) {
        LambdaQueryWrapper<EvaluateLikeDislike> lqw = new LambdaQueryWrapper<>();
        lqw.eq(EvaluateLikeDislike::getLile, EvaluateLikeDislikeConstCode.DOLIKE).eq(EvaluateLikeDislike::getEvaluateOwner,evaluateOwner).eq(EvaluateLikeDislike::getEvaluateCorporation,evaluateCorporation);

        return evaluateLikeDislikeDao.selectCount(lqw);
    }
    /**
     * 统计某个评价踩数
     */
    @Override
    public Integer countDislikePeople(String evaluateOwner,String evaluateCorporation) {
        LambdaQueryWrapper<EvaluateLikeDislike> lqw = new LambdaQueryWrapper<>();
        lqw.eq(EvaluateLikeDislike::getDislike, EvaluateLikeDislikeConstCode.DODISLIKE).eq(EvaluateLikeDislike::getEvaluateOwner,evaluateOwner).eq(EvaluateLikeDislike::getEvaluateCorporation,evaluateCorporation);

        return evaluateLikeDislikeDao.selectCount(lqw);
    }

    /**
     * 暂时用不到
     */
    @Override
    public boolean saveBatch(Collection<EvaluateLikeDislike> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<EvaluateLikeDislike> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<EvaluateLikeDislike> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(EvaluateLikeDislike entity) {
        return false;
    }

    @Override
    public EvaluateLikeDislike getOne(Wrapper<EvaluateLikeDislike> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<EvaluateLikeDislike> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<EvaluateLikeDislike> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<EvaluateLikeDislike> getBaseMapper() {
        return null;
    }

    @Override
    public Class<EvaluateLikeDislike> getEntityClass() {
        return null;
    }
}
