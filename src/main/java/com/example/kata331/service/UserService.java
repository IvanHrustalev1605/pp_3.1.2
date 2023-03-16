package com.example.kata331.service;

import com.example.kata331.model.User;

import java.util.List;

public interface UserService {
    public void create(User user);
    public List<User> allUsers(User user);
    public User getUserById(Long id);
    public void update(User user, Long id);
    public void delete(Long id);
}
