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
     * @return list for entity
     */
    List<T> getList();

    /**
     * Create entity at database
     *
     * @param entity - current entity
     * @return created entity
     */
    T create(T entity);

    /**
     * Update entity at database
     * @param entity - current entity for update
     * @return entity
     */
    T update(T entity);

    /**
     * Find entity by id at database
     * @param id - entity id
     * @return entity
     */
    T findById(long id);

    /**
     * Delete entity at database
     * @param entity - entity for delete
     * @return deleted entity
     */
    T delete(T entity);

}
