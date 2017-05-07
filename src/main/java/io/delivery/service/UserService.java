package io.delivery.service;

import io.delivery.entity.User;

import java.util.List;

public interface UserService {
    /**
     * Receive all users from db
     *
     * @return user list
     */
    List<User> getUserList();

    /**
     * Find user by login at database
     *
     * @param login - value login of user
     * @return document
     */
    List<User> findByLogin(String login);

    /**
     * Create user at database
     *
     * @param user - current user for creation
     * @return created document
     */
    User create(User user);

    /**
     * @param user - user for update
     * @return user
     */
    User updateUser(User user);

    /**
     * @param id = user id
     * @return deleted user
     */
    User deleteUser(long id);

    User findById(long id);
}
