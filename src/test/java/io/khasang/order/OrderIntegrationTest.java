package io.khasang.order;

import io.delivery.entity.BasketUnit;
import io.delivery.entity.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OrderIntegrationTest {
    private final String ROOT = "http://localhost:8080/order";
    private final String ADD = "/add";
    private final String GET_ID = "/get/id/";
    private final String DELETE = "/delete/";

    private static ArrayList<BasketUnit> basketUnits = new ArrayList<>();

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


//    @Test
//    public void addOrderAndGetById() {
//        Order order = createOrder();
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        ResponseEntity<Order> responseEntity = restTemplate.exchange(
//                ROOT + GET_ID + "{id}",
//                HttpMethod.GET,
//                null,
//                Order.class,
//                order.getId()
//        );
//
//        Order resultOrder = responseEntity.getBody();
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertNotNull(resultOrder);
//    }

    @Test
    public void createOrder() {
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
        assertEquals(order.getBasketUnitList(), createdOrder.getBasketUnitList());
//        return createdOrder;
    }


    private Order prefillOrder() {
        Order order = new Order();
        order.setUserId((long) 135);
        order.setComment("true comment");
        order.setDeliveryDate(Date.valueOf("1984-01-08"));
        order.setDeliveryTime(Time.valueOf("04:05:06"));
        order.setDeliveryAddress("Moscow");
        order.setExecutorId((long) 350);
        order.setBasketUnitList(basketUnits);
        return order;
    }
}
