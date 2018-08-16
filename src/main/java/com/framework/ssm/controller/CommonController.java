package com.framework.ssm.controller;

import com.framework.ssm.common.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 请填写类注释
 *
 * @author tailless
 * @since 2018/08/07
 */
@RequestMapping("/api")
@Controller
@ResponseBody
public class CommonController {
    @RequestMapping("/upload")
    public Result uploadFile(HttpServletRequest request) throws IOException {
        MultipartFile multipartFile = null;
//        if (request instanceof MultipartHttpServletRequest) {
            multipartFile = ((MultipartHttpServletRequest)request).getFile("file");
//        }
        System.out.println(multipartFile);

        /**
         * 项目服务器地址路径
         */
        String projectServerPath = request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + request.getContextPath() + "/upload/";
        System.out.println("################" + projectServerPath);
        /**
         * 上传文件绝对路径
         */
        String path = request.getSession().getServletContext().getRealPath("/upload/");
        System.out.println("%%%%%%%%%%%%%%%%%" + path);
        /**
         * 上传文件名
         */
        String fileName = (multipartFile.getOriginalFilename());
        System.out.println("&&&&&&&&&&&&&&&&&&&" + fileName);

        File upfile = new File(path + fileName);
        System.out.println("-----------------" + upfile);
        /**
         * 判断路径是否存在，如果不存在就创建一个
         */
        if (!upfile.getParentFile().exists()) {

            upfile.getParentFile().mkdirs();
        }
        /**
         * 创建文件
         */
        multipartFile.transferTo(new File(path + File.separator + fileName));
        /**
         * 返回服务器文件地址
         */
        String serverFilePatn = projectServerPath + fileName;
        System.out.println("********************" + serverFilePatn);
        return Result.getSuccessResult().Add("url", serverFilePatn);
    }
}


//package com.framework.ssm.controller;
//
//import com.sun.jersey.api.client.Client;
//import com.sun.jersey.api.client.WebResource;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.util.Random;
//
///**
// * 请填写类注释
// *
// * @author tailless
// * @since 2018/08/07
// */
//@RequestMapping("/api")
//@Controller
//public class CommonController {
//    @RequestMapping("/upload")
//    public String uploadFile(HttpServletRequest request,String fileName) {
//        //把request强转为多部件请求对象
//        MultipartHttpServletRequest req=(MultipartHttpServletRequest) request;
//        //根据文件名称获得文件对象
//        CommonsMultipartFile img = (CommonsMultipartFile
// ) req.getFile(fileName);
//        //获取文件上传流
//        byte[] fbytes = img.getBytes();
//        //文件名在服务器可能有重复
//        String newfileName = System.currentTimeMillis() + "";
//        Random r = new Random();
//        for (int i = 0; i < 5; i++) {
//            newfileName += r.nextInt(100);
//        }
//        //获取文件的扩展名
//        String originalFilename = img.getOriginalFilename();
//        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
//        //创建jesy服务器 进行跨服务器上传
//        Client client = Client.create();
//        //把文件关联到远程服务器
//        WebResource resource = client.resource("http://35.236.138.158/upload/" + newfileName + suffix);
//        //上传
//        resource.put(fbytes);
//        /* * ajax回调函数所需的参数 * fullPath：图片回显所需的完整路径 */
//        String fullPath = "http://35.236.138.158/upload/" + newfileName + suffix;
//        String result = "{\"fullPath\":\"" + fullPath + "\"}";
//        return result;
//    }
//}

