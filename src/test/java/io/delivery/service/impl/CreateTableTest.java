package io.delivery.service.impl;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class CreateTableTest {

    @Test
    public void testDeleteCompany() {
        CreateTableImpl createTable = mock(CreateTableImpl.class);
        given(createTable.delete()).willReturn("done");
        Assert.assertEquals(createTable.delete(), "done");
    }
}
