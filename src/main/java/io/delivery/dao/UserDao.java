package io.delivery.dao;

import io.delivery.entity.User;

import java.util.List;

public interface UserDao extends BasicDao<User> {

    /**
     * Find user by login at database
     *
     * @param login value login of user
     * @return users
     */
    List<User> findByLogin(String login);
}
