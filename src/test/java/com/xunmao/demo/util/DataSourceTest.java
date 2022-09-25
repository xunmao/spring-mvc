package com.xunmao.demo.util;

import org.junit.Test;

public class DataSourceTest {

    @Test
    public void shouldGetAllActors() {
        DataSource dataSource = new DataSource();
        dataSource.loadAllActors().forEach(System.out::println);
    }
}
