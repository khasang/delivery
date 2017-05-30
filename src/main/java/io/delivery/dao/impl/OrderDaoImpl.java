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
                .createQuery("from Order where userId = ?")
                .setParameter(0, uid).list();
    }

    @Override
    public BasketUnit findBasketUnitById(long id) {
        return (BasketUnit) sessionFactory.getCurrentSession()
                .createQuery("from BasketUnit where id = ?")
                .setParameter(0, id).uniqueResult();
    }

    @Override
    public BasketUnit deleteBasketUnitById(BasketUnit basketUnit) {
        long id = basketUnit.getId();
        Query query = sessionFactory.getCurrentSession()
                .createQuery("delete BasketUnit where id = ?")
                .setParameter(0, id);
        query.executeUpdate();
        return basketUnit;
    }
}
