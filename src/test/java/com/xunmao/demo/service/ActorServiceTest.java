package com.xunmao.demo.service;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xunmao.demo.pojo.Actor;
import com.xunmao.demo.service.impl.ActorServiceImpl;

public class ActorServiceTest {

    @Test
    public void shouldFindActorById() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml")) {
            ActorService actorService = context.getBean("actorService", ActorServiceImpl.class);
            Actor actor = actorService.findActorById(1);
            System.out.println(actor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldListActors() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml")) {
            ActorService actorService = context.getBean("actorService", ActorServiceImpl.class);
            actorService.listActors().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
