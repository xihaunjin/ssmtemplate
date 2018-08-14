package com.framework.ssm.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 请填写类注释
 *
 * @author tailless
 * @since 2018/08/07
 */
public class Result {

    /*
     * @desc 消息描述
     * */
    private String msg;

    /*
     * @desc 状态码
     * */
    private String code;
    /*
     * @desc 状态 0成功 1失败
     * */
    private int status = 0;

    private Map<String, Object> data = new HashMap<String, Object>();

    public Result() {
    }

    public static Result getServiceError(){
        return getServiceError("发生未知错误",(String)null);
    }

    public static Result getServiceError(String message,String code){
        Result result = new Result();
        result.setMsg(message);
        result.setCode(code);
        result.setStatus(-2);
        return result;
    }

    public static Result getSuccessResult() {
        Result result = new Result();
        result.setMsg("success");
        result.setCode("200");
        result.setStatus(0);
        return result;
    }

    public static Result getSuccessResult(String message,String code) {
        Result result = new Result();
        result.setMsg(message);
        result.setCode(code);
        result.setStatus(0);
        return result;
    }

    public static Result getBusinessException(String message,String code) {
        Result result = new Result();
        result.setMsg(message);
        result.setCode(code);
        result.setStatus(1);
        return result;
    }

    public Result Add(String key,Object object){
        this.data.put(key,object);
        return this;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
