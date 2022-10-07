package com.xunmao.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.xunmao.demo.dao.UserDao;
import com.xunmao.demo.pojo.User;
import com.xunmao.demo.service.UserService;

public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public boolean isValidUser(User user) {
        User expectedUser = userDao.findUserByUsername(user.getUsername());
        if (expectedUser == null) {
            return false;
        }
        if (expectedUser.getPassword() == null) {
            return false;
        }
        if (!expectedUser.getPassword().equals(user.getPassword())) {
            return false;
        }
        return true;
    }
}
