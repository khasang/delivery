package io.delivery.service.impl;

import org.junit.Assert;
import org.junit.Test;

public class CreateNewsImplTest {
    @Test
    public void getQuery() throws Exception {
        CreateNewsImpl createNews = new CreateNewsImpl("query");
        Assert.assertNotNull(createNews.getQuery());
        Assert.assertEquals("query", createNews.getQuery());
    }

    @Test
    public void setQuery() throws Exception {
        CreateNewsImpl createNews = new CreateNewsImpl();
        createNews.setQuery("query");
        Assert.assertNotNull(createNews.getQuery());
        Assert.assertEquals("query", createNews.getQuery());
    }

    @Test
    public void createNews() throws Exception {
        CreateNewsImpl createNews = new CreateNewsImpl();
        createNews.setQuery("query");
        Assert.assertNotNull(createNews.getQuery());
        Assert.assertEquals("query", createNews.createNews());
    }

}