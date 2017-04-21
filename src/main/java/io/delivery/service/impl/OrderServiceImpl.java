package io.delivery.service.impl;

import io.delivery.dao.OrderDao;
import io.delivery.entity.BasketUnit;
import io.delivery.entity.Order;
import io.delivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Order create(Order order) {
        return orderDao.create(order);
    }

    @Override
    public Order findById(long id) {
        return orderDao.findById(id);
    }

    @Override
    public Order deleteOrder(long id) {
        return orderDao.delete(findById(id));
    }

    @Override
    public Order updateOrder(Order order) {
        return orderDao.update(order);
    }

    @Override
    public List<Order> findByUserId(long uid) {
        return orderDao.findByUserId(uid);
    }

    @Override
    public BasketUnit findBasketUnitById(long id) {
        return orderDao.findBasketUnitById(id);
    }

    @Override
    public BasketUnit deleteBasketUnitById(long id) {
        return orderDao.deleteBasketUnitById(findBasketUnitById(id));
    }
}
