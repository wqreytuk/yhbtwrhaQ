package com.itheima.ui;

import com.itheima.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
模拟表现层，用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as1 = ac.getBean("accountService", IAccountService.class);
        IAccountService as2 = ac.getBean("accountService", IAccountService.class);

        System.out.println(as1 == as2);
    }
}

