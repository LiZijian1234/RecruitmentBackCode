package com.recruitment.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.recruitment.domain.UserFavoritePost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 使用者 Mapper 接口
 * </p>
 *
 * @author 王磊
 * @since 2022-05-08
 */
@Mapper
public interface UserFavoritePostDao extends BaseMapper<UserFavoritePost> {
//    /**
//     * 判断 是否已经收藏
//     */
//    @Select("select * from tbl_user_favorite_post where user_iduseless =#{userIduseless} and post_iduseless = #{postIduseless}")
//    Object isUserFavoritePost(String userIduseless, String postIduseless);

}
