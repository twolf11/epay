package com.lcy.epay.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import static com.lcy.epay.constant.Constants.TRADE_SUCCESS;

/**
 * 支付响应
 * @Author lcy
 * @Date 2023/10/21 18:00
 */
public class OrderResponse extends BaseResponse {

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

    /** 创建订单时间--示例：2016-08-06 22:55:52 */
    @JsonProperty("addtime")
    private String addTime;

    /** 完成交易时间--示例：2016-08-06 22:55:52 */
    @JsonProperty("endtime")
    private String endTime;

    public boolean isPaySuccess(){
        return TRADE_SUCCESS.equals(tradeStatus);
    }

    public Integer getPid(){
        return pid;
    }

    public OrderResponse setPid(Integer pid){
        this.pid = pid;
        return this;
    }

    public String getTradeNo(){
        return tradeNo;
    }

    public OrderResponse setTradeNo(String tradeNo){
        this.tradeNo = tradeNo;
        return this;
    }

    public String getOutTradeNo(){
        return outTradeNo;
    }

    public OrderResponse setOutTradeNo(String outTradeNo){
        this.outTradeNo = outTradeNo;
        return this;
    }

    public String getType(){
        return type;
    }

    public OrderResponse setType(String type){
        this.type = type;
        return this;
    }

    public String getName(){
        return name;
    }

    public OrderResponse setName(String name){
        this.name = name;
        return this;
    }

    public String getMoney(){
        return money;
    }

    public OrderResponse setMoney(String money){
        this.money = money;
        return this;
    }

    public String getTradeStatus(){
        return tradeStatus;
    }

    public OrderResponse setTradeStatus(String tradeStatus){
        this.tradeStatus = tradeStatus;
        return this;
    }

    public String getAddTime(){
        return addTime;
    }

    public OrderResponse setAddTime(String addTime){
        this.addTime = addTime;
        return this;
    }

    public String getEndTime(){
        return endTime;
    }

    public OrderResponse setEndTime(String endTime){
        this.endTime = endTime;
        return this;
    }

    @Override public String toString(){
        return "OrderResponse{" +
                "paySuccess=" + paySuccess +
                ", pid=" + pid +
                ", tradeNo='" + tradeNo + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", money='" + money + '\'' +
                ", tradeStatus='" + tradeStatus + '\'' +
                ", addTime='" + addTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", success=" + success +
                '}';
    }
}
