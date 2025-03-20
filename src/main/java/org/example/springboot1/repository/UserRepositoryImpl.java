package org.example.springboot1.repository;

import org.example.springboot1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Создание пользователя
    public void save(User user) {
        String sql = "INSERT INTO user (name, last_name, email) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail());
    }

    // Обновление пользователя
    public void update(User user) {
        String sql = "UPDATE user SET name = ?, last_name = ?, email = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getId());
    }

    // Получение пользователя по ID
    public User getById(Long id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id},
                (rs, rowNum) -> {
                    return new User(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getString("last_name"),
                            rs.getString("email")
                    );
                }
        );
    }

    // Получение всех пользователей
    public List<User> findAll() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql,
                (rs, rowNum) -> new User(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("last_name"),
                        rs.getString("email")
                )
        );
    }

    // Удаление пользователя
    public void delete(Long id) {
        String sql = "DELETE FROM user WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
