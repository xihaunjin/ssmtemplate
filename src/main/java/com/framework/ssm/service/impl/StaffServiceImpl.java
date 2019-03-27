package com.framework.ssm.service.impl;

import com.framework.ssm.common.BeanMapper;
import com.framework.ssm.dao.IStaffDao;
import com.framework.ssm.dto.StaffDTO;
import com.framework.ssm.model.StaffDO;
import com.framework.ssm.service.IStaffService;
import com.framework.ssm.vo.StaffVO;
import org.springframework.beans.BeanUtils;
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
    public Integer insertOrUpdateStaffInfo(StaffDTO record) {
        StaffDO staffDO = BeanMapper.map(record,StaffDO.class);
        return staffDao.insertOrUpdateStaffInfo(staffDO);
    }

    @Override
    public List<StaffVO> selectAllStaff() {
        List<StaffDO> staffDOList = staffDao.selectAllStaff();
        List<StaffVO> staffVOList = BeanMapper.mapList(staffDOList,StaffDO.class,StaffVO.class);
        return staffVOList;
    }
}
