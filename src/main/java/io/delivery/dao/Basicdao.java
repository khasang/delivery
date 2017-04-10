package io.delivery.dao;

import org.hibernate.Session;

import java.util.List;

/**
 * Basic methods for DAO
 **/
public interface Basicdao<T> {
    /**
     * @return current Hibernate session
     **/
    Session getCurrentSession();
    /**
     * @return List for entity
     **/
    List<T> getList();
}
