package io.delivery.service;

import io.delivery.entity.Order;

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
}
