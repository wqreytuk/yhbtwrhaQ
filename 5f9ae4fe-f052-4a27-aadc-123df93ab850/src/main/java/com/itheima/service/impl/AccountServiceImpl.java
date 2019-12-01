package com.itheima.service.impl;

import com.itheima.service.IAccountService;

import java.util.Date;

/*
账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "AccountServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了");
        System.out.println(toString());
    }
}
