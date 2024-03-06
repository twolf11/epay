package com.lcy.epay.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lcy.epay.enums.PayTypeEnum;

import static com.lcy.epay.constant.Constants.TRADE_SUCCESS;

/**
 * 支付回调结果
 * @Author lcy
 * @Date 2023/10/21 18:00
 */
public class PayNotifyResponse {

    /** 是否支付成功 */
    private boolean paySuccess;

    /** pid */
    @JsonProperty("pid")
    private Integer pid;

    /** 易支付订单号 */
    @JsonProperty("trade_no")
    private String tradeNo;

    /** 商家订单号 */
    @JsonProperty("out_trade_no")
    private String outTradeNo;

    /** 支付类型 */
    @JsonProperty("type")
    private String type;

    /** 商品名称 */
    @JsonProperty("name")
    private String name;

    /** 金额 */
    @JsonProperty("money")
    private String money;

    /** 原始支付状态 */
    @JsonProperty("trade_status")
    private String tradeStatus;

    public boolean isPaySuccess(){
        return TRADE_SUCCESS.equals(tradeStatus);
    }

    public Integer getPid(){
        return pid;
    }

    public PayNotifyResponse setPid(Integer pid){
        this.pid = pid;
        return this;
    }

    public String getTradeNo(){
        return tradeNo;
    }

    public PayNotifyResponse setTradeNo(String tradeNo){
        this.tradeNo = tradeNo;
        return this;
    }

    public String getOutTradeNo(){
        return outTradeNo;
    }

    public PayNotifyResponse setOutTradeNo(String outTradeNo){
        this.outTradeNo = outTradeNo;
        return this;
    }

    public String getType(){
        return type;
    }

    public PayNotifyResponse setType(String type){
        this.type = type;
        return this;
    }

    public String getName(){
        return name;
    }

    public PayNotifyResponse setName(String name){
        this.name = name;
        return this;
    }

    public String getMoney(){
        return money;
    }

    public PayNotifyResponse setMoney(String money){
        this.money = money;
        return this;
    }

    public String getTradeStatus(){
        return tradeStatus;
    }

    public PayNotifyResponse setTradeStatus(String tradeStatus){
        this.tradeStatus = tradeStatus;
        return this;
    }

    @Override public String toString(){
        return "PayNotifyResponse{" +
                "paySuccess=" + paySuccess +
                ", pid=" + pid +
                ", tradeNo='" + tradeNo + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", money='" + money + '\'' +
                ", tradeStatus='" + tradeStatus + '\'' +
                '}';
    }
}