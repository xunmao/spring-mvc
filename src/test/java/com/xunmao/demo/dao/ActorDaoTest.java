package com.xunmao.demo.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xunmao.demo.dao.impl.ActorDaoImpl;
import com.xunmao.demo.pojo.Actor;

public class ActorDaoTest {

    @Test
    public void shouldFindActorById() {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        ActorDao actorDao = context.getBean("actorDao", ActorDaoImpl.class);
        Actor actor = actorDao.findActorById(1);
        System.out.println(actor);
    }
}
