package io.delivery.dao;

import io.delivery.entity.BasketUnit;
import io.delivery.entity.Order;

import java.util.List;

public interface OrderDao extends BasicDao<Order> {

    /**
     * Find orders in database by userID
     *
     * @param uid - userID
     * @return list of orders
     */
    List<Order> findByUserId(long uid);

    /**
     * Receive basketUnitList from db
     *
     * @return basketUnitList
     */
    BasketUnit findBasketUnitById(long id);

    /**
     * Delete basketUnit from db
     *
     * @param basketUnit - basketUnit
     * @return - deleted basketUnit
     */
    BasketUnit deleteBasketUnitById(BasketUnit basketUnit);
}
