package com.alibaba.cloud.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RefreshScope
@RequestMapping("/sentinel")
public class SentinelController {

    @RequestMapping("/demo")
    public String demo() {
        return "sentinel - demo ok!!!";
    }


    /**
     * 测试sentinel 服务降级和熔断
     * blockHandler = "" 使用sentinel进行不同规则控制时的默认处理方案
     * fallback = "" 自定义业务出错时默认处理方案
     * defaultFallback = "" 指定一个业务错误时默认方案
     *
     * @return
     */
    @RequestMapping("/fusing/{id}")
    //blockHandler = "" 使用sentinel进行不同规则控制时的默认处理方案
    //fallback = "" 自定义业务出错时默认处理方案
    //defaultFallback = "" 指定一个业务错误时默认方案
    @SentinelResource(value = "aaa", blockHandler = "blockHandler", fallback = "fallCustomer", defaultFallback = "fall")
    public String fusing(HttpServletRequest request, @PathVariable("id") Integer id) {
        if (id == 2) throw new RuntimeException("id无效");
        return "sentinel - demo ok!!!id=" + id;
    }


    public String blockHandler(int id, BlockException e) {
        if (e instanceof FlowException) {
            return "当前请求过于火爆，您已被流量控制！！！";
        }
        if (e instanceof DegradeException) {
            return "当前请求过于火爆，您已被降级！！！";
        }
        if (e instanceof ParamFlowException) {
            return "当前请求过于火爆，您已被热点参数限流！！！";
        }
        return "服务器快爆了，请稍后再试！！！";
    }

    public String fallCustomer(int id) {
        return "自定义处理----我们服务器出错了" + id;
    }

    public String fall(int id) {
        return "默认处理----我们服务器出错了" + id;
    }

    @RequestMapping("/test")
    public String test() {
        return "test ok!!!";
    }

}
