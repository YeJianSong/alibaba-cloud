package com.alibaba.cloud.gateway.config;

/**
 * @program: alibaba.cloud.message
 * @description: 此配置用于后期维护需要放行的URL
 * @author: JianSong Ye
 * @create: 2022-04-16 21:27
 **/
public class URLFilter {

    // 后期需要放行的请求URL(可配置多个)
    private static String uri = "/api/users/login,/api/products/login";


    // 判断用户的请求是否包含上面允许放行的uri
    public static boolean hasAuthorization(String url){
        String[] uris = uri.split(",");
        for (String uri : uris) {
            if (url.startsWith(uri)){
                // 放行
                return true;
            }
        }
        // 拦截
        return false;
    }

}
