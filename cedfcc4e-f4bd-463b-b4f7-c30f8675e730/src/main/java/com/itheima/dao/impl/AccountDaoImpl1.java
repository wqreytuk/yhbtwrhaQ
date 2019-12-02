package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/*
账户的持久层实现类
 */
@Repository(value="accountDao1")
public class AccountDaoImpl1 implements IAccountDao {
    public void saveAccount() {
        System.out.println("AccountDaoImpl1保存了账户。。。");
    }
}
