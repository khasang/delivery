package io.delivery.entity;

import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class NoRegistratioinCustomerIntegrationTest {
    private final String ROOT = "http://localhost:8080/noregcustomer";
    private final String ALL = "/all";
    private final String GET_NAME = "/get/name/";
    private final String ADD = "/add";
    private final String UPDATE = "/update";
    private final String DELETE = "/delete/";
    private final String GET_ID = "/get/id/";

    private NoRegistrationCustomer createNoRegistrationCustomer() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        NoRegistrationCustomer noRegistrationCustomer = prefillNoRegistrationCustomer();
        HttpEntity<NoRegistrationCustomer> entity = new HttpEntity<>(noRegistrationCustomer, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        NoRegistrationCustomer createdNoRegCustomer = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                NoRegistrationCustomer.class
        ).getBody();
        assertNotNull(createdNoRegCustomer);
        assertEquals(noRegistrationCustomer.getName(), createdNoRegCustomer.getName());
        return createdNoRegCustomer;
     }

    private NoRegistrationCustomer prefillNoRegistrationCustomer() {
        NoRegistrationCustomer noRegistrationCustomer = new NoRegistrationCustomer();
        noRegistrationCustomer.setAddress("NN");
        noRegistrationCustomer.setName("Bob");
        noRegistrationCustomer.setPhoneNumber("123");
        return noRegistrationCustomer;
    }

    @Test
    public void getAllNoRegistrationCustomer(){
        RestTemplate restTemplate = new RestTemplate();
        createNoRegistrationCustomer();
        createNoRegistrationCustomer();

        ResponseEntity<List<NoRegistrationCustomer>> result = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<NoRegistrationCustomer>>() {
                }
        );
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        List<NoRegistrationCustomer> list = result.getBody();
        assertNotNull(list.get(0));
    }
}
