package com.alibaba.cloud.users.service.impl;

import com.alibaba.cloud.users.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService {


    /**
     * 调用异步，通过线程池处理并发请求
     */
    @Async("taskExecutor")
    @Override
    public void executeAsync() {
        log.info("start executeAsync");
        log.info("当前运行的线程名称：{}", Thread.currentThread().getName());
        log.info("end executeAsync");
    }
}
