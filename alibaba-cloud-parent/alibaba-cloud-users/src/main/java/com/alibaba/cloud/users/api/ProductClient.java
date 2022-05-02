package com.alibaba.cloud.users.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: alibaba.cloud.products
 * @description: 使用FeignClient实现远程调用，提供对外api
 * @author: JianSong Ye
 * @create: 2022-04-10 15:28
 **/
@FeignClient("service-product")
public interface ProductClient {

    @RequestMapping("/api/products/product/{id}")
    String product(@PathVariable("id") Integer id);
}
