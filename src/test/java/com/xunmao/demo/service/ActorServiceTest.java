package com.xunmao.demo.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xunmao.demo.pojo.Actor;
import com.xunmao.demo.service.impl.ActorServiceImpl;

public class ActorServiceTest {

    @Test
    public void shouldFindActorById() {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        ActorService actorService = context.getBean("actorService", ActorServiceImpl.class);
        Actor actor = actorService.findActorById(1);
        System.out.println(actor);
    }
}
