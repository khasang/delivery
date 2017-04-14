package io.delivery.service.impl;

import io.delivery.config.AppConfig;
import io.delivery.config.application.WebConfig;
import io.delivery.service.CreateTable;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class, WebConfig.class, CreateTableImpl.class})
public class CreateTableTest {
    @Autowired
    CreateTable createTable;

    @Test
    public void testDeleteCompany() {
        CreateTableImpl createTable = new CreateTableImpl();
        Assert.assertEquals(createTable.delete(), "done");
    }
}
