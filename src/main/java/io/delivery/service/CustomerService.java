package io.delivery.service;


import io.delivery.entity.Customer;

import java.util.List;

public interface CustomerService {
    /**
     * Get customers by name from database
     * @param name - customer's name
     * @return - list of customers
     */
    List<Customer> getCustomerByName(String name);

    /**
     * Get customers by address from database
     * @param address - customer's address
     * @return - list of customers, if more then one customer registered at same address
     */
    List<Customer> getCustomerByAddress(String address);

    /**
     * Get customer by phone number from database
     * @param phoneNumber - customer's phone number
     * @return - current customer
     */
    Customer getCustomerByPhoneNumber(String phoneNumber);

    /**
     * Get customer by e-mail from database
     * @param eMail - customer's e-mail
     * @return - current customer
     */
    Customer getCustomerByEmail(String eMail);

    /**
     * Get customer by id from database
     * @param id - customer's id
     * @return - current customer
     */
    Customer getCustomerById(long id);

    /**
     * Get list of all customers from database
     * @return - list of all customers
     */
    List<Customer> getAllCustomers();

    /**
     * Create new customer in database
     * @param customer - current customer to creation
     * @return - created customer
     */
    Customer createCustomer(Customer customer);

    /**
     * Update customer in database
     * @param customer - current customer to update
     * @return - updated customer
     */
    Customer updateCustomer(Customer customer);

    /**
     * Delete customer from database
     * @param id - customer id
     * @return - deleted customer
     */
    Customer deleteCustomer(long id);

}
