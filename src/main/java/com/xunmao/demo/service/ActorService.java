package com.xunmao.demo.service;

import java.util.List;

import com.xunmao.demo.pojo.Actor;

public interface ActorService {

    public List<Actor> listActors();

    public Actor findActorById(int actorId);

    public void addActor(Actor actor);

    public void updateActor(Actor actor);

    public void deleteActor(int actorId);

    public void resetActors();
}
