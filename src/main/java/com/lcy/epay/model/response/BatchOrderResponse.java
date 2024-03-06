package com.lcy.epay.model.response;

import java.util.List;

/**
 * 支付响应
 * @Author lcy
 * @Date 2023/10/21 18:00
 */
public class BatchOrderResponse extends BaseResponse {

    /** 订单列表 */
    private List<OrderResponse> data;

    @Override public String toString(){
        return "BatchOrderResponse{" +
                "data=" + data +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", success=" + success +
                '}';
    }
}
