package com.recruitment.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.recruitment.domain.UserFavoritePost;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王磊
 * @since 2022-05-24
 */
public interface IUserFavoritePostService extends IService<UserFavoritePost> {
    /**
     * 判断 是否已经收藏
     */

    Boolean isUserFavoritePost(String userIduseless, String postIduseless);
/**
 * 添加收藏
 */
   Boolean createUserFavoritePost(String userIduseless, String postIduseless);
    /**
     * 很具 用户IDuseless 查询 收藏的职位 id
     */
    List selectUserFavoritePost(String userIduseless);
    /**
     * 根据 两个iduseless 逻辑删除
     */
    Boolean deleteUserFavoritePost(String userIduseless, String postIduseless);



}
