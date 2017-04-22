package io.delivery.service;

import io.delivery.entity.NoRegistrationCustomer;

import java.util.List;

public interface NoRegistrationCustomerService {
    /**
     * Receive all NoRegistrationCustomer from db
     * <p>
     * return NoRegistrationCustomer list
     */
    List<NoRegistrationCustomer> getNoRegistrationCustomerList();

    /**
     * Find NoRegistrationCustomer by name at db
     *
     * @param name - value name of NoRegistrationCustomer
     * @return NoRegistrationCustomer
     */
    List<NoRegistrationCustomer> findByName(String name);

    /**
     * Create NoRegistrationCustomer at db
     *
     * @param noRegistrationCustomer - current NoRegistrationCustomer for creation
     * @return created NoRegistrationCustomer
     */
    NoRegistrationCustomer create(NoRegistrationCustomer noRegistrationCustomer);
}