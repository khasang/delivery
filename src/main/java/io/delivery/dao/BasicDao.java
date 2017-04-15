package io.delivery.dao;

import org.hibernate.Session;

import java.util.List;

/**
 *
 * Basic methods for DAO
 *
 *
 */

public interface BasicDao<T> {

    /**
     * @return
     */
    Session getCurrentSession();

    /**
     * @return list of entity
     */
    List<T> getList();

    /**
     * Create entity at db
     *
     * @param entity - current entity
     * @return created entity
     */
    T create(T entity);

    /**
     * @param document - document for update
     * @return document
     */
    T update(T entity);

    /**
     *
     *
     */
    T findById(long id);

    /**
     *
     */
    T delete(T entity);
}
