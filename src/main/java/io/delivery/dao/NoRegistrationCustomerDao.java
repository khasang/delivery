package io.delivery.dao;

import io.delivery.entity.NoRegistrationCustomer;

import java.util.List;

public interface NoRegistrationCustomerDao  extends BasicDao<NoRegistrationCustomer>{

    /**
     * Find NoRegistrationCustomer by name at db
     *
     * @param name - value name of NoRegistrationCustomer
     * @return NoRegistrationCustomer
     */
    List<NoRegistrationCustomer> findByName(String name);
}
