package com.xunmao.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson2.JSON;
import com.xunmao.demo.pojo.Actor;
import com.xunmao.demo.service.ActorService;

@RestController
public class ActorRestController {

    @Autowired
    ActorService actorService;

    @GetMapping("/v2/actors")
    public String listActor() {
        List<Actor> actors = actorService.listActors();
        return JSON.toJSONString(actors);
    }

    @GetMapping("/v2/actor/{id}")
    public String findActorById(@PathVariable Integer id) {
        Actor actor = actorService.findActorById(id);
        if (actor != null) {
            return JSON.toJSONString(actor);
        } else {
            return "Not Found";
        }
    }
}
