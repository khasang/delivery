package io.delivery.dao.impl;

import io.delivery.dao.BasicDao;
import io.delivery.dao.DocumentDao;
import io.delivery.entity.Document;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by NortT on 15.04.2017.
 */
public class DocumentDaoImpl extends BasicDaoImpl<Document> implements DocumentDao {

    public DocumentDaoImpl(Class<Document> entityClass) {
        super(entityClass);
    }


    @Override
    public List<Document> findByName(String name) {
        return (List<Document>) sessionFactory.getCurrentSession().
                createQuery("from Document as d where d.name = ?").
                setParameter(0, name).list();
    }
}
