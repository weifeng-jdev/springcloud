package com.amano.common.dto;

import lombok.Data;

@Data
public class BaseResult<T> {
    private Integer code;
    private String msg;
    private T data;

    public static BaseResult success () {
        return new BaseResult(200, "success");
    }

    public static <T> BaseResult<T> success(T data) {
        return new BaseResult<>(200, "success", data);
    }

    public static BaseResult error(Integer code, String msg) {
        return new BaseResult(code, msg);
    }

    public BaseResult(int code, String msg) {
        this.code = code;
        this.msg = "msg";
    }

    public BaseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
