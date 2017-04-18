package io.delivery.service.impl;

import io.delivery.dao.UserDao;
import io.delivery.entity.User;
import io.delivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> getUserList() {
        return userDao.getList();
    }

    @Override
    public List<User> findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    @Override
    public User create(User user) {
        return userDao.create(user);
    }

    @Override
    public User updateUser(User user) {
        return userDao.update(user);
    }

    @Override
    public User deleteUser(long id) {
        return userDao.delete(findById(id));
    }

    @Override
    public User findById(long id) {
        return userDao.findById(id);
    }
}
