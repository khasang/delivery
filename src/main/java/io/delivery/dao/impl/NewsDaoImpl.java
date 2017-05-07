package io.delivery.dao.impl;

import io.delivery.dao.NewsDao;
import io.delivery.entity.News;

import java.util.List;

public class NewsDaoImpl extends BasicDaoImpl<News> implements NewsDao{
    public NewsDaoImpl(Class<News> entityClass) {
        super(entityClass);
    }

    @Override
    public List<News> findByName(String name) {
        return (List<News>) sessionFactory.getCurrentSession().
                createQuery("from News as d where d.name = ?").
                setParameter(0, name).list();
    }
}
