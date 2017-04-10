package io.delivery.dao.impl;


import io.delivery.dao.DocumentDao;
import io.delivery.entity.Document;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DocumentdaoImpl extends BasicdaoImpl<Document> implements DocumentDao {
    public DocumentdaoImpl(Class<Document> entityClass) {
        super(entityClass);
    }


    @Override
    public List<Document> findByName(String name) {
        return (List<Document>) sessionFactory.getCurrentSession().
                createQuery("from document as d where d.name = ?").
                setParameter(0, name).list();
    }
}
