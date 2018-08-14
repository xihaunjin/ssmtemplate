package com.framework.ssm.service.impl;

import com.framework.ssm.dao.IStaffDao;
import com.framework.ssm.model.StaffDO;
import com.framework.ssm.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 请填写类注释
 *
 * @author tailless
 * @since 2018/07/23
 */

@Service("staffService")
public class StaffServiceImpl implements IStaffService {
    @Autowired
    private IStaffDao staffDao;
    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return staffDao.deleteByPrimaryKey(id);
    }

    @Override
    public Integer insert(StaffDO record) {
        return staffDao.insert(record);
    }

    @Override
    public Integer insertSelective(StaffDO record) {
        return staffDao.insertSelective(record);
    }

    @Override
    public StaffDO selectByPrimaryKey(Integer id) {
        return staffDao.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateByPrimaryKeySelective(StaffDO record) {
        return staffDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public Integer updateByPrimaryKey(StaffDO record) {
        return staffDao.updateByPrimaryKey(record);
    }

    @Override
    public Integer insertOrUpdateStaffInfo(StaffDO record) {
        return staffDao.insertOrUpdateStaffInfo(record);
    }

    @Override
    public List<StaffDO> selectAllStaff() {
        return staffDao.selectAllStaff();
    }
}
