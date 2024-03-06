package com.lcy.epay.model.response;

/**
 * 支付响应
 * @Author lcy
 * @Date 2023/10/21 18:00
 */
public class BachOrderResponse extends BaseResponse {

    /** 订单id-第三方系统自动生成的 */
    private String orderid;

    /** 支付平台的支付地址 */
    private String payurl;

    /** 金额 */
    private String money;

    /** 数据 */
    private String qrdata;

    public String getOrderid(){
        return orderid;
    }

    public BachOrderResponse setOrderid(String orderid){
        this.orderid = orderid;
        return this;
    }

    public String getPayurl(){
        return payurl;
    }

    public BachOrderResponse setPayurl(String payurl){
        this.payurl = payurl;
        return this;
    }

    public String getMoney(){
        return money;
    }

    public BachOrderResponse setMoney(String money){
        this.money = money;
        return this;
    }

    public String getQrdata(){
        return qrdata;
    }

    public BachOrderResponse setQrdata(String qrdata){
        this.qrdata = qrdata;
        return this;
    }

    @Override public String toString(){
        return "BachOrderResponse{" +
                "orderid='" + orderid + '\'' +
                ", payurl='" + payurl + '\'' +
                ", money='" + money + '\'' +
                ", qrdata='" + qrdata + '\'' +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", success=" + success +
                '}';
    }
}
