package io.khasang.order;

import io.delivery.config.AppConfig;
import io.delivery.config.HibernateConfig;
import io.delivery.entity.BasketUnit;
import io.delivery.entity.Order;
import io.delivery.service.OrderService;
import io.delivery.service.impl.OrderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, OrderServiceImpl.class, HibernateConfig.class})
public class OrderModuleTest {

    @Autowired
    private OrderService orderService;

    public Order createOrder() {
        Order order = new Order();
        order.setUserId(135L);
        order.setComment("true comment");
        order.setDeliveryDate(Date.valueOf("1984-01-08"));
        order.setDeliveryTime(Time.valueOf("04:05:06"));
        order.setDeliveryAddress("Moscow");
        order.setExecutorId(350L);
        BasketUnit unit = new BasketUnit();
        order.addBasketUnit(unit);
        Order resultOrder = orderService.create(order);

        assertNotNull(resultOrder.getId());
        BasketUnit resultUnit = resultOrder.getBasketUnitList().get(0);

        assertNotNull(resultUnit);
        assertEquals(resultOrder.getId(), resultUnit.getOrder().getId());

        return resultOrder;
    }

    @Test
    public void deleteOrders() {
        Order order = createOrder();
        List<Order> orderList = orderService.getOrderList();
        assertNotNull(orderList);

        orderService.deleteOrdersPack(orderList);

        List<Order> result = orderService.getOrderList();
        assertFalse(result.contains(Order.class));
    }
}
