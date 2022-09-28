package com.xunmao.demo.dao;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xunmao.demo.dao.impl.ActorDaoImpl;
import com.xunmao.demo.pojo.Actor;

public class ActorDaoTest {

    @Test
    public void shouldFindActorById() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml")) {
            ActorDao actorDao = context.getBean("actorDao", ActorDaoImpl.class);
            Actor actor = actorDao.findActorById(1);
            System.out.println(actor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldListActor() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml")) {
            ActorDao actorDao = context.getBean("actorDao", ActorDaoImpl.class);
            actorDao.listActor().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldAddActor() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml")) {
            ActorDao actorDao = context.getBean("actorDao", ActorDaoImpl.class);
            actorDao.addActor(new Actor(11, "firstName", "lastName", new Date()));
            actorDao.listActor().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldUpdateActor() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml")) {
            ActorDao actorDao = context.getBean("actorDao", ActorDaoImpl.class);
            actorDao.updateActor(new Actor(10, "firstName", "lastName", new Date()));
            actorDao.listActor().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldDeleteActor() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml")) {
            ActorDao actorDao = context.getBean("actorDao", ActorDaoImpl.class);
            actorDao.deleteActor(10);
            actorDao.listActor().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
