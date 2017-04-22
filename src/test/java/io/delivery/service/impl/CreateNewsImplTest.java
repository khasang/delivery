package io.delivery.service.impl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreateNewsImplTest {
    @Test
    public void getQuery() throws Exception {
        CreateNewsImpl createNews = new CreateNewsImpl("query");
        assertNotNull(createNews.getQuery());
        assertEquals("query", createNews.getQuery());
    }

    @Test
    public void setQuery() throws Exception {
        CreateNewsImpl createNews = new CreateNewsImpl();
        createNews.setQuery("query");
        assertNotNull(createNews.getQuery());
        assertEquals("query", createNews.getQuery());
    }

    @Test
    public void createNews() throws Exception {
        CreateNewsImpl createNews = new CreateNewsImpl();
        createNews.setQuery("query");
        assertNotNull(createNews.getQuery());
        assertEquals("query", createNews.createNews());
    }

}