package io.delivery.dao.impl;

import io.delivery.dao.DocumentDao;
import io.delivery.entity.Document;
<<<<<<< HEAD
=======

>>>>>>> origin/feedback
import java.util.List;

public class DocumentDaoImpl extends BasicDaoImpl<Document> implements DocumentDao {
    public DocumentDaoImpl(Class<Document> entityClass) {
        super(entityClass);
<<<<<<< HEAD

=======
>>>>>>> origin/feedback
    }

    @Override
    public List<Document> findByName(String name) {
<<<<<<< HEAD
        return (List<Document>) sessionFactory.getCurrentSession().createQuery("from Document as d where d.name = ?")
=======
        return (List<Document>) sessionFactory.getCurrentSession()
                .createQuery("from Document as d where d.name = ?")
>>>>>>> origin/feedback
                .setParameter(0, name).list();
    }
}
