package com.zimo.mybaties.util;

public class ResultUtil {
    public static final Integer SUCCESS_CODE = 200;

    public static Result success(){
        return success("操作成功");
    }

    public static Result success(String msg){
        return success(null,msg);
    }

    public static Result success(Object data,String msg){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setMessage(msg);
        result.setData(data);
        return result;
    }
}
