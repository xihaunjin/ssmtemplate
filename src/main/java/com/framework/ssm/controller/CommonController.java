package com.framework.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * 请填写类注释
 *
 * @author tailless
 * @since 2018/08/07
 */
@RequestMapping("/api")
@CrossOrigin
@Controller
public class CommonController {
    @RequestMapping("/upload")
    public String uploadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MultipartFile multipartFile = null;
        if (request instanceof MultipartHttpServletRequest) {
            multipartFile = ((MultipartHttpServletRequest)request).getFile("uploadFile");
        }
        if (null != multipartFile) {
            /**
             * 项目服务器地址路径
             */
            String projectServerPath = request.getScheme() + "://"+request.getServerName()+":" +
                    request.getServerPort() + request.getContextPath() + "/upload/";
            /**
             * 上传文件绝对路径
             */
            String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload/");
            /**
             * 上传文件名
             */
            String fileName = (multipartFile.getOriginalFilename());

            File file = new File(path + fileName);
            /**
             * 判断路径是否存在，如果不存在就创建一个
             */
            if (!file.getParentFile().exists()) {

                file.getParentFile().mkdirs();
            }
            /**
             * 创建文件
             */
            multipartFile.transferTo(new File(path + File.separator + fileName));
            /**
             * 返回服务器文件地址
             */
            String serverFilePatn = projectServerPath + fileName;
            return serverFilePatn;
        }
        return null;
    }
}
