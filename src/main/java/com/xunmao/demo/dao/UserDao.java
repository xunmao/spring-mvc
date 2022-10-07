package com.xunmao.demo.dao;

import com.xunmao.demo.pojo.User;

public interface UserDao {

    public User findUserByUsername(String username);
}
