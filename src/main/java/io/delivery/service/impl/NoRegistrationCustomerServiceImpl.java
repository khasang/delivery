package io.delivery.service.impl;

import io.delivery.dao.NoRegistrationCustomerDao;
import io.delivery.entity.NoRegistrationCustomer;
import io.delivery.service.NoRegistrationCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("NoRegistrationCustomerService")
public class NoRegistrationCustomerServiceImpl implements NoRegistrationCustomerService {
    @Autowired
    NoRegistrationCustomerDao noRegistrationCustomerDao;

    @Override
    public List<NoRegistrationCustomer> getNoRegistrationCustomerList() {
        return noRegistrationCustomerDao.getList();
    }

    @Override
    public List<NoRegistrationCustomer> findByName(String name) {
        return noRegistrationCustomerDao.findByName((name));
    }

    @Override
    public NoRegistrationCustomer create(NoRegistrationCustomer noRegistrationCustomer) {
        return noRegistrationCustomerDao.create(noRegistrationCustomer);
    }

    @Override
    public NoRegistrationCustomer update(NoRegistrationCustomer noRegistrationCustomer) {
        return noRegistrationCustomerDao.update(noRegistrationCustomer);
    }

    @Override
    public NoRegistrationCustomer deleteNoRegistrationCustomer(long id) {
        return noRegistrationCustomerDao.delete(findById(id));
    }

    @Override
    public NoRegistrationCustomer findById(long id) {
        return noRegistrationCustomerDao.findById(id);
    }
}
