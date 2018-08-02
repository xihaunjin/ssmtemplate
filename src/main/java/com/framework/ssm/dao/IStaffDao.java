package com.framework.ssm.dao;

import com.framework.ssm.model.StaffDO;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("staffDao")
public interface IStaffDao {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(StaffDO record);

    Integer insertSelective(StaffDO record);

    StaffDO selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(StaffDO record);

    Integer updateByPrimaryKey(StaffDO record);

    Integer insertOrUpdateStaffInfo(StaffDO record);

    List<StaffDO> selectAllStaff();
}