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

    @Test
    public void testFindCustomerByAddress() {
        Customer customer = mock(Customer.class);
        given(customer.getAddress()).willReturn("улица Никифорова 87");
        Assert.assertEquals(customer.getAddress(), "улица Никифорова 87");
    }

    @Test
    public void testFindCustomerByEmail() {
        Customer customer = mock(Customer.class);
        given(customer.geteMail()).willReturn("1@gmail.com");
        Assert.assertEquals(customer.geteMail(), "1@gmail.com");
    }

    @Test
    public void testFindCustomerByPhone() {
        Customer customer = mock(Customer.class);
        given(customer.getPhoneNumber()).willReturn("123456789");
        Assert.assertEquals(customer.getPhoneNumber(), "123456789");
    }

}
