package com.xunmao.demo.service;

import java.util.Date;

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

    @Test
    public void shouldAddActor() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml")) {
            ActorService actorService = context.getBean("actorService", ActorServiceImpl.class);
            actorService.addActor(new Actor(11, "TESTFN", "TESTLN", new Date()));
            actorService.listActors().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldUpdateActor() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml")) {
            ActorService actorService = context.getBean("actorService", ActorServiceImpl.class);
            actorService.updateActor(new Actor(10, "TESTFN", "TESTLN", new Date()));
            actorService.listActors().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldDeleteActor() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml")) {
            ActorService actorService = context.getBean("actorService", ActorServiceImpl.class);
            actorService.deleteActor(10);
            actorService.listActors().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldResetActors() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml")) {
            ActorService actorService = context.getBean("actorService", ActorService.class);
            for (int i = 1; i < 4; i++) {
                actorService.deleteActor(i);
            }
            System.out.println("删除部分数据: 当前数据量(条): " + actorService.listActors().size());

            actorService.resetActors();
            System.out.println("重置数据: 当前数据量(条): " + actorService.listActors().size());

            actorService.listActors().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
