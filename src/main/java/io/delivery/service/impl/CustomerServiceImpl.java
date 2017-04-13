package io.delivery.service.impl;

import io.delivery.dao.CustomerDao;
import io.delivery.entity.Customer;
import io.delivery.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerDao customerDao;

    @Override
    public List<Customer> findCustomerByName(String name) {
        return customerDao.findCustomerByName(name);
    }

    @Override
    public List<Customer> findCustomerByAddress(String address) {
        return customerDao.findCustomerByAddress(address);
    }

    @Override
    public Customer findCustomerByPhoneNumber(String phoneNumber) {
        return customerDao.findCustomerByPhoneNumber(phoneNumber);
    }

    @Override
    public Customer findCustomerByEmail(String eMail) {
        return customerDao.findCustomerByEmail(eMail);
    }

}
