package com.lcy.epay.model.response;

import static com.lcy.epay.constant.Constants.SUCCESS_CODE;

/**
 * 基础响应
 * @Author lcy
 * @Date 2023/10/21 17:57
 */
public class BaseResponse {

    /** 响应码1为成功，其它值为失败 */
    protected Integer code;

    /** 响应信息 */
    protected String msg;

    /** 是否成功 */
    protected boolean success;

    public Integer getCode(){
        return code;
    }

    public BaseResponse setCode(Integer code){
        this.code = code;
        return this;
    }

    public String getMsg(){
        return msg;
    }

    public BaseResponse setMsg(String msg){
        this.msg = msg;
        return this;
    }

    public boolean isSuccess(){
        return SUCCESS_CODE.equals(code);
    }

    @Override public String toString(){
        return "BaseResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", success=" + success +
                '}';
    }
}
