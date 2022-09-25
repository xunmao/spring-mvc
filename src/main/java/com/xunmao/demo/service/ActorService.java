package com.xunmao.demo.service;

import java.util.List;

import com.xunmao.demo.pojo.Actor;

public interface ActorService {

    public List<Actor> listActors();

    public Actor findActorById(int actorId);
}
