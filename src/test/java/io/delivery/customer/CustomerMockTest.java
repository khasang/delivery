package io.delivery.customer;

import io.delivery.entity.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.BDDMockito;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class CustomerMockTest {

    @Test
    public void testFindCustomerByName() {
        Customer customer = mock(Customer.class);
        given(customer.getName()).willReturn("Иван");
        Assert.assertEquals(customer.getName(), "Иван");
    }
}
