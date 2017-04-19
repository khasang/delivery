package io.delivery.service;

import io.delivery.entity.Order;

import java.util.List;

public interface OrderService {

    /**
     * Create order in database
     *
     * @param order - current order for creation
     * @return created order
     */
    Order create(Order order);

    /**
     * Find order in database by ID
     *
     * @param id of order
     * @return order
     */
    Order findById(long id);

    /**
     * Delete order in database by ID
     *
     * @param id of order
     * @return order
     */
    Order delete(long id);

    /**
     * Update order
     *
     * @param order - order for updating
     * @return updated order
     */
    Order update(Order order);

    /**
     * Find orders in database by userID
     *
     * @param uid ID of user
     * @return order
     */
    List<Order> findByUserId(long uid);
}
