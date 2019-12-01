package com.itheima.ui;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
模拟表现层，用于调用业务层
 */
public class Client {
    /*
    获取spring的IOC核心容器，并根据id获取对象
     */
    public static void main(String[] args) {
        //获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取bean对象
        //下面演示了两种获取的方式，一种需要强转，一种不需要
        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountDao adao = ac.getBean("accountDao", IAccountDao.class);

        System.out.println(as);
        System.out.println(adao);
    }
}

