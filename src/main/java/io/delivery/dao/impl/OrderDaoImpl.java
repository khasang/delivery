package io.delivery.dao.impl;

import io.delivery.dao.OrderDao;
import io.delivery.entity.Order;

public class OrderDaoImpl extends BasicDaoImpl<Order> implements OrderDao {
    public OrderDaoImpl(Class<Order> entityClass) {
        super(entityClass);
    }
    }

