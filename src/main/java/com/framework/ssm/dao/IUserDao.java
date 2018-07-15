package com.framework.ssm.dao;

import com.framework.ssm.model.UserDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 请填写类注释
 *
 * @author tailless
 * @since 2018/07/12
 */
@Repository("userDao")
public interface IUserDao {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(UserDO record);

    Integer insertSelective(UserDO record);

    UserDO selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(UserDO record);

    Integer updateByPrimaryKey(UserDO record);

    //自己添加的，已匹配Mapper中的Sql
    List<UserDO> selectAllUser();
}
