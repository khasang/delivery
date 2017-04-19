package io.delivery.dao.impl;

import io.delivery.dao.OrderDao;
import io.delivery.entity.Order;

import java.util.List;

public class OrderDaoImpl extends BasicDaoImpl<Order> implements OrderDao {
    public OrderDaoImpl(Class<Order> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Order> findByUserId(long uid) {
        return (List<Order>) sessionFactory.getCurrentSession().
                createQuery("from Order as o where o.userId = ?").
                setParameter(0, uid).list();
    }
}

