package com.xunmao.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.xunmao.demo.dao.ActorDao;
import com.xunmao.demo.pojo.Actor;
import com.xunmao.demo.service.ActorService;

public class ActorServiceImpl implements ActorService {

    @Autowired
    ActorDao actorDao;

    public void setActorDao(ActorDao actorDao) {
        this.actorDao = actorDao;
    }

    @Override
    public Actor findActorById(int actorId) {

        return actorDao.findActorById(actorId);
    }
}
