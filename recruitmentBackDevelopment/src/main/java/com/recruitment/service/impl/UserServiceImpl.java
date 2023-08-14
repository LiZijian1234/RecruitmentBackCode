package com.recruitment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.recruitment.dao.UserDao;
import com.recruitment.domain.User;
import com.recruitment.domain.UserFavoritePost;
import com.recruitment.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 使用者 服务实现类
 * </p>
 *
 * @author 王磊
 * @since 2022-05-08
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userdao;

    /**
     * 创建新用户
     */
    @Override
    public Boolean createNewUser(User user) {
        try {
            userdao.insert(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 通过ID修改用户信息
     */
    @Override
    public Boolean modifyUserInfoById(User user) {
//        user.setId(id);
        return userdao.updateById(user)>0;
    }

    /**
     * 按照ID查询
     */
    @Override
    public User getUserInfoById(String id) {
        return userdao.selectById(id);
    }

    /**
     * 查看所有用户信息（管理元权限）
     */
    @Override
    public List<User> getAllUserInfo() {
        return userdao.selectList(null);
    }

    /**
     * 删除用户信息
     */
    @Override
    public Boolean deleteUserInfoById(String id) {
        return userdao.deleteById(id)>0;
    }


}
