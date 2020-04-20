package com.shineon.userapi.utils;

import java.io.Serializable;

/**
 * @Author: wsh
 */

public class Result<T>  implements Serializable {
    private  Boolean success;
    private  Integer code;
    private  String message;
    private  T  data;

    private  Result(T data) {
        this.success=true;
        this.code=0;
        this.message = "成功";
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
     * �ɹ�
     */
    public static <T> Result<T> success(T data){
        return new Result<>(data);
    }

    /**
     * �ɹ�����Ҫ����
     */
    public static <T> Result<T> success(){
        return (Result<T>) success("");
    }

    /**
     * ʧ��ʱ��ĵ��ã��Զ��������
     */
    public static <T> Result<T> error(CodeMsg cm){
        return new Result<T>(cm);
    }
    /**
     * ʧ��ʱ��ĵ���,Ĭ�ϴ�����+��Ϣ
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
