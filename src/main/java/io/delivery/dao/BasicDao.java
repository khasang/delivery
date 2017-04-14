package io.delivery.dao;

import org.hibernate.Session;

import java.util.List;

/**
 * Basic methods for DAO
 */
public interface BasicDao<T> {
    /**
     * @return current Hibernate session
     */
    Session getCurrentSession();

    /**
     * @return list of entities
     */
    List<T> getList();

    /**
     * Create entity in database
     *
     * @param entity - current entity
     * @return created entity
     */
    T create(T entity);

    /**
     * Update entity in database
     *
     * @param entity - entity for update
     * @return entity
     */
    T updateEntity(T entity);

    /**
     * Find entity by id
     *
     * @param id - entity id
     * @return entity
     */
    T findById(long id);

    /**
     * Delete entity
     *
     * @param entity
     * @return
     */
    T delete(T entity);
}
