package io.delivery.service.impl;

import io.delivery.dao.CustomerDao;
import io.delivery.entity.Customer;
import io.delivery.message.CustomerJmsSender;
import io.delivery.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.Message;
import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerDao customerDao;
    @Autowired
    CustomerJmsSender customerJmsSender;

    @Override
    public List<Customer> getCustomerByName(String name) {
        return customerDao.findCustomerByName(name);
    }

    @Override
    public List<Customer> getCustomerByAddress(String address) {
        return customerDao.findCustomerByAddress(address);
    }

    @Override
    public Customer getCustomerByPhoneNumber(String phoneNumber) {
        return customerDao.findCustomerByPhoneNumber(phoneNumber);
    }

    @Override
    public Customer getCustomerByEmail(String eMail) {
        return customerDao.findCustomerByEmail(eMail);
    }

    @Override
    public Customer getCustomerById(long id) {
        return customerDao.findById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.getList();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerDao.create(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerDao.update(customer);
    }

    @Override
    public Customer deleteCustomer(long id) {
        return customerDao.delete(customerDao.findById(id));
    }

    @Override
    public void sendCustomer(Customer customer) {
        customerJmsSender.sendMessage(customer);
    }
}
