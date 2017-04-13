package io.delivery.service;


import io.delivery.entity.Customer;

import java.util.List;

public interface CustomerService {
    /**
     *
     * @param name - current name at database
     * @return customer name
     */
    List<Customer> findCustomerByName(String name);

    /**
     *
     * @param address - current address at database
     * @return customer address
     */
    List<Customer> findCustomerByAddress(String address);

    /**
     *
     * @param phoneNumber - current phoneNumber at database
     * @return customer phone number
     */
    Customer findCustomerByPhoneNumber(String phoneNumber);

    /**
     *
     * @param eMail - current email at database
     * @return customer email
     */
    Customer findCustomerByEmail(String eMail);
}
