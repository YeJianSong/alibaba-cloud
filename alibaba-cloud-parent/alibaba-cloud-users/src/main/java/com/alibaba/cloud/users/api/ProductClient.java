package com.alibaba.cloud.users.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("PRODUCTS")
public interface ProductClient {

    @RequestMapping("/products/product/{id}")
    String product(@PathVariable("id") Integer id);
}
