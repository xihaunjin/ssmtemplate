package com.framework.ssm.service.impl;

import com.framework.ssm.dao.IUserDao;
import com.framework.ssm.model.UserDO;
import com.framework.ssm.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 请填写类注释
 *
 * @author tailless
 * @since 2018/07/12
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public List<UserDO> getUser() {
        return userDao.selectAllUser();
    }
}
