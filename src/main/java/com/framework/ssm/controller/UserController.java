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

    @RequestMapping(value = "/list")
    public void userList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<UserDO> userList = this.userService.getUser();
        response.getWriter().write(mapper.writeValueAsString(userList));
        response.getWriter().close();
    }

    @ResponseBody
    @RequestMapping(value = "/save")
    public void addUser(@RequestBody UserDO userDO, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Integer userId = Integer.valueOf(id);
//        Integer useAge = Integer.valueOf(age);
//        UserDO userDO = new UserDO();
//        userDO.setId(userId);
//        userDO.setAge(useAge);
//        userDO.setName(name);
        Integer saveCount = this.userService.insertUser(userDO);
        response.getWriter().write(saveCount.toString());
    }

    @RequestMapping(value = "/update")
    public void update(@RequestBody UserDO userDo,HttpServletRequest request, HttpServletResponse response){
        Integer updateCount = this.userService.updateUserById(userDo);
    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Integer userId = new Integer(id);
        Integer deleteCount = this.userService.deleteUserById(id);
        response.getWriter().write(deleteCount.toString());
    }
}
