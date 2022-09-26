package com.xunmao.demo.controller;

import java.util.List;

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

    @GetMapping("/v1/actors")
    public String listActor(Model model) {
        List<Actor> actors = actorService.listActors();
        model.addAttribute("actors", actors);
        return "actor";
    }

    @GetMapping("/v1/actor/{id}")
    public String findActorById(@PathVariable Integer id, Model model) {
        Actor actor = actorService.findActorById(id);
        if (actor != null) {
            model.addAttribute("result", actor);
        } else {
            model.addAttribute("result", "Not Found");
        }
        return "actor";
    }
}
