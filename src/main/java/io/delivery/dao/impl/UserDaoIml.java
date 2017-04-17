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
        return (List<User>) sessionFactory.getCurrentSession().
                createQuery("from User as d where d.login = ?").
                setParameter(0, login).list();
    }
}
