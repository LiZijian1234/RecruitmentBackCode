package com.recruitment.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.recruitment.domain.CorporationRegisterInfo;
import com.recruitment.domain.PostPublicated;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 使用者 Mapper 接口
 * </p>
 *
 * @author 王磊
 * @since 2022-05-20
 */
@Mapper
public interface CorporationRegisterInfoDao extends BaseMapper<CorporationRegisterInfo> {

}
