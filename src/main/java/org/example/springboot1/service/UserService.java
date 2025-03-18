package org.example.springboot1.service;

import org.example.springboot1.model.User;

import java.util.List;

public interface UserService {

    List<User> userList();
    void save(User user);
    void delete(Long id);
    User getById(long id);
}
