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
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteActor(int actorId) {
        // TODO Auto-generated method stub

    }

    @Override
    public Actor findActorById(int actorId) {
        List<Actor> actors = dataSource.loadAllActors();
        for (Actor actor : actors) {
            if (actor.getActorId() == actorId) {
                return actor;
            }
        }
        return null;
    }

    @Override
    public List<Actor> listActor() {
        return dataSource.loadAllActors();
    }

    @Override
    public void updateActor(Actor actor) {
        // TODO Auto-generated method stub

    }
}
