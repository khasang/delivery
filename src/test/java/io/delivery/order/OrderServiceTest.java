package io.delivery.order;

import io.delivery.config.AppConfig;
import io.delivery.config.HibernateConfig;
import io.delivery.entity.BasketUnit;
import io.delivery.entity.Order;
import io.delivery.service.OrderService;
import io.delivery.service.impl.OrderServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, OrderServiceImpl.class, HibernateConfig.class})
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;
    private Order order;
    private List<BasketUnit> basketUnits;

    private static final int TEST_QUANTITY = 42;
    private static final String TEST_DELIVERY_ADDRESS = "Nowhere";
    private static final String TEST_DELIVERY_COMMENT = "Notext";

    @Before
    public void createOrder() {
        order = prefillOrder();
        orderService.create(order);
        assertNotNull(order);
    }

    @After
    public void cleanOrder() {
        // clean and correct deletion test
        Order responceOrder = orderService.deleteOrder(order.getId());
        assertNull(orderService.findById(responceOrder.getId()));
    }

    private Order prefillOrder() {
        basketUnits = new ArrayList<>();
        basketUnits.add(new BasketUnit(20L));
        basketUnits.add(new BasketUnit(21L));
        basketUnits.add(new BasketUnit(22L));
        basketUnits.add(new BasketUnit(23L));
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

    @Test
    public void updateOrder() {
        order.setDeliveryAddress(TEST_DELIVERY_ADDRESS);
        order.setComment(TEST_DELIVERY_COMMENT);
        Order updatedOrder = orderService.updateOrder(order);
        assertNotNull(updatedOrder);
        assertEquals(TEST_DELIVERY_ADDRESS, updatedOrder.getDeliveryAddress());
        assertEquals(TEST_DELIVERY_COMMENT, updatedOrder.getComment());
    }

    @Test
    public void updateBasketUnit() {
        assertNotNull(order.getBasketUnitList().get(0));
        order.getBasketUnitList().get(0).setQuantity(TEST_QUANTITY);
        Order updatedOrder = orderService.updateOrder(order);
        assertNotNull(updatedOrder);
        assertNotNull(updatedOrder.getId());
        assertEquals(TEST_QUANTITY, updatedOrder.getBasketUnitList().get(0).getQuantity());
    }

    @Test
    public void deleteBasketUnit() {
        List<BasketUnit> basket = order.getBasketUnitList();
        assertNotNull(basket);
        assertNotNull(basket.get(0));
        long id = basket.get(0).getId();
        orderService.deleteBasketUnitById(id);
        assertNull(orderService.findBasketUnitById(id));
    }

    @Test
    public void addBasketUnit() {
        BasketUnit basketUnitToAdd = new BasketUnit(19L);
        order.addBasketUnit(basketUnitToAdd);
        Order updatedOrder = orderService.updateOrder(order);
        assertThat(updatedOrder.getBasketUnitList(), hasItem(hasProperty("id", is(basketUnitToAdd.getId()))));
    }

    @Test
    public void GetByUserId() {
        List<Order> ordersByUserId = orderService.findByUserId(order.getUserId());
        assertThat(ordersByUserId, hasItem(hasProperty("id", is(order.getId()))));
        assertNotNull(ordersByUserId);
    }


    @Test
    public void GetOrderById() {
        Order responceOrder = orderService.findById(order.getId());
        assertEquals(order.getId(), responceOrder.getId());
        assertNotNull(responceOrder);
    }
}
