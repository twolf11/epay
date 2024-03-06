package com.lcy.epay.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.codec.digest.DigestUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcy.epay.client.EpayClient;
import com.lcy.epay.exception.PayException;
import com.lcy.epay.model.request.PayRequest;
import com.lcy.epay.model.response.BatchOrderResponse;
import com.lcy.epay.model.response.OrderResponse;
import com.lcy.epay.model.response.PayNotifyResponse;
import com.lcy.epay.model.response.PayResponse;
import feign.Feign;
import feign.Request;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

import static com.lcy.epay.constant.Constants.PAY_URL;

/**
 * epay相关service
 * @Author lcy
 * @Date 2023/10/20 16:22
 */
public class EpayService {

    private final String url;

    private final Integer pid;

    private final String key;

    private final EpayClient epayClient;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public EpayService(String url,Integer pid,String key){
        this.url = url;
        this.pid = pid;
        this.key = key;
        epayClient = Feign.builder()
                //设置连接和读超时间都是10s
                .options(new Request.Options(10,TimeUnit.SECONDS,10,TimeUnit.SECONDS,true))
                .encoder(new JacksonEncoder()) // 编码方式
                .decoder(new JacksonDecoder())  // 解码方式
                .target(EpayClient.class,url); //目标地址
    }

    /**
     * 发起交易请求
     * @param payRequest 请求参数
     * @author lcy
     * @date 2023/10/20 16:25
     **/
    public PayResponse pay(PayRequest payRequest){
        TreeMap<String,Object> map = payRequest.toMap();
        map.put("pid",pid);
        toSign(map);
        return epayClient.pay(map);
    }

    /**
     * 发起交易请求,返回支付的地址
     * @param payRequest 请求参数
     * @return 跳转的utl地址
     * @author lcy
     * @date 2023/10/20 16:25
     **/
    public String payUrl(PayRequest payRequest){
        TreeMap<String,Object> map = payRequest.toMap();
        map.put("pid",pid);
        toSign(map);
        PayResponse payResponse = epayClient.pay(map);
        if (payResponse.isSuccess()) {
            String orderid = payResponse.getOrderid();
            return url + PAY_URL + "?trade_no=" + orderid;
        }
        return "";
    }

    /**
     * 异步通知回调
     * @param map 请求参数
     * @return 跳转的utl地址
     * @author lcy
     * @date 2023/10/20 16:25
     **/
    public PayNotifyResponse asyncNotify(Map<String,Object> map){
        if (!checkSign(map)) {
            throw new PayException("验签错误");
        }
        PayNotifyResponse payNotifyResponse = new PayNotifyResponse();
        payNotifyResponse.setPid(Optional.ofNullable(map.get("pid")).map(Object :: toString).map(Integer :: parseInt).orElse(null))
                .setTradeNo(Optional.ofNullable(map.get("trade_no")).map(Object :: toString).orElse(null))
                .setOutTradeNo(Optional.ofNullable(map.get("out_trade_no")).map(Object :: toString).orElse(null))
                .setType(Optional.ofNullable(map.get("type")).map(Object :: toString).orElse(null))
                .setName(Optional.ofNullable(map.get("name")).map(Object :: toString).orElse(null))
                .setMoney(Optional.ofNullable(map.get("money")).map(Object :: toString).orElse(null))
                .setTradeStatus(Optional.ofNullable(map.get("trade_status")).map(Object :: toString).orElse(null));
        return payNotifyResponse;
    }

    /**
     * 查询订单
     * @param outTradeNo 商户订单号
     * @author lcy
     * @date 2023/10/20 16:25
     **/
    public OrderResponse queryOrder(String outTradeNo) throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("act","order");
        map.put("pid",pid);
        map.put("key",key);
        map.put("out_trade_no",outTradeNo);
        return epayClient.queryOrder(map);
    }

    /**
     * 批量查询订单
     * @param limit 返回的订单数量，最大50
     * @author lcy
     * @date 2023/10/20 16:25
     **/
    public BatchOrderResponse queryBatchOrder(String limit) throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("act","orders");
        map.put("pid",pid);
        map.put("key",key);
        map.put("limit",limit);
        return epayClient.queryBatchOrder(map);
    }

    /**
     * 数据加签
     * @param map 数据集合
     * @author lcy
     * @date 2023/10/21 18:24
     **/
    public void toSign(Map<String,Object> map){
        boolean isTreeMap = map instanceof TreeMap;
        if (!isTreeMap) {
            map = new TreeMap<>(map);
        }
        String paramString = map.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("&"));
        paramString = paramString + key;
        // 计算MD5哈希值
        String sign = DigestUtils.md5Hex(paramString);
        map.put("sign",sign);
        map.put("sign_type","MD5");
    }

    /**
     * 数据签名验证
     * @param map 数据集合
     * @author lcy
     * @date 2023/10/21 18:24
     **/
    public boolean checkSign(Map<String,Object> map){
        boolean isTreeMap = map instanceof TreeMap;
        if (!isTreeMap) {
            map = new TreeMap<>(map);
        }
        map.remove("sign_type");
        Object checkSign = map.remove("sign");

        String paramString = map.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("&"));
        paramString = paramString + key;
        // 计算MD5哈希值
        String sign = DigestUtils.md5Hex(paramString);
        return Objects.equals(checkSign,sign);
    }

}
