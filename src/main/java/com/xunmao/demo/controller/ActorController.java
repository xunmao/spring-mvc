package com.xunmao.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xunmao.demo.pojo.Actor;

@Controller
public class ActorController {

    @GetMapping("/v1/actor/{id}")
    public String findActorById(@PathVariable Integer id, Model model) {

        try {
            Actor actor = Actor.getActorByIdIs1();
            model.addAttribute("parameter", "Path parameter is " + id);
            if (id == 1) {
                model.addAttribute("result", actor);
            } else {
                model.addAttribute("result", "Not Found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "actor";
    }
}
