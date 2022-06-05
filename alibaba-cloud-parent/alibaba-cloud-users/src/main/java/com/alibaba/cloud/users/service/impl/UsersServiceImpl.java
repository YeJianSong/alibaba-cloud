package com.alibaba.cloud.users.service.impl;

import com.alibaba.cloud.users.entity.UserEntity;
import com.alibaba.cloud.users.mapper.UserMapper;
import com.alibaba.cloud.users.service.UsersService;
import com.alibaba.cloud.users.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: alibaba.cloud.products
 * @description: TODO
 * @author: JianSong Ye
 * @create: 2022-04-10 15:28
 **/
@Slf4j
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserMapper userMapper;

    @Autowired(required = false)
    private RedisUtil redisUtil;





    //定义票的总数
    private int total = 100;

    //定义票的编号
    private int no = total + 1;

    //定义一个线程同步对象
    private Object obj = new Object();

    @Override
    public String ticket(String name) {
        synchronized (this.obj) {
            if (total > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String msg = Thread.currentThread().getName() + " 售出第   " + (this.no - this.total) + "张票," + name + "抢票成功";
                log.info("开始卖票:{}", msg);
                this.total--;
                return name + "通过线程" + Thread.currentThread().getName() + " 抢到第   " + (this.no - this.total) + "张票！";
            } else {
                log.info("票已售完，请下次再来！");
                return name + "通过线程" + Thread.currentThread().getName() + "抢票失败！";
            }
        }
    }

    @Override
    public void getData() {
        UserEntity userEntity = userMapper.selectById(1);
        redisUtil.set("测试","测试");
        System.out.println(userEntity);
    }


}
