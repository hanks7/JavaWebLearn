package com.yidao.jdbc.uitls;


public class MessageDataBean {

    private int code;
    //msg  
    private String message;

    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return message;
    }

    public void setMsg(String msg) {
        this.message = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setContent(int code, String msg, Object data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }
}
