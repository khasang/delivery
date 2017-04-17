package io.delivery.dao.impl;

import io.delivery.dao.AdminAreaDao;
import io.delivery.entity.AdminArea;

import java.util.List;

public class AdminAreaDaoImpl extends BasicDaoImpl<AdminArea> implements AdminAreaDao{
    public AdminAreaDaoImpl(Class<AdminArea> entityClass) {
        super(entityClass);
    }

    @Override
    public List<AdminArea> findByName(String name) {
        return (List<AdminArea>) sessionFactory.getCurrentSession().
                createQuery("from AdminArea as d where d.name = ?").
                setParameter(0, name).list();
    }
}
