package com.lcy.epay.model.request;

import java.util.TreeMap;

/**
 * 基础请求
 * @Author lcy
 * @Date 2023/10/20 16:18
 */
public interface BaseRequest {

    TreeMap<String,Object> toMap();

}
