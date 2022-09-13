package com.xunmao.demo.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1. 获取参数 user
        String user = req.getParameter("user");

        // 2. 业务逻辑
        // 2.1. 设置 title
        req.setAttribute("user", user);
        // 2.2. 设置 h1
        Date currentTime = new Date(System.currentTimeMillis());
        String message = String.format("Hi, %s! Current Time is %s", user, currentTime);
        req.setAttribute("message", message);

        // 3. 视图跳转
        req.getRequestDispatcher("/WEB-INF/hello.jsp").forward(req, resp);
    }
}
