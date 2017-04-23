package io.delivery.dao.impl;

import io.delivery.dao.CustomerDao;
import io.delivery.entity.Customer;

import java.util.List;

public class CustomerDaoImpl extends BasicDaoImpl<Customer> implements CustomerDao {
    public CustomerDaoImpl(Class<Customer> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Customer> findCustomerByName(String name) {
        return (List<Customer>) sessionFactory.getCurrentSession()
                .createQuery("FROM Customer where name = ?")
                .setParameter(0, name)
                .list();
    }

    @Override
    public List<Customer> findCustomerByAddress(String address) {
        return (List<Customer>) sessionFactory.getCurrentSession()
                .createQuery("FROM Customer where address = ?")
                .setParameter(0, address)
                .list();
    }

    @Override
    public Customer findCustomerByPhoneNumber(String phoneNumber) {
        return (Customer) sessionFactory.getCurrentSession()
                .createQuery("FROM Customer where phoneNumber = ?")
                .setParameter(0, phoneNumber)
                .uniqueResult();
    }

    @Override
    public Customer findCustomerByEmail(String eMail) {
        return (Customer) sessionFactory.getCurrentSession()
                .createQuery("FROM Customer where eMail = ?")
                .setParameter(0, eMail)
                .uniqueResult();
    }

}
