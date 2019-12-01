package com.itheima.factory;

import com.itheima.service.impl.AccountServiceImpl;

/*
模拟一个工厂类
*/
public class StaticFactory {
    public static AccountServiceImpl getAccountService() {
        return new AccountServiceImpl();
    }
}
