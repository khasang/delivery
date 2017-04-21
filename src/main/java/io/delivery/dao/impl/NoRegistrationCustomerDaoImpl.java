package io.delivery.dao.impl;

import io.delivery.dao.NoRegistrationCustomerDao;
import io.delivery.entity.NoRegistrationCustomer;

public class NoRegistrationCustomerDaoImpl extends BasicDaoImpl<NoRegistrationCustomer> implements NoRegistrationCustomerDao {
    public NoRegistrationCustomerDaoImpl(Class<NoRegistrationCustomer> entityClass) {
        super(entityClass);
    }
}
