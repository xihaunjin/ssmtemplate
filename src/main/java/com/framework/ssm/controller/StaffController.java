package com.framework.ssm.controller;

import com.framework.ssm.common.Result;
import com.framework.ssm.dto.StaffDTO;
import com.framework.ssm.model.StaffDO;
import com.framework.ssm.service.IStaffService;
import com.framework.ssm.vo.StaffVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * 请填写类注释
 *
 * @author tailless
 * @since 2018/07/23
 */

@Controller
@RequestMapping("/api/staff")
public class StaffController {

    private static final Logger logger = LoggerFactory.getLogger(StaffController.class);

    @Autowired
    private IStaffService staffService;

    @ResponseBody
    @RequestMapping("/list")
    public Result getStaffList(@RequestParam Integer offset, @RequestParam Integer limit) {
        PageHelper.startPage(offset, limit);
        List<StaffVO> staffList = staffService.selectAllStaff();
        PageInfo<StaffDO> pageInfo = new PageInfo(staffList);
        return Result.getSuccessResult().Add("total", pageInfo.getTotal()).Add("list",pageInfo.getList());
    }

    @ResponseBody
    @RequestMapping("/info/{id}")
    public Result getStaffInfo(@PathVariable Integer id) {
        StaffDO staffDO = staffService.selectByPrimaryKey(id);
        return Result.getSuccessResult().Add("staffInfo",staffDO);
    }

    @ResponseBody
    @RequestMapping("/delete/{id}")
    public Result deleteStaff(@PathVariable Integer id) {
        Integer deleteCount = staffService.deleteByPrimaryKey(id);
        return Result.getSuccessResult("删除成功",200);
    }

    @ResponseBody
    @RequestMapping("/save")
    public Result addStaff(@RequestBody StaffDTO staffDTO) {
        try {
            Integer insertOrUpdateCount = staffService.insertOrUpdateStaffInfo(staffDTO);
            if (insertOrUpdateCount == null) {
                return Result.getBusinessException("添加信息失败", -200);
            }
            if (insertOrUpdateCount != null) {
                return Result.getSuccessResult("添加信息成功", 200);
            }
        } catch (Exception e) {
            logger.info("添加信息异常", e);
            return Result.getBusinessException("添加信息失败", -200);
        }
        return null;
    }
}
