package com.alibaba.cloud.users.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Scope("prototype")//spring 多例
public class BusinessThread implements Runnable {

    private String acceptStr;

    public BusinessThread(String acceptStr) {
        this.acceptStr = acceptStr;
    }

    public String getAcceptStr() {
        return acceptStr;
    }

    public void setAcceptStr(String acceptStr) {
        this.acceptStr = acceptStr;
    }

    @Override
    public void run() {
        //业务操作（进行多线程下的业务操作）
        log.info("多线程已经处理订单插入系统，订单号：#{}", acceptStr);
    }
}
