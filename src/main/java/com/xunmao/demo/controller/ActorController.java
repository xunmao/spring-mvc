package com.xunmao.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xunmao.demo.pojo.Actor;
import com.xunmao.demo.service.ActorService;

@Controller
public class ActorController {

    @Autowired
    ActorService actorService;

    @GetMapping("/v1/actor/{id}")
    public String findActorById(@PathVariable Integer id, Model model) {

        model.addAttribute("parameter", "Path parameter is " + id);
        if (id == 1) {
            Actor actor = actorService.findActorById(id);
            model.addAttribute("result", actor);
        } else {
            model.addAttribute("result", "Not Found.");
        }

        return "actor";
    }
}
