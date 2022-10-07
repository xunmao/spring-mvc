package com.xunmao.demo.controller.v1;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloInterfaceController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        // 1. 创建 ModelAndView 的实例，最后返回该实例
        ModelAndView modelAndView = new ModelAndView();

        // 2. 根据业务逻辑，将数据放入 ModelAndView 的实例中
        // 2.1. 获取参数 user
        String user = req.getParameter("user");
        // 2.2. 设置 title
        modelAndView.addObject("user", user);
        // 2.2. 设置 h1
        Date currentTime = new Date(System.currentTimeMillis());
        String message = String.format("Hi, %s! Current Time is %s", user, currentTime);
        modelAndView.addObject("message", message);

        // 3. 视图跳转
        modelAndView.setViewName("hello");

        return modelAndView;
    }

}
