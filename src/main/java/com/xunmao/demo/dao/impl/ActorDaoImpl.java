package com.xunmao.demo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xunmao.demo.dao.ActorDao;
import com.xunmao.demo.pojo.Actor;
import com.xunmao.demo.util.DataSource;

public class ActorDaoImpl implements ActorDao {

    @Autowired
    DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addActor(Actor actor) {
        dataSource.getActors().add(actor);
    }

    @Override
    public void deleteActor(int actorId) {
        List<Actor> actors = dataSource.getActors();
        for (Actor actor : actors) {
            if (actor.getActorId() == actorId) {
                dataSource.getActors().remove(actor);
                return;
            }
        }
    }

    @Override
    public Actor findActorById(int actorId) {
        List<Actor> actors = dataSource.getActors();
        for (Actor actor : actors) {
            if (actor.getActorId() == actorId) {
                return actor;
            }
        }
        return null;
    }

    @Override
    public List<Actor> listActor() {
        return dataSource.getActors();
    }

    @Override
    public void updateActor(Actor newActor) {
        List<Actor> actors = dataSource.getActors();
        for (Actor actor : actors) {
            if (actor.getActorId() == newActor.getActorId()) {
                actor.setFirstName(newActor.getFirstName());
                actor.setLastName(newActor.getLastName());
                actor.setLastUpdate(newActor.getLastUpdate());
                return;
            }
        }
    }
}
