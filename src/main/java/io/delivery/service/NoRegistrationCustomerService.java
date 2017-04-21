package io.delivery.service;

import io.delivery.entity.NoRegistrationCustomer;

import java.util.List;

public interface NoRegistrationCustomerService {
    /**
     * Receive all NoRegistrationCustomer from db
     *
     * return NoRegistrationCustomer list
     */
    List<NoRegistrationCustomer> getNoRegistrationCustomerList();
}
