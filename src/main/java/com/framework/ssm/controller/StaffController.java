package com.framework.ssm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.framework.ssm.model.StaffDO;
import com.framework.ssm.service.IStaffService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 请填写类注释
 *
 * @author tailless
 * @since 2018/07/23
 */

@Controller
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private IStaffService staffService;

    /*
    * 分页查询员工列表
    * */
    @ResponseBody
    @RequestMapping("/list")
    public PageInfo<StaffDO> getStaffList(@RequestParam Integer offset, @RequestParam Integer limit) {
        PageHelper.startPage(offset, limit);
        List<StaffDO> staffList = staffService.selectAllStaff();
        PageInfo<StaffDO> pageInfo = new PageInfo<StaffDO>(staffList);
        return pageInfo;
    }

    /*
    * 获取单个员工信息
    * */
    @ResponseBody
    @RequestMapping("/info/{id}")
    public StaffDO getStaffInfo(@PathVariable Integer id) {
        StaffDO staffDO = staffService.selectByPrimaryKey(id);
        return staffDO;
    }

    /*
    * 删除单个员工信息
    * */
    @ResponseBody
    @RequestMapping("/delete/{id}")
    public Integer deleteStaff(@PathVariable Integer id) {
        Integer deleteCount = staffService.deleteByPrimaryKey(id);
        return deleteCount;
    }

    /*
     * 数据存在则更新不存在则插入
     * */
    @ResponseBody
    @RequestMapping("/save")
    public Integer addStaff(@RequestBody StaffDO staffDO) {
        return staffService.insertOrUpdateStaffInfo(staffDO);
    }
}
