package com.xunmao.demo.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xunmao.demo.pojo.User;

public class UserServiceTest {

    private Map<User, Boolean> testData = new HashMap<>();

    @Test
    public void shouldVerifyUser() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml")) {
            UserService userService = context.getBean("userService", UserService.class);

            loadTestData();
            for (Map.Entry<User, Boolean> entry : testData.entrySet()) {
                User user = entry.getKey();
                Boolean isValidUser = userService.isValidUser(user);
                if (isValidUser) {
                    System.out.printf("验证成功: Username: %s, Password: %s\n", user.getUsername(), user.getPassword());
                } else {
                    System.out.printf("验证失败: Username: %s, Password: %s\n", user.getUsername(), user.getPassword());
                }
                assertEquals(entry.getValue(), isValidUser);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadTestData() {
        User validUser = new User(1, "xunmao", "19890706", new Date());
        User notExistUser = new User(1, "not-exist", "19890706", new Date());
        User wrongPassUser = new User(1, "xunmao", "20221007", new Date());
        testData.put(validUser, true);
        testData.put(notExistUser, false);
        testData.put(wrongPassUser, false);
    }
}
