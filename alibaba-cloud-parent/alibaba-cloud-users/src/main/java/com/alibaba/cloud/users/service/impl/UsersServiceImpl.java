package com.alibaba.cloud.users.service.impl;

import com.alibaba.cloud.users.service.UsersService;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService{

    //定义票的总数
    private int total = 100;

    //定义票的编号
    private int no = total + 1;

    //定义一个线程同步对象
    private Object obj = new Object();

    @Override
    public void ticket (String name) {
            synchronized (this.obj) {
                if (total > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String msg = Thread.currentThread().getName() + " 售出第   " + (this.no - this.total) + "张票,"+ name +"抢票成功";
                    System.out.println(msg);
                    this.total --;
                }else {
                    System.out.println("票已售完，请下次再来！");
//                    System.exit(0);
                }
            }
        }


}
