package com.wsh.userapi.utils;

import java.io.Serializable;

/**
 * @Author: wsh
 */
public class CodeMsg  implements Serializable {
    private Integer code;
    private String message;


    public CodeMsg(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public CodeMsg( String message) {
        this.code = -1;
        this.message = message;
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
}
