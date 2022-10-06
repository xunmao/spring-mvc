package com.xunmao.demo.pojo;

import java.util.Date;

public class User {

    private int userId;
    private String username;
    private String password;
    private Date lastUpdate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public User(int userId, String username, String password, Date lastUpdate) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", lastUpdate="
                + lastUpdate + "]";
    }
}
