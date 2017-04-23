package io.delivery.dao.impl;

import io.delivery.dao.UserDao;
import io.delivery.entity.User;

import java.util.List;

public class UserDaoIml extends BasicDaoImpl<User> implements UserDao {
    public UserDaoIml(Class<User> entityClass) {
        super(entityClass);
    }

    @Override
    public List<User> findByLogin(String login) {
        List list = sessionFactory.getCurrentSession()
                .createQuery("from User as d where d.login = ?")
                .setParameter(0, login).list();
        return list;
    }
}
