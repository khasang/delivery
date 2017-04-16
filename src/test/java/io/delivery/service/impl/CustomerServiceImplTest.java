package io.delivery.service.impl;

import io.delivery.config.AppConfig;
import io.delivery.config.application.WebConfig;
import io.delivery.entity.Customer;
import io.delivery.service.CustomerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class, WebConfig.class, CustomerServiceImpl.class})
public class CustomerServiceImplTest {
    @Autowired
    private CustomerService customerService;
    private Customer customer_1;
    private Customer customer_2;
    private Customer customer_3;

    @Before
    public void CreateAndInitializeCustomers(){
        customer_1 = new Customer();
        customer_1.setName("customer_1");
        customer_1.setPhoneNumber("+375(11)123-45-67");
        customer_1.setAddress("address of customer_1");
        customer_1.seteMail("customer_1@mail.mail");

        customer_2 = new Customer();
        customer_2.setName("customer_2");
        customer_2.setPhoneNumber("+375(22)123-45-67");
        customer_2.setAddress("address of customer_2");
        customer_2.seteMail("customer_2@mail.mail");

        customer_3 = new Customer();
        customer_3.setName("customer_3");
        customer_3.setPhoneNumber("+375(33)123-45-67");
        customer_3.setAddress("address of customer_3");
        customer_3.seteMail("customer_3@mail.mail");

        customerService.createCustomer(customer_1);
        customerService.createCustomer(customer_2);
        customerService.createCustomer(customer_3);
    }

    @Test
    public void testGetCustomerByName(){
        List<Customer> returnedCustomers = customerService.getCustomerByName(customer_2.getName());
        assertNotNull("List of customers is null",returnedCustomers);
        Customer firstCusromerInList = returnedCustomers.get(0);
        assertEquals("id's not equal", firstCusromerInList.getId(), customer_2.getId());
        assertEquals("names not equal", firstCusromerInList.getName(), customer_2.getName());
        assertEquals("e-mails not equal", firstCusromerInList.geteMail(), customer_2.geteMail());
        assertEquals("addresses not equal", firstCusromerInList.getAddress(), customer_2.getAddress());
    }

    @Test
    public void testGetCustomerByAddress(){
        List<Customer> returnedCustomers = customerService.getCustomerByAddress(customer_3.getAddress());
        assertNotNull("List of customers is null",returnedCustomers);
        Customer firstCusromerInList = returnedCustomers.get(0);
        assertEquals("id's not equal", firstCusromerInList.getId(), customer_3.getId());
        assertEquals("names not equal", firstCusromerInList.getName(), customer_3.getName());
        assertEquals("e-mails not equal", firstCusromerInList.geteMail(), customer_3.geteMail());
        assertEquals("addresses not equal", firstCusromerInList.getAddress(), customer_3.getAddress());
    }

    @Test
    public void testGetCustomerByPhoneNumber(){
        Customer returnedCustomer = customerService.getCustomerByPhoneNumber(customer_1.getPhoneNumber());
        assertNotNull("returnedCustomer is null", returnedCustomer);
        assertEquals("IDs not equal", returnedCustomer.getId(), customer_1.getId());
        assertEquals("names not equal", returnedCustomer.getName(), customer_1.getName());
        assertEquals("e-mails not equal", returnedCustomer.geteMail(), customer_1.geteMail());
        assertEquals("addresses not equal", returnedCustomer.getAddress(), customer_1.getAddress());
    }

    @Test
    public void testGetCustomerByEmail(){
        Customer returnedCustomer = customerService.getCustomerByEmail(customer_2.geteMail());
        assertNotNull("returnedCustomer is null", returnedCustomer);
        assertEquals("IDs not equal", returnedCustomer.getId(), customer_2.getId());
        assertEquals("names not equal", returnedCustomer.getName(), customer_2.getName());
        assertEquals("e-mails not equal", returnedCustomer.geteMail(), customer_2.geteMail());
        assertEquals("addresses not equal", returnedCustomer.getAddress(), customer_2.getAddress());
    }

    @Test
    public void testGetCustomerById(){
        Customer returnedCustomer = customerService.getCustomerById(customer_3.getId());
        assertNotNull("returnedCustomer is null", returnedCustomer);
        assertEquals("IDs not equal", returnedCustomer.getId(), customer_3.getId());
        assertEquals("names not equal", returnedCustomer.getName(), customer_3.getName());
        assertEquals("e-mails not equal", returnedCustomer.geteMail(), customer_3.geteMail());
        assertEquals("addresses not equal", returnedCustomer.getAddress(), customer_3.getAddress());
    }

    @Test
    public void testGetAllCustomers(){
        List<Customer> returnedCustomers = customerService.getAllCustomers();
        assertNotNull("List of customers is null",returnedCustomers);
        Customer lastCusromerInList = returnedCustomers.get(returnedCustomers.size()-1);
        assertNotNull(lastCusromerInList);
        assertEquals("IDs not equal", lastCusromerInList.getId(), customer_3.getId());
        assertEquals("names not equal", lastCusromerInList.getName(), customer_3.getName());
        assertEquals("e-mails not equal", lastCusromerInList.geteMail(), customer_3.geteMail());
        assertEquals("addresses not equal", lastCusromerInList.getAddress(), customer_3.getAddress());
    }

    @Test
    public void testUpdateCustomer(){
        Customer beforeUpdateCustomer = customer_1;
        beforeUpdateCustomer.setName("updated_customer");
        beforeUpdateCustomer.setAddress("new address of updated_customer");
        beforeUpdateCustomer.seteMail("updated_customer@mail.mail");
        Customer afterUpdateCustomer = customerService.updateCustomer(beforeUpdateCustomer);
        assertNotNull(afterUpdateCustomer);
        assertEquals("IDs not equal", beforeUpdateCustomer.getId(), afterUpdateCustomer.getId());
        assertEquals("names not equal", beforeUpdateCustomer.getName(), afterUpdateCustomer.getName());
        assertEquals("e-mails not equal", beforeUpdateCustomer.geteMail(), afterUpdateCustomer.geteMail());
        assertEquals("addresses not equal", beforeUpdateCustomer.getAddress(), afterUpdateCustomer.getAddress());

    }

    @After
    public void deleteCreatedCustomers(){
        customerService.deleteCustomer(customer_1.getId());
        customerService.deleteCustomer(customer_2.getId());
        customerService.deleteCustomer(customer_3.getId());
    }

}
