package com.example.ticketdemo.pojo.model;

import lombok.Data;

@Data
public class Result<T> {

    private String msg;
    private T data;

    public Result() {}

    public Result(T data) {
        this.data = data;
    }

    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setMsg("success");
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>(data);
        result.setMsg("success");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.setMsg(msg);
        return result;
    }
}