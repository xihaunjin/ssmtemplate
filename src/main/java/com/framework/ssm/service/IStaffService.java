package com.framework.ssm.service;

import com.framework.ssm.dto.StaffDTO;
import com.framework.ssm.model.StaffDO;
import com.framework.ssm.vo.StaffVO;

import java.util.List;

/**
 * 请填写类注释
 *
 * @author tailless
 * @since 2018/07/23
 */
public interface IStaffService {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(StaffDO record);

    Integer insertSelective(StaffDO record);

    StaffDO selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(StaffDO record);

    Integer updateByPrimaryKey(StaffDO record);

    Integer insertOrUpdateStaffInfo(StaffDTO record);

    List<StaffVO> selectAllStaff();
}
