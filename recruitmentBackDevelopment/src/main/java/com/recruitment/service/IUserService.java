package com.recruitment.service;

import com.recruitment.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 使用者 服务类
 * </p>
 *
 * @author 王磊
 * @since 2022-05-08
 */
@Transactional
//@Service
public interface IUserService  {

Boolean createNewUser(User user);
Boolean modifyUserInfoById( User user);
User getUserInfoById(String id);
List<User> getAllUserInfo();

    /**
     * 删除用户信息
     */
    Boolean deleteUserInfoById(String id);


}

