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
}
