package io.khasang.document;


import io.delivery.entity.Customer;
import io.delivery.entity.Document;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CustomerIntegrationTest {
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

    @Test
    public void


}
