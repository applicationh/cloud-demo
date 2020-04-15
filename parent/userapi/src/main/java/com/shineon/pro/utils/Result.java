package com.shineon.pro.utils;

/**
 * @Author: wsh
 */

public class Result<T> {
    private  Boolean success;
    private  Integer code;
    private  String message;
    private  T  data;

    private  Result(T data) {
        this.success=true;
        this.code=0;
        this.message ="成功";
        this.data = data;
    }
    private Result(CodeMsg cm) {
        if(cm == null){
            return;
        }
        this.success = false;
        this.code = cm.getCode();
        this.message = cm.getMessage();
    }
    /**
     * 成功
     */
    public static <T> Result<T> success(T data){
        return new Result<>(data);
    }

    /**
     * 成功不需要参数
     */
    public static <T> Result<T> success(){
        return (Result<T>) success("");
    }

    /**
     * 失败时候的调用，自定义错误码
     */
    public static <T> Result<T> error(CodeMsg cm){
        return new Result<T>(cm);
    }
    /**
     * 失败时候的调用,默认错误码+消息
     */
    public static <T> Result<T> error(String msg){
        CodeMsg cm= new CodeMsg(msg);
        return new Result<T>(cm);
    }







    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
