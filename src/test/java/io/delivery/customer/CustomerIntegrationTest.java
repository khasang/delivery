package io.delivery.customer;

import io.delivery.entity.Customer;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CustomerIntegrationTest {

    private final String ROOT = "http://localhost:8080/customer";
    private final String GET_PHONE = "/get_by/phone-number/";
    private final String GET_ADDRESS = "/get_by/address/";
    private final String GET_ID = "/get/id/";
    private final String ADD = "/add";
    private final String UPDATE = "/update";
    private final String DELETE = "/delete_by/id/";
    private final String ALL = "/get/all";
    private final String GET_NAME = "/get_by/name/";
    private final String GET_EMAIL = "/get_by/e-mail/";

    @Test
    public void getCustomerByName() {
        Customer customer = createCustomer();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Customer>> responseEntity = restTemplate.exchange(
                ROOT + GET_NAME + "{name}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Customer>>() {
                },
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
        customer.setAddress("minsk");
        customer.seteMail("1@gmail.com");
        customer.setPhoneNumber("2345639");
        customer.setName("Ivan");
        return customer;
    }

    @Test
    public void getCustomerByAddress() {
        Customer customer = createCustomer();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Customer>> responseEntity = restTemplate.exchange(
                ROOT + GET_ADDRESS + "{address}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Customer>>() {
                },
                customer.getAddress()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        List<Customer> list2 = responseEntity.getBody();
        assertNotNull(list2);
        assertNotNull(list2.get(0));
    }

    @Test
    public void getCustomerByPhone() {
        Customer customer = createCustomer();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Customer>> responseEntity = restTemplate.exchange(
                ROOT + GET_PHONE + "{phoneNumber}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Customer>>() {
                },
                customer.getPhoneNumber()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        List<Customer> list3 = responseEntity.getBody();
        assertNotNull(list3);
        assertNotNull(list3.get(0));
    }

    @Test
    public void getCustomerByEmail() {
        Customer customer = createCustomer();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Customer>> responseEntity = restTemplate.exchange(
                ROOT + GET_EMAIL + "{eMail}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Customer>>() {
                },
                customer.geteMail()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        List<Customer> list4 = responseEntity.getBody();
        assertNotNull(list4);
        assertNotNull(list4.get(0));
    }
}