package com.lcy.epay.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 支付类型枚举
 * @Author lcy
 * @Date 2023/9/30 14:51
 */
public enum PayTypeEnum {
    ALIPAY("alipay","支付宝"),
    TENPAY("tenpay","财付通"),
    QQPAY("qqpay","QQ钱包"),
    WXPAY("wxpay","微信支付");

    PayTypeEnum(String type,String desc){
        this.type = type;
        this.desc = desc;
    }

    /** 类型 */
    private final String type;

    /** 注释 */
    private final String desc;

    public String getType(){
        return type;
    }

    public String getDesc(){
        return desc;
    }

    @JsonValue
    public static PayTypeEnum getByType(String type){
        for (PayTypeEnum payTypeEnum : values()) {
            if (payTypeEnum.type.equals(type)) {
                return payTypeEnum;
            }
        }
        return null;
    }
}
