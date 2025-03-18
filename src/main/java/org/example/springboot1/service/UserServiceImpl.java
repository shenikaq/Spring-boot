package org.example.springboot1.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.springboot1.model.User;
import org.example.springboot1.repository.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Primary
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> userList() {
        return userDao.findAll();
    }
    @Override
    public void save(User user) {
        userDao.save(user);
    }
    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }
    @Override
    public User getById(long id) {
        return userDao.getById(id);
    }
}
