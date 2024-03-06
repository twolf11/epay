package com.lcy.epay.model.request;

import java.util.TreeMap;

/**
 * 支付请求参数
 * @Author lcy
 * @Date 2023/10/20 15:39
 */
public class PayRequest implements BaseRequest {

    /** 支付方式,枚举PayTypeEnum；alipay:支付宝,tenpay:财付通,qqpay:QQ钱包,wxpay:微信支付 */
    private String type;

    /** 交易单号 */
    private String outTradeNo;

    /** 异步通知地址 */
    private String notifyUrl;

    /** 跳转通知地址 */
    private String returnUrl;

    /** 商品名称 */
    private String name;

    /** 金额 */
    private String money;

    /** 来源网站名称 */
    private String sitename;

    public PayRequest(){
    }

    public PayRequest(String type,String outTradeNo,String notifyUrl,String returnUrl,String name,String money,String sitename){
        this.type = type;
        this.outTradeNo = outTradeNo;
        this.notifyUrl = notifyUrl;
        this.returnUrl = returnUrl;
        this.name = name;
        this.money = money;
        this.sitename = sitename;
    }

    private PayRequest(Builder builder){
        setType(builder.type);
        setOutTradeNo(builder.outTradeNo);
        setNotifyUrl(builder.notifyUrl);
        setReturnUrl(builder.returnUrl);
        setName(builder.name);
        setMoney(builder.money);
        setSitename(builder.sitename);
    }

    @Override public TreeMap<String,Object> toMap(){
        TreeMap<String,Object> params = new TreeMap<>();
        params.put("type",type);
        params.put("out_trade_no",outTradeNo);
        params.put("notify_url",notifyUrl);
        params.put("return_url",returnUrl);
        params.put("name",name);
        params.put("money",money);
        params.put("sitename",sitename);
        return params;
    }

    public String getType(){
        return type;
    }

    public PayRequest setType(String type){
        this.type = type;
        return this;
    }

    public String getOutTradeNo(){
        return outTradeNo;
    }

    public PayRequest setOutTradeNo(String outTradeNo){
        this.outTradeNo = outTradeNo;
        return this;
    }

    public String getNotifyUrl(){
        return notifyUrl;
    }

    public PayRequest setNotifyUrl(String notifyUrl){
        this.notifyUrl = notifyUrl;
        return this;
    }

    public String getReturnUrl(){
        return returnUrl;
    }

    public PayRequest setReturnUrl(String returnUrl){
        this.returnUrl = returnUrl;
        return this;
    }

    public String getName(){
        return name;
    }

    public PayRequest setName(String name){
        this.name = name;
        return this;
    }

    public String getMoney(){
        return money;
    }

    public PayRequest setMoney(String money){
        this.money = money;
        return this;
    }

    public String getSitename(){
        return sitename;
    }

    public PayRequest setSitename(String sitename){
        this.sitename = sitename;
        return this;
    }

    @Override public String toString(){
        return "PayRequest{" +
                "type='" + type + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", returnUrl='" + returnUrl + '\'' +
                ", name='" + name + '\'' +
                ", money='" + money + '\'' +
                ", sitename='" + sitename + '\'' +
                '}';
    }

    public static final class Builder {

        private String type;

        private String outTradeNo;

        private String notifyUrl;

        private String returnUrl;

        private String name;

        private String money;

        private String sitename;

        public Builder(){}

        public Builder type(String val){
            type = val;
            return this;
        }

        public Builder outTradeNo(String val){
            outTradeNo = val;
            return this;
        }

        public Builder notifyUrl(String val){
            notifyUrl = val;
            return this;
        }

        public Builder returnUrl(String val){
            returnUrl = val;
            return this;
        }

        public Builder name(String val){
            name = val;
            return this;
        }

        public Builder money(String val){
            money = val;
            return this;
        }

        public Builder sitename(String val){
            sitename = val;
            return this;
        }

        public PayRequest build(){
            return new PayRequest(this);
        }
    }
}
