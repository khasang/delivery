package io.khasang.order;

import io.delivery.entity.BasketItem;
import io.delivery.entity.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
    private final String DELETE_BASKET_ITEM = "/delete/basket/id";
    private final String GET_BASKET_ITEM = "/get/basket/id";
    private final String ALL = "/all";
    private final String GET_NAME = "/get/name/";

    private static List<BasketItem> basketItems = new ArrayList<>();

    @Before
    public void setUp() {
        basketItems.add(new BasketItem(20L));
        basketItems.add(new BasketItem(21L));
        basketItems.add(new BasketItem(22L));
        basketItems.add(new BasketItem(23L));
    }

    @After
    public void clear() {
        basketItems.clear();
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
    public void updateBasketItem() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        RestTemplate restTemplate = new RestTemplate();
        Order order = createOrder();
        assertNotNull(order);
        assertNotNull(order.getBasketItemList().get(0));

        order.getBasketItemList().get(0).setQuantity(42);

        HttpEntity<Order> httpEntity = new HttpEntity<>(order, headers);
        Order resultUpdate = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                httpEntity,
                Order.class
        ).getBody();

        assertNotNull(resultUpdate);
        assertNotNull(resultUpdate.getId());
        assertEquals(42, resultUpdate.getBasketItemList().get(0).getQuantity());
    }

    @Test
    public void deleteBasketItem() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        RestTemplate restTemplate = new RestTemplate();
        Order order = createOrder();
        assertNotNull(order);

        List<BasketItem> basket = order.getBasketItemList();
        assertNotNull(basket);
        assertNotNull(basket.get(0));
        long id = basket.get(0).getItemId();

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + DELETE_BASKET_ITEM + "{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                basket.get(0).getItemId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        ResponseEntity<BasketItem> checkBasketItemById = restTemplate.exchange(
                ROOT + GET_BASKET_ITEM + "{id}",
                HttpMethod.GET,
                null,
                BasketItem.class,
                id
        );

        assertEquals(HttpStatus.OK, checkBasketItemById.getStatusCode());
        assertNull(checkBasketItemById.getBody());

    }

    @Test
    public void addBasketItem() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        RestTemplate restTemplate = new RestTemplate();
        Order order = createOrder();
        assertNotNull(order);

        List<BasketItem> basket = order.getBasketItemList();
        assertNotNull(basket);
        BasketItem basketItemToAdd = new BasketItem(19L);
        basket.add(basketItemToAdd);

        HttpEntity<Order> httpEntity = new HttpEntity<>(order, headers);
        Order resultUpdate = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                httpEntity,
                Order.class
        ).getBody();

        assertNotNull(resultUpdate);
        assertNotEquals(-1, resultUpdate.getBasketItemList().indexOf(basketItemToAdd));
        assertTrue(resultUpdate.getBasketItemList().contains(basketItemToAdd));
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
        order.setBasketItemList(basketItems);
        return order;
    }
}
