package com.zimo.mybaties.util;

import java.io.Serializable;
import java.util.Date;

public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /*错误码*/
    private Integer code;
    /*提示信息*/
    private String message;

    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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