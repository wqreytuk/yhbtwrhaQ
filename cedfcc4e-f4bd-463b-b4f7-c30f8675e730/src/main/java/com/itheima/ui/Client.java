package com.itheima.ui;

import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
模拟表现层，用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService as1 = (IAccountService) ac.getBean("accountService");
        IAccountService as2 = (IAccountService) ac.getBean("accountService");

        System.out.println(as1 == as2);

        AccountServiceImpl as = ac.getBean("accountService", AccountServiceImpl.class);
        as.saveAccount();
        ac.close();
    }
}

