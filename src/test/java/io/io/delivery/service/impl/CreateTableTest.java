package io.io.delivery.service.impl;

import io.delivery.service.impl.CreateTableImpl;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(classes = {AppConfig.class, WebConfig.class, CreateTableImpl.class})

public class CreateTableTest {
//    @Autowired
//    CreateTable createTable;
//
//    @Test
//    public void testDeleteCompany() {
//        CreateTableImpl createTable = new CreateTableImpl();
//        Assert.assertEquals(createTable.delete(), "done");
//    }


    // With use Mockito
    @Test
    public void testDeleteCompany() {
        CreateTableImpl createTable = mock(CreateTableImpl.class);
        given(createTable.delete()).willReturn("done");
        Assert.assertEquals(createTable.delete(), "done");
    }
}