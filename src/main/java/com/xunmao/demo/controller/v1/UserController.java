package com.xunmao.demo.controller.v1;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.xunmao.demo.pojo.User;
import com.xunmao.demo.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/v1/login")
    public String login(String username, String password) {
        User user = new User(0, username, password, new Date());
        Boolean isValidUser = userService.isValidUser(user);
        if (isValidUser) {
            return "redirect:/hello?username=" + username;
        }
        return "redirect:/hello";
    }
}
