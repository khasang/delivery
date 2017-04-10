package io.delivery.dao.impl;


import io.delivery.dao.DocumentDao;
import io.delivery.entity.Document;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DocumentdaoImpl extends BasicdaoImpl<Document> implements DocumentDao {
    public DocumentdaoImpl(Class<Document> entityClass) {
        super(entityClass);
    }


}
