package com.framework.ssm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework.ssm.model.UserDO;
import com.framework.ssm.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 请填写类注释
 *
 * @author tailless
 * @since 2018/07/12
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @ResponseBody
    @RequestMapping(value = "/list")
    public String userList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<UserDO> userList = this.userService.getUser();
        return mapper.writeValueAsString(userList);
    }


    @ResponseBody
    @RequestMapping(value = "/save")
    public void addUser(@RequestBody UserDO userDO, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer saveCount = this.userService.insertUser(userDO);
        response.getWriter().write(saveCount.toString());
    }

    @ResponseBody
    @RequestMapping(value = "/update")
    public void update(@RequestBody UserDO userDo,HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer updateCount = this.userService.updateUserById(userDo);
        response.getWriter().write(updateCount.toString());
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer deleteCount = this.userService.deleteUserById(id);
        response.getWriter().write(deleteCount.toString());
    }
}
