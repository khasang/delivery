package io.delivery.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class NewsTest {
    @Test
    public void getId() throws Exception {
        News news = new News();
        news.setId(1);
        assertEquals(1, news.getId());
        assertNotNull(news.getId());
    }

    @Test
    public void setId() throws Exception {
        News news = new News();
        news.setId(1L);
        assertNotNull(news.getId());
        assertEquals(1L, news.getId());
    }

    @Test
    public void getName() throws Exception {
        News news = new News();
        news.setName("name");
        assertNotNull(news.getName());
        assertEquals("name", news.getName());
    }

    @Test
    public void setName() throws Exception {
        News news = new News();
        news.setName("name");
        assertNotNull(news.getName());
        assertEquals("name", news.getName());
    }

}