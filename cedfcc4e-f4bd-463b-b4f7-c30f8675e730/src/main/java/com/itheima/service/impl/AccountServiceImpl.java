package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
/*
账户的业务层实现类
 */
/*
曾经的xml配置
    <bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl" scope="" init-method="" destroy-method="">
        <property name="" value=""></property>
    </bean>

用于创建对象的注解
    与 xml配置文件中编写一个<bean>标签的作用是一样的
    @Component
        用于把当前类对象存入spring容器中
        属性
            value：用于指定beand的id
                如果我们不对vluea属性进行赋值，那么默认的id是类名的首字母小写
    下面这三个注解的作用和@Component的作用是一模一样的
        他们三个是spring框架明确三层结构所使用的的注解，使我们三层对象中的每一层都比较清晰
    @Controller
        表现层
    @Service
        业务层
    @Repository
        持久层
用于注入数据的注解
    与xml配置文件中bean标签中的<property>标签的作用是一样的
    @AutoWired
        自动按照类型注入，只要容器中有***唯一***的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
            如果有两个及以上匹配的bean对象，那么会先匹配变量类型，***再匹配变量名称***
        作用的位置
            成员变量、方法
    @Qualifier
        在按照类型注入的基础之上，再按照名称注入
        无法单独给类成员进行注入***给类成员进行注入时，需要和@AutoWired配合使用***，但是可以给方法注入参数
        属性
            value
                用于指定注入bean的id
    @Resource *** 常用 ***
        直接按照bean的id进行注入，可以独立对类成员进行注入
        属性
            name
                用于指定bean的id
    以上三个注解只能注入其他bean类型，而基本类型和String类型无法使用上述注解实现
    集合类型的注入只能通过XML实现

    @Value
        该注解用于注入基本类型和String类型
        属性
            value
                用于指定数据的值
                使用spring的el表达式进行赋值，称之为SpEL
                    写法
                        ${表达式}
用于改变作用范围的注解
    与<bean>标签中使用<scope>属性的功能是一样的
    @Scope
        用于指定bean的范围
        属性
            value
                指定范围的取值
                    常用取值
                        singleton
                        prototype
和生命周期相关的注解
    *** 不常用 ***

    与<bean>标签中的init-method和destroy-method属性的作用是一样的
    @PreDestroy
        用于指定销毁方法
    @PostConstruct
        用于指定初始化方法
 */

@Service(value="accountService")
@Scope(value="singleton")
public class AccountServiceImpl implements IAccountService {
    /*
    当我们添加完@Autowired注解之后，Client类中产生的AccountDaoImpl对象就会注入到这里
     */
//    @Autowired
//    @Qualifier(value="accounDao1");
    @Resource(name="accountDao2")
    private IAccountDao accountDao;

    @PostConstruct
    public void init() {
        System.out.println("初始化执行了");
    }

    @PreDestroy
    public void Destroy() {
        System.out.println("销毁化执行了");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
