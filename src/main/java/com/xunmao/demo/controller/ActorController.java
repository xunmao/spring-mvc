package com.xunmao.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.xunmao.demo.pojo.Actor;
import com.xunmao.demo.service.ActorService;

@Controller
public class ActorController {

    @Autowired
    ActorService actorService;

    @GetMapping("/v1/actors")
    public String listActors(Model model) {
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

    @PostMapping("/v1/actors")
    public String resetActors(Model model) {
        actorService.resetActors();

        List<Actor> actors = actorService.listActors();
        model.addAttribute("actors", actors);
        return "actor";
    }

    // Tomcat 版本高于8之后，在使用 JSP 时不能使用 DELETE 等方法，否则会报错：
    // “JSP 只允许 GET、POST 或 HEAD。Jasper 还允许 OPTIONS”
    // 因此，v1（JSP）版本中使用 POST 方法，在 v2（Restful API）版本中使用 DELETE 方法
    @PostMapping("/v1/delete/actor/{id}")
    public String deleteActor(@PathVariable Integer id, Model model) {
        actorService.deleteActor(id);

        List<Actor> actors = actorService.listActors();
        model.addAttribute("actors", actors);
        return "actor";
    }
}
