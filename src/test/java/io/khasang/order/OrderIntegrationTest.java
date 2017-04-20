package io.khasang.order;

import io.delivery.entity.BasketUnit;
import io.delivery.entity.Order;
import org.junit.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.*;

public class OrderIntegrationTest {

    private final String ROOT = "http://localhost:8080/order";
    private final String GET_ID = "/get/id/";
    private final String GET_UID = "/get/uid/";
    private final String ADD = "/add";
    private final String UPDATE = "/update";
    private final String DELETE = "/delete/";
    private final String DELETE_BASKET_UNIT = "/basket/delete/id/";
    private final String GET_BASKET_UNIT = "/basket/get/id/";
    private final String ALL = "/all";
    private final String GET_NAME = "/get/name/";

    private static List<BasketUnit> basketUnits = new ArrayList<>();

    @BeforeClass
    public static void setUp() {
        basketUnits.add(new BasketUnit(20L));
        basketUnits.add(new BasketUnit(21L));
        basketUnits.add(new BasketUnit(22L));
        basketUnits.add(new BasketUnit(23L));
    }

    @AfterClass
    public static void clear() {
        basketUnits.clear();
    }

    @Test
    public void updateOrder() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        RestTemplate restTemplate = new RestTemplate();
        Order order = createOrder();
        assertNotNull(order);

        order.setDeliveryAddress("Nowhere");
        order.setComment("Notext");

        HttpEntity<Order> httpEntity = new HttpEntity<>(order, headers);
        Order resultUpdate = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                httpEntity,
                Order.class
        ).getBody();

        assertNotNull(resultUpdate);
        assertNotNull(resultUpdate.getId());
        assertEquals("Nowhere", resultUpdate.getDeliveryAddress());
        assertEquals("Notext", resultUpdate.getComment());
    }

    @Test
    public void updateBasketUnit() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        RestTemplate restTemplate = new RestTemplate();
        Order order = createOrder();
        assertNotNull(order);
        assertNotNull(order.getBasketUnitList().get(0));

        order.getBasketUnitList().get(0).setQuantity(42);

        HttpEntity<Order> httpEntity = new HttpEntity<>(order, headers);
        Order resultUpdate = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                httpEntity,
                Order.class
        ).getBody();

        assertNotNull(resultUpdate);
        assertNotNull(resultUpdate.getId());
        assertEquals(42, resultUpdate.getBasketUnitList().get(0).getQuantity());
    }

    @Test
    public void deleteBasketUnit() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        RestTemplate restTemplate = new RestTemplate();
        Order order = createOrder();
        assertNotNull(order);

        List<BasketUnit> basket = order.getBasketUnitList();
        assertNotNull(basket);
        assertNotNull(basket.get(0));
        long id = basket.get(0).getId();

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + DELETE_BASKET_UNIT + "{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                basket.get(0).getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        ResponseEntity<BasketUnit> checkBasketUnitById = restTemplate.exchange(
                ROOT + GET_BASKET_UNIT + "{id}",
                HttpMethod.GET,
                null,
                BasketUnit.class,
                id
        );

        assertEquals(HttpStatus.OK, checkBasketUnitById.getStatusCode());
        assertNull(checkBasketUnitById.getBody());

    }

    @Test
    public void addBasketUnit() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        RestTemplate restTemplate = new RestTemplate();
        Order order = createOrder();
        assertNotNull(order);

        List<BasketUnit> basket = order.getBasketUnitList();
        assertNotNull(basket);
        BasketUnit basketUnitToAdd = new BasketUnit(19L);
        basket.add(basketUnitToAdd);

        HttpEntity<Order> httpEntity = new HttpEntity<>(order, headers);
        Order resultUpdate = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                httpEntity,
                Order.class
        ).getBody();

        assertNotNull(resultUpdate);
        assertNotEquals(-1, resultUpdate.getBasketUnitList().indexOf(basketUnitToAdd));
        assertTrue(resultUpdate.getBasketUnitList().contains(basketUnitToAdd));
    }

    @Test
    public void GetByUserId() {

        Order order = createOrder();
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Order>> responseEntity = restTemplate.exchange(
                ROOT + GET_UID + "{uid}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Order>>() {
                },
                order.getUserId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        List<Order> resultOrder = responseEntity.getBody();
        assertNotNull(resultOrder.get(0));
    }

    @Test
    public void deleteOrder() {
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
        order.setBasketUnitList(basketUnits);
        return order;
    }
}