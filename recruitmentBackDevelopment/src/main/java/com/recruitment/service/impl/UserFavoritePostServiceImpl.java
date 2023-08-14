package com.recruitment.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.recruitment.dao.UserFavoritePostDao;
import com.recruitment.domain.PostPublicated;
import com.recruitment.domain.UserFavoritePost;
import com.recruitment.service.IUserFavoritePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王磊
 * @since 2022-05-24
 */
@Service
public class UserFavoritePostServiceImpl extends ServiceImpl<UserFavoritePostDao, UserFavoritePost> implements IUserFavoritePostService {
    @Autowired
    private  UserFavoritePostDao userFavoritePostDao;
    /**
     * 判断 是否已经收藏
     */
    @Override
    public Boolean isUserFavoritePost(String userIduseless, String postIduseless) {
        LambdaQueryWrapper<UserFavoritePost> lqw = new LambdaQueryWrapper<>();
        lqw.select(UserFavoritePost::getId).eq(UserFavoritePost::getPostIduseless,postIduseless).eq(UserFavoritePost::getUserIduseless,userIduseless);
        return userFavoritePostDao.selectCount(lqw) >0;
    }
    /**
     * 添加收藏
     */
    @Override
    public Boolean createUserFavoritePost(String userIduseless, String postIduseless) {
        UserFavoritePost userFavoritePost = new UserFavoritePost();
        userFavoritePost.setUserIduseless(Long.valueOf(userIduseless));
        userFavoritePost.setPostIduseless(Long.valueOf(postIduseless));
        return userFavoritePostDao.insert(userFavoritePost)>0;
    }
    /**
     * 很具 用户IDuseless 查询 收藏的职位 id
     */
    @Override
    public List selectUserFavoritePost(String userIduseless) {
        LambdaQueryWrapper<UserFavoritePost> lqw = new LambdaQueryWrapper<>();
      lqw.select(UserFavoritePost::getPostIduseless).eq(UserFavoritePost::getUserIduseless,userIduseless);
        List list = userFavoritePostDao.selectObjs(lqw);
        return list;
    }
    /**
     * 根据 两个iduseless 逻辑删除
     */
    @Override
    public Boolean deleteUserFavoritePost(String userIduseless, String postIduseless) {
        LambdaQueryWrapper<UserFavoritePost> lqw = new LambdaQueryWrapper<>();

        lqw.eq(UserFavoritePost::getUserIduseless,userIduseless).eq(UserFavoritePost::getPostIduseless,postIduseless);

        return userFavoritePostDao.delete(lqw)>0;
    }

}
