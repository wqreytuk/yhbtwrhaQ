package com.itheima.ui;

import com.itheima.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/*
模拟表现层，用于调用业务层
 */
public class Client {
    /*
    获取spring的IOC核心容器，并根据id获取对象

    ApplicationContext的三个常用实现类
         - ClassPathXmlApplicationContext
            加载类路径下的配置文件，配置文件必须在类路径下，否则加载不了
         - FileSystemXmlApplicationContext
            加载磁盘中任意位置的配置文件（我们的应用程序必须拥有对该文件的访问权限）
            出于可移植性的考虑，我们一般不选用这种读取配置文件的方式
         - AnnotationConfigApplicationContext
            通过读取注解来创建对象

    核心容器的两个接口引出的问题
        ApplicationContext
            该接口在创建核心容器时，一旦读取完配置文件，就会立即创建对象
                采用的策略是***立即加载***
            在下面的例子中，我们在AccountServiceImpl的构造函数中输出一句话，然后在
            ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
            的后面创建断点，debug程序，可以发现，该语句执行完之后AccountServiceImpl对象已经创建出来，也就是说，读取完配置文件之后，对象就被创建了出来
        BeanFactory
            采用的策略是***延时加载***
                在程序真正根据id去获取对象的时候才进行创建

    ***我们要讨论的问题是，我们什么时候应该使用哪个接口***
        前者适合单例模式
        后这适合多例模式

     最后的结论
        我们在实际开发工作中，使用最多的其实是前者
            因为ApplicationContext的功能相较而言是更强大的，我们可以在配置文件中通过配置
            来告知ApplicationContext使用单例模式还是使用多例模式
     */
    public static void main(String[] args) {
        /******ApplicationContext******/

        /*
        //获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取bean对象
        //下面演示了两种获取的方式，一种需要强转，一种不需要
        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountDao adao = ac.getBean("accountDao", IAccountDao.class);

        System.out.println(as);
        System.out.println(adao);
        */

        /******BeanFactory******/

        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IAccountService as = (IAccountService)factory.getBean("accountService");
        System.out.println(as);
    }
}

