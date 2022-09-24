package com.xunmao.demo.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.xunmao.demo.dao.ActorDao;
import com.xunmao.demo.pojo.Actor;

public class ActorDaoImpl implements ActorDao {

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
        // 关于 Java 日期时间的用法可以参考：
        // https://www.runoob.com/java/java-date-time.html
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date lastUpdate = simpleDateFormat.parse("2006-02-15 04:34:33");
            return new Actor(1, "PENELOPE", "GUINESS", lastUpdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Actor> listActor() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateActor(Actor actor) {
        // TODO Auto-generated method stub

    }
}
