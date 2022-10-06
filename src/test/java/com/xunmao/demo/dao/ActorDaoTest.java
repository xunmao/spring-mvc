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
    public void shouldListActors() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml")) {
            ActorDao actorDao = context.getBean("actorDao", ActorDaoImpl.class);
            actorDao.listActors().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldAddActor() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml")) {
            ActorDao actorDao = context.getBean("actorDao", ActorDaoImpl.class);
            actorDao.addActor(new Actor(11, "firstName", "lastName", new Date()));
            actorDao.listActors().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldUpdateActor() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml")) {
            ActorDao actorDao = context.getBean("actorDao", ActorDaoImpl.class);
            actorDao.updateActor(new Actor(10, "firstName", "lastName", new Date()));
            actorDao.listActors().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldDeleteActor() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml")) {
            ActorDao actorDao = context.getBean("actorDao", ActorDaoImpl.class);
            actorDao.deleteActor(10);
            actorDao.listActors().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldResetActors() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml")) {
            ActorDao actorDao = context.getBean("actorDao", ActorDao.class);
            for (int i = 1; i < 4; i++) {
                actorDao.deleteActor(i);
            }
            System.out.println("删除部分数据: 当前数据量(条): " + actorDao.listActors().size());

            actorDao.resetActors();
            System.out.println("重置数据: 当前数据量(条): " + actorDao.listActors().size());

            actorDao.listActors().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
