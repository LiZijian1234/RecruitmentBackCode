package com.recruitment.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.recruitment.domain.Corporation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 使用者 Mapper 接口
 * </p>
 *
 * @author 王磊
 * @since 2022-05-14
 */
@Mapper
public interface CorporationDao extends BaseMapper<Corporation> {
    @Select("select * from tbl_corporation where corporation_name =#{name}")
    public Corporation selectByName(String name);

}
