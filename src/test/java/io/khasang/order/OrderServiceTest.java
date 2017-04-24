package io.khasang.order;

import io.delivery.config.AppConfig;
import io.delivery.config.HibernateConfig;
import io.delivery.entity.BasketUnit;
import io.delivery.entity.Order;
import io.delivery.service.OrderService;
import io.delivery.service.impl.OrderServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, OrderServiceImpl.class, HibernateConfig.class})
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    private static final int TEST_QUANTITY = 42;
    private static final String TEST_DELIVERY_ADDRESS = "Nowhere";
    private static final String TEST_DELIVERY_COMMENT = "Notext";

    private static List<BasketUnit> basketUnits = new ArrayList<>();
    {
        basketUnits.add(new BasketUnit(20L));
        basketUnits.add(new BasketUnit(21L));
        basketUnits.add(new BasketUnit(22L));
        basketUnits.add(new BasketUnit(23L));
    }

    @Test
    public void updateOrder() {
        Order order = createOrder();
        assertNotNull(order);

        order.setDeliveryAddress(TEST_DELIVERY_ADDRESS);
        order.setComment(TEST_DELIVERY_COMMENT);

        Order updatedOrder = orderService.updateOrder(order);

        assertNotNull(updatedOrder);
        assertEquals(TEST_DELIVERY_ADDRESS,updatedOrder.getDeliveryAddress());
        assertEquals(TEST_DELIVERY_COMMENT,updatedOrder.getComment());
        orderService.deleteOrder(order.getId());
    }

    @Test
    public void updateBasketUnit() {

        Order order = createOrder();
        assertNotNull(order);
        assertNotNull(order.getBasketUnitList().get(0));

        order.getBasketUnitList().get(0).setQuantity(TEST_QUANTITY);
        Order updatedOrder = orderService.updateOrder(order);

        assertNotNull(updatedOrder);
        assertNotNull(updatedOrder.getId());
        assertEquals(TEST_QUANTITY, updatedOrder.getBasketUnitList().get(0).getQuantity());
        orderService.deleteOrder(order.getId());
    }

    @Test
    public void deleteBasketUnit() {

        Order order = createOrder();
        assertNotNull(order);

        List<BasketUnit> basket = order.getBasketUnitList();
        assertNotNull(basket);
        assertNotNull(basket.get(0));
        long id = basket.get(0).getId();

        orderService.deleteBasketUnitById(id);

        assertNull(orderService.findBasketUnitById(id));
        orderService.deleteOrder(order.getId());
    }

    @Test
    public void addBasketUnit() {

        Order order = createOrder();
        assertNotNull(order);

        BasketUnit basketUnitToAdd = new BasketUnit(19L);
        order.addBasketUnit(basketUnitToAdd);
        Order updatedOrder = orderService.updateOrder(order);

        assertTrue(updatedOrder.getBasketUnitList().contains(basketUnitToAdd));
        orderService.deleteOrder(order.getId());
    }

    @Test
    public void GetByUserId() {

        Order order = createOrder();
        List<Order> ordersByUserId =  orderService.findByUserId(order.getUserId());

        assertThat(ordersByUserId,hasItem(hasProperty("id",is(order.getId()))));

        assertNotNull(ordersByUserId);
        orderService.deleteOrder(order.getId());
    }

    @Test
    public void deleteOrder() {
        Order order = createOrder();
        assertNotNull(order);

        Order responceOrder = orderService.deleteOrder(order.getId());
        assertNull(orderService.findById(responceOrder.getId()));
    }

    @Test
    public void GetOrderById() {
        Order order = createOrder();

        Order responceOrder = orderService.findById(order.getId());

        assertEquals(order.getId(), responceOrder.getId());
        assertNotNull(responceOrder);
        orderService.deleteOrder(order.getId());
    }

    private Order createOrder() {
        Order order = prefillOrder();
        orderService.create(order);

        assertNotNull(order);
        return order;
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
