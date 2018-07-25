package com.framework.ssm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework.ssm.model.StaffDO;
import com.framework.ssm.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ResponseBody
    @RequestMapping("/list")
    public List<StaffDO> getStaffList(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<StaffDO> staffList = staffService.selectAllStaff();
        return staffList;
    }

    @ResponseBody
    @RequestMapping("/info/{id}")
    public StaffDO getStaffInfo(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        StaffDO staffDO = staffService.selectByPrimaryKey(id);
        return staffDO;
    }

    @ResponseBody
    @RequestMapping("/delete/{id}")
    public Integer deleteStaff(@PathVariable Integer id){
        Integer deleteCount = staffService.deleteByPrimaryKey(id);
        return deleteCount;
    }

    @ResponseBody
    @RequestMapping("/update")
    public Integer updateStaff(@RequestBody StaffDO staffDO){
        Integer updateCount = staffService.updateByPrimaryKeySelective(staffDO);
        return updateCount;
    }

    @ResponseBody
    @RequestMapping("/save")
    public Integer addStaff(@RequestBody StaffDO staffDO){
        Integer addCount = staffService.insert(staffDO);
        return addCount;
    }
}
