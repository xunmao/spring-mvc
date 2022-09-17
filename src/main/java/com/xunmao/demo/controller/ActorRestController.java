package com.xunmao.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson2.JSON;
import com.xunmao.demo.pojo.Actor;

@RestController
public class ActorRestController {

    @GetMapping("/v2/actor/{id}")
    public String findActorById(@PathVariable Integer id) {

        try {
            Actor actor = Actor.getActorByIdIs1();
            String response;
            if (id == 1) {
                response = JSON.toJSONString(actor);
            } else {
                response = "Not Found.";
            }
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}
