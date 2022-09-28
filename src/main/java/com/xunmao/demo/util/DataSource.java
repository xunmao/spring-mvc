package com.xunmao.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xunmao.demo.pojo.Actor;

public class DataSource {

    private ArrayList<Actor> actors = new ArrayList<>();

    public DataSource() {
        // 关于 Java 日期时间的用法可以参考：
        // https://www.runoob.com/java/java-date-time.html
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date lastUpdate = simpleDateFormat.parse("2006-02-15 04:34:33");
            Actor actor01 = new Actor(1, "PENELOPE", "GUINESS", lastUpdate);
            Actor actor02 = new Actor(2, "PENELOPE", "GUINESS", lastUpdate);
            Actor actor03 = new Actor(3, "PENELOPE", "GUINESS", lastUpdate);
            Actor actor04 = new Actor(4, "PENELOPE", "GUINESS", lastUpdate);
            Actor actor05 = new Actor(5, "PENELOPE", "GUINESS", lastUpdate);
            Actor actor06 = new Actor(6, "PENELOPE", "GUINESS", lastUpdate);
            Actor actor07 = new Actor(7, "PENELOPE", "GUINESS", lastUpdate);
            Actor actor08 = new Actor(8, "PENELOPE", "GUINESS", lastUpdate);
            Actor actor09 = new Actor(9, "PENELOPE", "GUINESS", lastUpdate);
            Actor actor10 = new Actor(10, "PENELOPE", "GUINESS", lastUpdate);
            actors.add(actor01);
            actors.add(actor02);
            actors.add(actor03);
            actors.add(actor04);
            actors.add(actor05);
            actors.add(actor06);
            actors.add(actor07);
            actors.add(actor08);
            actors.add(actor09);
            actors.add(actor10);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<Actor> getActors() {
        return actors;
    }
}
