package com.alibaba.cloud.sentinel.exception;

import com.alibaba.cloud.sentinel.entity.Product;
import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;

public class SentinelUtils {

    // 限流降级
    public static SentinelClientHttpResponse handleBlock(HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockException ex) {
        Product product = new Product().setProductName("sentinel RestTemplate 限流");
        return new SentinelClientHttpResponse(JSON.toJSONString(product));
    }

    //异常降级业务逻辑
    public static SentinelClientHttpResponse handleFallback(HttpRequest request, byte[] body,
                                                            ClientHttpRequestExecution execution, BlockException ex) {
        Product product = new Product().setProductName("sentinel RestTemplate 熔断");
        return new SentinelClientHttpResponse(JSON.toJSONString(product));
    }
}
