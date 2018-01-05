package com.tronsis.service;

public class HelloService {
    private String msg;
    //此方法在javamailsenderboot 模块项目中调用
    public String sayHello(){
        return "hello " + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}