package io.delivery.service.impl;

import io.delivery.dao.impl.OfficeDaoImpl;
import io.delivery.entity.Office;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;

public class OfficeServiceImplTest {
    @Test
    public void create() throws Exception {
        OfficeDaoImpl officeDao = mock(OfficeDaoImpl.class);
        Office office = new Office();
        given(officeDao.create(office)).willReturn(office);
        Assert.assertEquals(officeDao.create(office), office);
    }

    @Test
    public void getOfficeList() throws Exception {
        OfficeDaoImpl officeDao = mock(OfficeDaoImpl.class);
        List<Office> list = new ArrayList<>();
        given(officeDao.getList()).willReturn(list);
        Assert.assertEquals(officeDao.getList(), list);
    }

    @Test
    public void delete() throws Exception {
        OfficeDaoImpl officeDao = mock(OfficeDaoImpl.class);
        Office office = new Office();
        given(officeDao.delete(office)).willReturn(office);
        Assert.assertEquals(officeDao.delete(office), office);
    }

    @Test
    public void findById() throws Exception {
        OfficeDaoImpl officeDao = mock(OfficeDaoImpl.class);
        Office office = new Office();
        given(officeDao.findById(1L)).willReturn(office);
        Assert.assertEquals(officeDao.findById(1L), office);
    }
}