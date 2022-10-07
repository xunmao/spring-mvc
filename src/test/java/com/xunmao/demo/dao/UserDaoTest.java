package com.xunmao.demo.dao;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xunmao.demo.pojo.User;

public class UserDaoTest {

    @Test
    public void shouldFindUserByUsername() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml")) {
            UserDao userDao = context.getBean("userDao", UserDao.class);
            User user = userDao.findUserByUsername("xunmao");
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
