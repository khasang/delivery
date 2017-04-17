package io.khasang.order;

import io.delivery.entity.BasketUnit;
import io.delivery.entity.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OrderIntegrationTest {

    private final String ROOT = "http://localhost:8080/order";
    private final String GET_ID = "/get/id/";
    private final String ADD = "/add";
    private final String UPDATE = "/update";
    private final String DELETE = "/delete/";
    private final String ALL = "/all";
    private final String GET_NAME = "/get/name/";

    private static List<BasketUnit> basketUnits = new ArrayList<>();

    @Before
    public void setUp() {
        basketUnits.add(new BasketUnit(20L));
        basketUnits.add(new BasketUnit(21L));
        basketUnits.add(new BasketUnit(22L));
        basketUnits.add(new BasketUnit(23L));
    }

    @After
    public void clear() {
        basketUnits.clear();
    }

    @Test
    public void deleteOrder(){
        Order order = createOrder();
        assertNotNull(order);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                order.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        ResponseEntity<Order> checkDocumentById = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                Order.class,
                order.getId()
        );

        assertEquals(HttpStatus.OK, checkDocumentById.getStatusCode());
        assertNull(checkDocumentById.getBody());
    }

    @Test
    public void addOrderAndGetById() {
        Order order = createOrder();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Order> responseEntity = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                Order.class,
                order.getId()
        );

        Order resultOrder = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(order.getId(), resultOrder.getId());
        assertNotNull(resultOrder);
    }

    private Order createOrder() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Order order = prefillOrder();
        HttpEntity<Order> httpEntity = new HttpEntity<>(order, headers);
        RestTemplate restTemplate = new RestTemplate();
        Order createdOrder = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                httpEntity,
                Order.class
        ).getBody();

        assertNotNull(createdOrder);
        return createdOrder;
    }


    private Order prefillOrder() {
        Order order = new Order();
        order.setUserId(135L);
        order.setComment("true comment");
        order.setDeliveryDate(Date.valueOf("1984-01-08"));
        order.setDeliveryTime(Time.valueOf("04:05:06"));
        order.setDeliveryAddress("Moscow");
        order.setExecutorId(350L);

//        BasketUnit basketUnit1 = new BasketUnit();
//        basketUnit1.setQuantity(5);
//        BasketUnit basketUnit2 = new BasketUnit();
//        basketUnit2.setQuantity(10);
//
//        order.addBasketUnit(basketUnit1);
//        order.addBasketUnit(basketUnit2);

//        order.addBasketUnit(new BasketUnit());
        order.setBasketUnitList(basketUnits);
        return order;
    }
}
