package org.example.springboot1.repository;

import org.example.springboot1.model.User;
import java.util.List;

public interface UserRepository {

    void save(User user);
    void update(User user);
    User getById(Long id);
    List<User> findAll();
    void delete(Long id);

}
