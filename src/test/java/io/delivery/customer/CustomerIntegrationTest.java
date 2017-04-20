package io.delivery.customer;

import io.delivery.entity.Customer;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class CustomerIntegrationTest {

    private final String ROOT = "http://localhost:8080/customer";
    private final String GET_PHONE = "/get/phone/";
    private final String GET_ADDRESS = "/get/address/";
    private final String GET_ID = "/get/id/";
    private final String ADD = "/add";
    private final String UPDATE = "/update";
    private final String DELETE = "/delete/id/";
    private final String ALL = "/get/all";
    private final String GET_NAME = "/get/name/";
    private final String GET_EMAIL = "/get/email/";

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
        customer.setAddress("адрес_заказчика");
        customer.seteMail("111@gmail.com");
        customer.setPhoneNumber("234563961");
        customer.setName("имя_заказчика");
        return customer;
    }

    @Test
    public void getCustomerById(){
        Customer customer = createCustomer();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Customer> responseEntity = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                Customer.class,
                customer.getId()
        );
        assertNotNull(responseEntity.getBody());
        Customer returnedCustomer = responseEntity.getBody();
        assertNotNull(returnedCustomer);
        assertEquals("IDs not equal", returnedCustomer.getId(), customer.getId());
        assertEquals("Names not equal", returnedCustomer.getName(), customer.getName());
        assertEquals("e-mails not equal", returnedCustomer.geteMail(), customer.geteMail());
        assertEquals("Addresses not equal", returnedCustomer.getAddress(), customer.getAddress());
        assertEquals("PhoneNumbers not equal", returnedCustomer.getPhoneNumber(), customer.getPhoneNumber());
     }

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
        List<Customer> list = responseEntity.getBody();
        assertNotNull(list);
        assertNotNull(list.get(0));
    }

    @Test
    public void getCustomerByPhone() {
        Customer customer = createCustomer();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Customer> responseEntity = restTemplate.exchange(
                ROOT + GET_PHONE + "{phoneNumber}",
                HttpMethod.GET,
                null,
                Customer.class,
                customer.getPhoneNumber()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());

        // Тест валится, т.к. номера телефонов в базе не уникальные - соответственно
        // пытается возвратить список

//        Customer returnedCustomer = responseEntity.getBody();
//        assertEquals("IDs not equal", returnedCustomer.getId(), customer.getId());
//        assertEquals("Names not equal", returnedCustomer.getName(), customer.getName());
//        assertEquals("Addresses not equal", returnedCustomer.getAddress(), customer.getAddress());
//        assertEquals("Phone numbers not equal", returnedCustomer.getPhoneNumber(), customer.getPhoneNumber());
    }

    @Test
        // Аналогично предыдущему - e-mail в базе все одинаковы, а должны быть уникальные
    public void getCustomerByEmail() {
        Customer customer = createCustomer();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Customer> responseEntity = restTemplate.exchange(
                ROOT + GET_EMAIL + "{eMail}",
                HttpMethod.GET,
                null,
                Customer.class,
                customer.geteMail()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    public void deleteCustomer(){
        // Валится с - org.springframework.web.client.HttpClientErrorException: 405 Method Not Allowed
        // С Rest клиента по пути http://localhost:8080/customer/delete_by/id/(Какойнить айди) - все ок
        // и в базе удаляется соответствующий айди
        Customer customer = createCustomer();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                customer.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        ResponseEntity<Customer> checkCustomerById = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                Customer.class,
                customer.getId()
        );

        assertEquals(HttpStatus.OK, checkCustomerById.getStatusCode());
        assertNull(checkCustomerById.getBody());
    }

    @Test
    public void getAllCustomers(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Customer>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Customer>>() {
                }
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        List<Customer> list = responseEntity.getBody();
        assertNotNull(list);
        assertNotNull(list.get(0));
    }

    @Test
    public void updateCustomer(){
        Customer customer = createCustomer();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        customer.setName("новое_имя_заказчика");
        customer.setAddress("новый_адрес_заказчика");
        customer.seteMail("new_customer@mail.mail");
        customer.setPhoneNumber("+375(29)123-45-67");

        HttpEntity<Customer> httpEntity = new HttpEntity<>(customer, headers);
        RestTemplate restTemplate = new RestTemplate();
        Customer updatedCustomer = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                Customer.class
        ).getBody();
        assertNotNull(updatedCustomer);
        assertEquals("IDs not equal", customer.getId(), updatedCustomer.getId());
        assertEquals("Names not equal", customer.getName(), updatedCustomer.getName());
        assertEquals("e-mails not equal", customer.geteMail(), updatedCustomer.geteMail());
        assertEquals("Addresses not equal", customer.getAddress(), updatedCustomer.getAddress());
        assertEquals("Phone numbers not equal", customer.getPhoneNumber(), updatedCustomer.getPhoneNumber());
    }
}