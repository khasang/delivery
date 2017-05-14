package io.delivery.dao;

import org.hibernate.Session;

import java.util.List;

/**
<<<<<<< HEAD
 *
 * Basic methods for DAO
 *
 *
 */

public interface BasicDao<T> {

    /**
     * @return
=======
 * Basic methods for DAO
 */
public interface BasicDao<T> {

    /**
     * @return current Hibernate session
>>>>>>> origin/feedback
     */
    Session getCurrentSession();

    /**
<<<<<<< HEAD
     * @return list of entity
=======
     * @return list for entity
>>>>>>> origin/feedback
     */
    List<T> getList();

    /**
<<<<<<< HEAD
     * Create entity at db
     *
=======
     * Create entity at database
>>>>>>> origin/feedback
     * @param entity - current entity
     * @return created entity
     */
    T create(T entity);

    /**
<<<<<<< HEAD
     * @param document - document for update
     * @return document
=======
     * @param entity - document for update
     * @return entity
>>>>>>> origin/feedback
     */
    T update(T entity);

    /**
     *
<<<<<<< HEAD
     *
     */
=======
     * */
>>>>>>> origin/feedback
    T findById(long id);

    /**
     *
<<<<<<< HEAD
     */
    T delete(T entity);
=======
     * */
    T delete(T entity);

>>>>>>> origin/feedback
}
