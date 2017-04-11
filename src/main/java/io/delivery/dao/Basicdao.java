package io.delivery.dao;

import org.hibernate.Session;

import java.util.List;

/**
 * Basic methods for DAO
 */
public interface Basicdao<T> {
    /**
     * @return current Hibernate session
     */
    Session getCurrentSession();

    /**
     * @return List for entity
     */
    List<T> getList();

    /**
     * Create entity at DB
     * @param entity  - current entity
     * @return created entity
     */
    T create (T entity);

    /**
     * @param entity - document for update
     * @return entity
     */
    T update(T entity);

    /**
     *
     */
    T findById(long id);

    /**
     *
     */
    T delete(T entity);
}
