package io.delivery.service;

import io.delivery.entity.BasketUnit;
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
     * Delete order from database
     *
     * @param id of order
     * @return order
     */
    Order deleteOrder(long id);

    /**
     * Update order
     *
     * @param order - order for updating
     * @return updated order
     */
    Order updateOrder(Order order);

    /**
     * Find orders in database by userID
     *
     * @param uid ID of user
     * @return order
     */
    List<Order> findByUserId(long uid);

    /**
     * Find basketUnitList in db
     *
     * @return basketUnitList
     */
    BasketUnit findBasketUnitById(long id);

    /**
     * Delete basketUnit from db by ID
     *
     * @param id - basketUnit ID
     * @return deleted basketUnit
     */
    BasketUnit deleteBasketUnitById(long id);

    /**
     * Receive orders from db
     *
     * @return list of orders
     */
    List<Order> getOrderList();
}
