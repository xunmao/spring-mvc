package com.xunmao.demo.controller.v1;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloAnnotationController {

    @RequestMapping("/hello")
    public String hello(String username, Model model) {

        // 2. 根据业务逻辑，将数据放入 ModelAndView 的实例中

        // 2.1. 通过方法参数 user 获取同名查询参数
        // https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-requestheader
        // Note that use of @RequestParam is optional (for example, to set its
        // attributes). By default, any argument that is a simple value type (as
        // determined by BeanUtils#isSimpleProperty) and is not resolved by any other
        // argument resolver, is treated as if it were annotated with @RequestParam.

        if (username == null || username.equals("")) {
            model.addAttribute("title", "Please sign in");
            model.addAttribute("message", "Please sign in");
        } else {
            // 2.2. 设置 title
            model.addAttribute("title", "Hello, " + username);

            // 2.2. 设置 h1
            Date currentTime = new Date(System.currentTimeMillis());
            String message = String.format("Hi, %s! Current Time is %s", username, currentTime);
            model.addAttribute("message", message);
        }

        // 3. 视图跳转
        return "hello";
    }
}
