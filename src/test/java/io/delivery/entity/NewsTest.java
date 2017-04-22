package io.delivery.entity;

import org.junit.Assert;
import org.junit.Test;

public class NewsTest {
    @Test
    public void getId() throws Exception {
        News news = new News();
        news.setId(1);
        Assert.assertEquals(1, news.getId());
        Assert.assertNotNull(news.getId());
    }

    @Test
    public void setId() throws Exception {
        News news = new News();
        news.setId(1L);
        Assert.assertNotNull(news.getId());
        Assert.assertEquals(1L, news.getId());
    }

    @Test
    public void getName() throws Exception {
        News news = new News();
        news.setName("name");
        Assert.assertNotNull(news.getName());
        Assert.assertEquals("name", news.getName());
    }

    @Test
    public void setName() throws Exception {
        News news = new News();
        news.setName("name");
        Assert.assertNotNull(news.getName());
        Assert.assertEquals("name", news.getName());
    }

}