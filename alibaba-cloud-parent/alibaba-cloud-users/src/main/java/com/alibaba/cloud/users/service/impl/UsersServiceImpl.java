package com.alibaba.cloud.users.service.impl;

import com.alibaba.cloud.users.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UsersServiceImpl implements UsersService{

    //定义票的总数
    private int total = 100;

    //定义票的编号
    private int no = total + 1;

    //定义一个线程同步对象
    private Object obj = new Object();

    @Override
    public String ticket (String name) {
            synchronized (this.obj) {
                if (total > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String msg = Thread.currentThread().getName() + " 售出第   " + (this.no - this.total) + "张票,"+ name +"抢票成功";
                    log.info("开始卖票:{}",msg);
                    this.total --;
                    return name + "通过线程"+ Thread.currentThread().getName() + " 抢到第   " + (this.no - this.total) + "张票！";
                }else {
                    log.info("票已售完，请下次再来！");
                    return name + "通过线程"+ Thread.currentThread().getName() + "抢票失败！";
                }
            }
        }


}
