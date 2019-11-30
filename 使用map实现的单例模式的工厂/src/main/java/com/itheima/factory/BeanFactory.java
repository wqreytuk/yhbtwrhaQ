package com.itheima.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
一个创建Bean对象的工厂
    Bean在计算机英语中的意思是***可重用组件***\
JavaBean
    javabean所代表的的范围远大于实体类
    所谓JavaBean就是使用java编写的可重用组件

在我们的例子中，就是创建我们的service和dao对象

降低程序耦合
    创建配置文件
        全限定类名（就是我们要创建的类的标识符）
            在配置文件中就是一个key-->value形式
    读取配置文件反射创建bean对象
    配置文件的形式有两种选择
        xml文件
        properties文件
 */
public class BeanFactory {
    //定义一个Properties对象
     private static Properties props;

     //定义一个Map，用于存放我们要创建的对象，我们称之为***容器***
    private static Map<String, Object> beans;
     //使用静态代码块为Properties对象赋值
    static {
         try {
             //实例化对象
             props = new Properties();
             //获取Properties文件的流对象
             //为了保证程序的可移植性，我们使用getClassLoader来获取路径
             InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
             props.load(in);
             //实例化容器
/***********************************************************************/
             beans = new HashMap<String, Object>();
             //取出配置文件中所有的key
             Enumeration<Object> keys = props.keys();
             //遍历枚举
             while (keys.hasMoreElements()) {
                 //取出每个key
                 String key = keys.nextElement().toString();
                 //根据key获取value
                 String beanPath = props.getProperty(key);
                 //反射创建对象
                 Object value = Class.forName(beanPath).newInstance();
                 beans.put(key, value);
             }
/***********************************************************************/
         } catch (Exception e) {
             throw new ExceptionInInitializerError("初始化propreties文件失败");
         }
     }
     //根据bean的名称获取bean对象
    public static Object getBean(String beanName) {
        return  beans.get(beanName);
    }
}
