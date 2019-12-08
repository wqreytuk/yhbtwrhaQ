package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

/*
使用junit进行单元测试
 */
public class AccountServiceTest {
    @Test
    public void testFindAll() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        List<Account> accounts = as.findAllAccount();
        for(Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        Account account = new Account();
        account.setId(4);
        account.setMoney((float) 2000.0);
        account.setName("testaaa");
        as.saveAccount(account);
    }

    @Test
    public void testUpdate() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        Account account = new Account();
        account.setId(3);
        account.setMoney((float) 2000.0);
        account.setName("testbbb");
        as.updateAccount(account);
    }

    @Test
    public void testDelete() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        as.deleteAccount(5);
    }
}
