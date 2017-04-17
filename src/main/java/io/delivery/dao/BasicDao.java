package io.delivery.dao;

import io.delivery.entity.Document;
import org.hibernate.Session;
import java.util.List;
/**
 * Basic methods for DAO
 */
public interface BasicDao<T> {
    /**
     *
     * @return current hibernate session
     */
    Session getCurrentSession();

    /**
     * @return list for entity
     */
    List<T> getList();

    /**
     * Create entity
     * @param entity - current entity
     * @return created entity
     */
    T create(T entity);

    /**
     * Update entity
     * @param entity - current entity
     * @return created entity
     */
    T update(T entity);

    /**
     * delete entity
     * @param entity - current entity
     * @return deleted entity
     */
    T delete(T entity);

    /**
     * find by Id
     * @param id - current id
     * @return found entity
     */
    T findById(long id);
}
