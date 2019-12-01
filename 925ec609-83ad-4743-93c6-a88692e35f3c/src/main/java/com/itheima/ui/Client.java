package com.itheima.ui;

import com.itheima.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
模拟表现层，用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        as.saveAccount();

        //手动关闭容器
        /*
        来解释一下ApplicationContext
            当我们一开始获取容器时，使用的代码是
                ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
           这个对象是ApplicationContext类型的，而ApplicationContext只是一个接口，它并没有定义close方法，所以并不能调用close方法，所以我们必须在声明对象时就声明成子类对象
         */
        ac.close();
    }
}

