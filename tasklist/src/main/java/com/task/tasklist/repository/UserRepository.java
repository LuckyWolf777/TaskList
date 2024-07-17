package com.task.tasklist.repository;

import com.task.tasklist.model.user.Role;
import com.task.tasklist.model.user.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository {

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

    void update(User user);

    void create(User user);

    void insertUserRole(Long id, Role role);

    boolean isTaskOwner(Long userId, Long taskId);

    void delete(Long id);
}
