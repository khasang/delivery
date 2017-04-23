package io.delivery.model.impl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NewsCreatorImplTest {
    @Test
    public void createNews() throws Exception {
        NewsCreatorImpl newsCreator = new NewsCreatorImpl();
        assertEquals("table created", newsCreator.createNews());
    }

}