package com.recruitment.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.recruitment.domain.PostPublicated;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 * 使用者 Mapper 接口
 * </p>
 *
 * @author 王磊
 * @since 2022-05-14
 */
@Mapper
public interface PostPublicatedDao extends BaseMapper<PostPublicated> {


    /**
     * 根据城市位置查询岗位 月薪 降序 创建时间 升序排序
     */
    @Select("select * from tbl_post_publicated where post_location_city =#{city} order by month_salary desc, addtime ")
    public List<PostPublicated> selectByCityOrderedByMonthSalaryDescendByAddtimeAscend(String city);
    /**
     * 根据城市位置查询岗位 按照  增加时间  降序 ；月薪 降序 排序
     */
    @Select("select * from tbl_post_publicated where post_location_city =#{city} order by addtime desc,month_salary desc")
    public List<PostPublicated> selectByCityOrderedByAddtimeDescendByMonthSalaryDescend(String city);
//    /**
//     * 根据id_useless修改 岗位
//     */
//    @Update("update ")


}
