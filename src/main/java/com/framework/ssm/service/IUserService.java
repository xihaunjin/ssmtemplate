package com.framework.ssm.service;

import com.framework.ssm.model.UserDO;

import java.util.List;

/**
 * 请填写类注释
 *
 * @author tailless
 * @since 2018/07/12
 */
public interface IUserService {
    List<UserDO> getUser();

    Integer deleteUserById(Integer id);

    Integer insertUser(UserDO record);

    UserDO getUserById(Integer id);

    Integer updateUserById(UserDO record);
}
