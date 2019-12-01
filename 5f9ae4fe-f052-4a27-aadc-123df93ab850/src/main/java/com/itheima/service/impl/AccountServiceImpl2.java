package com.itheima.service.impl;

import com.itheima.service.IAccountService;

import java.util.Date;

/*
账户的业务层实现类
 */
public class AccountServiceImpl2 implements IAccountService {
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "AccountServiceImpl2{" +
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
