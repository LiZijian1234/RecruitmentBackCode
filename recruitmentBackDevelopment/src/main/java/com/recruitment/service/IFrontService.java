package com.recruitment.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.recruitment.domain.Front;

import java.util.List;

/**
 * <p>
 * 使用者 服务类
 * </p>
 *
 * @author 王磊
 * @since 2022-06-24
 */
public interface IFrontService extends IService<Front> {
/**
 * 更新内容
 */
Boolean updateContent(Front front);
    /**
     * 查询所有
     */
    List getAll();
}
