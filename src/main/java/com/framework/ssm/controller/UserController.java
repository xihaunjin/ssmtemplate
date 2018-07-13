package com.framework.ssm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework.ssm.model.UserDO;
import com.framework.ssm.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
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

    @Resource
    private UserServiceImpl userService;

    @RequestMapping(value = "/list")
    public void userList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<UserDO> userList = this.userService.getUser();
        response.getWriter().write(mapper.writeValueAsString(userList));
        response.getWriter().close();
//        return userService.getUser();
    }
}
