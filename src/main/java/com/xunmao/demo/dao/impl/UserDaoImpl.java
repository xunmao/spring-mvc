package com.xunmao.demo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.xunmao.demo.dao.UserDao;
import com.xunmao.demo.pojo.User;
import com.xunmao.demo.util.DataSource;

public class UserDaoImpl implements UserDao {

    @Autowired
    DataSource dataSource;

    @Override
    public User findUserByUsername(String username) {
        return dataSource.getUsers().get(username);
    }
}
