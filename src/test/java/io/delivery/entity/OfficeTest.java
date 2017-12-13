package io.delivery.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class OfficeTest {
    private final long id = 123L;
    private final String address = "testAddress";
    private final String coords = "testCoords";
    private final String description = "testDescription";

    private Office createOffice() {
        final Office office = new Office();
        office.setAddress(this.address);
        office.setCoords(this.coords);
        office.setId(this.id);
        office.setDescription(this.description);
        return office;
    }

    @Test
    public void getId() throws Exception {
        final Office office = createOffice();
        long id = office.getId();
        assertEquals(this.id, id);
    }

    @Test
    public void setId() throws Exception {
        final Office office = createOffice();
        long testId = 555L;
        office.setId(testId);
        long id = office.getId();
        assertEquals(testId, id);
    }

    @Test
    public void getAddress() throws Exception {
        final Office office = createOffice();
        String address = office.getAddress();
        assertEquals(this.address, address);
    }

    @Test
    public void setAddress() throws Exception {
        final Office office = createOffice();
        String testAddress = "newAddress";
        office.setAddress(testAddress);
        String address = office.getAddress();
        assertEquals(testAddress, address);
    }

    @Test
    public void getCoords() throws Exception {
        final Office office = createOffice();
        String coords = office.getCoords();
        assertEquals(this.coords, coords);
    }

    @Test
    public void setCoords() throws Exception {
        final Office office = createOffice();
        String testCoords = "newCoords";
        office.setCoords(testCoords);
        String coords = office.getCoords();
        assertEquals(testCoords, coords);
    }

    @Test
    public void getDescription() throws Exception {
        final Office office = createOffice();
        String description = office.getDescription();
        assertEquals(this.description, description);
    }

    @Test
    public void setDescription() throws Exception {
        final Office office = createOffice();
        String testDescription = "newDescription";
        office.setDescription(testDescription);
        String description = office.getDescription();
        assertEquals(testDescription, description);
    }
}