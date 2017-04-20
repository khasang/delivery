package io.delivery.dao.impl;

import io.delivery.dao.OrderDao;
import io.delivery.entity.BasketUnit;
import io.delivery.entity.Order;
import org.hibernate.query.Query;

import java.util.List;

public class OrderDaoImpl extends BasicDaoImpl<Order> implements OrderDao {
    public OrderDaoImpl(Class<Order> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Order> findByUserId(long uid) {
        return (List<Order>) sessionFactory.getCurrentSession()
                .createQuery("from Order where userId = :userId")
                .setParameter("userId", uid)
                .list();
    }

    @Override
    public BasketUnit getBasketUnitListById(long id) {
        return (BasketUnit) sessionFactory.getCurrentSession()
                .createQuery("from BasketUnit where itemId = :itemId")
                .setParameter("itemId", id)
                .uniqueResult();
    }

    @Override
    public int deleteBasketUnitById(long id) {
        Query query = sessionFactory.getCurrentSession().
                createQuery("delete BasketUnit where id = :id")
                .setParameter("id", id);
        return query.executeUpdate();
    }
}

