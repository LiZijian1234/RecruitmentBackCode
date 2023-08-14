package com.recruitment.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.recruitment.dao.FrontDao;
import com.recruitment.domain.Front;
import com.recruitment.service.IFrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 使用者 服务实现类
 * </p>
 *
 * @author 王磊
 * @since 2022-06-24
 */
@Service
public class FrontServiceImpl extends ServiceImpl<FrontDao, Front> implements IFrontService {
  @Autowired
  private FrontDao frontDao;
    /**
     * 更新内容
     */
    @Override
    public Boolean updateContent(Front front) {
        front.setIdUseless(1L);
        return frontDao.updateById(front)>0;
    }

    /**
     * 查询所有
     */
    @Override
    public List getAll() {
        return frontDao.selectList(null);
    }

}
