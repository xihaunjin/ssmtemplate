package com.framework.ssm.service.impl;

import com.framework.ssm.dao.IUserDao;
import com.framework.ssm.model.UserDO;
import com.framework.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 请填写类注释
 *
 * @author tailless
 * @since 2018/07/12
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public List<UserDO> getUser() {
        return userDao.selectAllUser();
    }

    @Override
    public Integer deleteUserById(Integer id) {
        return userDao.deleteByPrimaryKey(id);
    }

    @Override
    public Integer insertUser(UserDO record) {
        return userDao.insert(record);
    }

    @Override
    public UserDO getUserById(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateUserById(UserDO record) {
        return userDao.updateByPrimaryKey(record);
    }


}
