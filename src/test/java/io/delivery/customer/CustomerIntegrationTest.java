package io.delivery.customer;

import io.delivery.entity.Customer;
import io.delivery.service.CustomerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class CustomerIntegrationTest {
//    @Autowired
//    private CustomerService customerService;

    private final String ROOT = "http://localhost:8080/customer";
    private final String GET_MAIL = "/get_by/e-mail/";
    private final String GET_PHONE = "/get_by/phone-number/";
    private final String GET_ADDRESS = "/get_by/address/";
    private final String GET_ID = "/get/id/";
    private final String ADD = "/add";
    private final String UPDATE = "/update";
    private final String DELETE = "/delete_by/id/";
    private final String ALL = "/get/all";
    private final String GET_NAME = "/get_by/name/";


//    @Test
//    public void addDocumentAndGet() {              // тест на добавление документа
//        Customer customer = createCustomer();
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        ResponseEntity<Customer> responseEntity = restTemplate.exchange(
//                ROOT + GET_ID + "{id}",
//                HttpMethod.GET,
//                null,
//                Customer.class,
//                customer.getId()
//        );
//
//        Customer resultCustomer = responseEntity.getBody();
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertNotNull(resultCustomer);
//    }


    @Test
    public void getCustomerByName() {
        Customer customer = createCustomer();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Customer>> responseEntity = restTemplate.exchange(
                ROOT + GET_NAME + "{name}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Customer>>() {},
                customer.getName()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        List<Customer> list = responseEntity.getBody();
        assertNotNull(list);
        assertNotNull(list.get(0));
    }


    private Customer createCustomer() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Customer customer = prefillCustomer();
        HttpEntity<Customer> httpEntity = new HttpEntity<>(customer, headers);
        RestTemplate restTemplate = new RestTemplate();
        Customer createdCustomer = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Customer.class
        ).getBody();
        assertNotNull(createdCustomer);
        assertEquals(customer.getName(), createdCustomer.getName());
        return createdCustomer;
    }

    private Customer prefillCustomer() {
        Customer customer = new Customer();
//        customerService.createCustomer(customer);
//        customer.getName();
//        customer.getAddress();
//        customer.geteMail();
//        customer.getPhoneNumber();
        customer.setAddress("minsk");
        customer.seteMail("1@gmail.com");
        customer.setPhoneNumber("2345639");
        customer.setName("Ivan");
        return customer;
    }

}