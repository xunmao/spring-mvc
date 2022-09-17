package com.xunmao.demo.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Actor {

    private int actorId;
    private String firstName;
    private String lastName;
    private Date lastUpdate;

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Actor(int actorId, String firstName, String lastName, Date lastUpdate) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Actor [actorId=" + actorId + ", firstName=" + firstName + ", lastName=" + lastName + ", lastUpdate="
                + lastUpdate + "]";
    }

    /**
     * Returns a <code>Actor</code> for testing purpose.
     * 
     * @return Returns a <code>Actor</code> for testing purpose.
     * @throws ParseException
     */
    public static Actor getActorByIdIs1() throws ParseException {

        // 关于 Java 日期时间的用法可以参考：
        // https://www.runoob.com/java/java-date-time.html
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date lastUpdate = simpleDateFormat.parse("2006-02-15 04:34:33");

        return new Actor(1, "PENELOPE", "GUINESS", lastUpdate);
    }
}
