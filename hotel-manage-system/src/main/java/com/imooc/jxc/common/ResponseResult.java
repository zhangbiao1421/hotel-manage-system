package com.imooc.jxc.common;

import java.io.Serializable;

/**
 * createtime: 2019/11/28  21:26
 * author: zhangbiao
 */
public class ResponseResult implements Serializable {

    private String code = "00000";

    private String message = "成功";

    private Object data;

    public ResponseResult (){

    }
    public ResponseResult(String code, String message){
       this.code = code;
       this.message = message;
    }

    public ResponseResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
