package com.example.kata331.service;

import com.example.kata331.dao.UserDao;
import com.example.kata331.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void create(User user) {
        userDao.save(user);

    }

    @Override
    public List<User> allUsers(User user) {
        return userDao.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getReferenceById(id);
    }

    @Override
    public void update(User user, Long id) {
        User userToUpdate = userDao.findById(id).orElse(null);
        userToUpdate.setName(user.getName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setAge(user.getAge());
        userToUpdate.setEmail(user.getEmail());
        userDao.save(userToUpdate);
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }
}
