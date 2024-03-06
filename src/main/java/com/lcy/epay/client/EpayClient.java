package com.lcy.epay.client;

import java.util.Map;

import com.lcy.epay.model.response.BatchOrderResponse;
import com.lcy.epay.model.response.OrderResponse;
import com.lcy.epay.model.response.PayResponse;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

/**
 * epay请求客户端
 * @Author lcy
 * @Date 2023/10/21 14:34
 */
public interface EpayClient {

    @RequestLine("POST /api.php")
    @Headers("Accept: text/html;charset=utf-8")
    PayResponse pay(@QueryMap Map<String,Object> params);

    @RequestLine("POST /api.php")
    @Headers("Accept: text/html;charset=utf-8")
    OrderResponse queryOrder(@QueryMap Map<String,Object> params);

    @RequestLine("POST /api.php")
    @Headers("Accept: text/html;charset=utf-8")
    BatchOrderResponse queryBatchOrder(@QueryMap Map<String,Object> params);

}
