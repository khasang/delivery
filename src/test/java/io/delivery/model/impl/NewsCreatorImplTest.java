package io.delivery.model.impl;

import org.junit.Assert;
import org.junit.Test;

public class NewsCreatorImplTest {
    @Test
    public void createNews() throws Exception {
        NewsCreatorImpl newsCreator = new NewsCreatorImpl();
        Assert.assertEquals("table created", newsCreator.createNews());
    }

}