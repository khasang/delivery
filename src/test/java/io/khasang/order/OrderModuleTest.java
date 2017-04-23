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

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
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

        List<BasketUnit> basketUnits = new ArrayList<>();
        basketUnits.add(new BasketUnit(20L));
        basketUnits.add(new BasketUnit(21L));
        basketUnits.add(new BasketUnit(22L));
        basketUnits.add(new BasketUnit(23L));
        order.setBasketUnitList(basketUnits);

        Order resultOrder = orderService.create(order);
        assertNotNull(resultOrder.getId());

        BasketUnit resultUnit = resultOrder.getBasketUnitList().get(0);
        assertNotNull(resultUnit);
        assertEquals(resultOrder.getId(), resultUnit.getOrder().getId());

        return resultOrder;
    }

    @Test
    public void deleteOrder() {
        Order order = createOrder();
        orderService.deleteOrder(order.getId());

        Order result = orderService.findById(order.getId());
        assertNull(result);
    }
}
