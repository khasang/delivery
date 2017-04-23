package io.delivery.controller;

import io.delivery.entity.Office;
import io.delivery.service.impl.OfficeServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;

public class OfficeControllerTest {
    @Test
    public void addOffice() throws Exception {
        OfficeServiceImpl officeService = mock(OfficeServiceImpl.class);
        Office office = new Office();
        given(officeService.create(office)).willReturn(office);
        Assert.assertEquals(officeService.create(office), office);
    }

    @Test
    public void deleteOffice() throws Exception {
        OfficeServiceImpl officeService = mock(OfficeServiceImpl.class);
        Office office = new Office();
        given(officeService.delete(1L)).willReturn(office);
        Assert.assertEquals(officeService.delete(1L), office);
    }

    @Test
    public void getOfficeList() throws Exception {
        OfficeServiceImpl officeService = mock(OfficeServiceImpl.class);
        List<Office> list = new ArrayList<>();
        given(officeService.getOfficeList()).willReturn(list);
        Assert.assertEquals(officeService.getOfficeList(), list);
    }
}