package com.xunmao.demo.dao;

import java.util.List;

import com.xunmao.demo.pojo.Actor;

public interface ActorDao {

    public List<Actor> listActors();

    public void resetActors();

    public Actor findActorById(int actorId);

    public void addActor(Actor actor);

    public void updateActor(Actor actor);

    public void deleteActor(int actorId);
}
