package io.delivery.dao.impl;

import io.delivery.dao.BasicDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Transactional
public class BasicDaoImpl<T> implements BasicDao<T> {
    @Autowired
    protected SessionFactory sessionFactory;
    private Class<T> entityClass;

    public BasicDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<T> getList() {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(entityClass);
        Root root = criteriaQuery.from(entityClass);
        criteriaQuery.select(root);
        return sessionFactory.getCurrentSession().createQuery(criteriaQuery).list();
    }

    @Override
    public T create(T entity) {
        getCurrentSession().save(entity);
        return entity;
    }

    @Override
    public T updateEntity(T entity) {
        getCurrentSession().update(entity);
        return entity;
    }

    @Override
    public T findById(long id) {
        return getCurrentSession().get(entityClass, id);
    }

    @Override
    public T delete(T entity) {
        getCurrentSession().delete(entity);
        return entity;
    }
}
