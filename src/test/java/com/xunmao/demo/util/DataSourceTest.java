package com.xunmao.demo.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DataSourceTest {

    @Test
    public void shouldGetAllActors() {
        DataSource dataSource = new DataSource();
        System.out.println("加载数据: 当前数据量(条): " + dataSource.getActors().size());
        dataSource.getActors().forEach(System.out::println);
    }

    @Test
    public void shouldResetAllActors() {
        DataSource dataSource = new DataSource();
        System.out.println("加载数据: 当前数据量(条): " + dataSource.getActors().size());

        dataSource.getActors().clear();
        System.out.println("清空数据: 当前数据量(条): " + dataSource.getActors().size());

        dataSource.resetActors();
        System.out.println("重置数据: 当前数据量(条): " + dataSource.getActors().size());

        dataSource.getActors().forEach(System.out::println);
    }

    @Test
    public void shouldResetOnlyOnce() {
        DataSource dataSource = new DataSource();
        System.out.println("加载数据: 当前数据量(条): " + dataSource.getActors().size());

        dataSource.getActors().clear();
        System.out.println("清空数据: 当前数据量(条): " + dataSource.getActors().size());

        dataSource.resetActors();
        System.out.println("重置数据_第一次: 当前数据量(条): " + dataSource.getActors().size());

        dataSource.resetActors();
        System.out.println("重置数据_第二次: 当前数据量(条): " + dataSource.getActors().size());

        dataSource.getActors().forEach(System.out::println);
    }

    @Test
    public void shouldGetUser() {
        DataSource dataSource = new DataSource();
        System.out.println("加载数据: 当前用户量(条): " + dataSource.getUsers().size());

        assertEquals("xunmao", dataSource.getUsers().get(1).getUsername());
        assertEquals("19890706", dataSource.getUsers().get(1).getPassword());
    }
}
