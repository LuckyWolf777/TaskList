package com.task.tasklist.repository;

import com.task.tasklist.model.user.Role;
import com.task.tasklist.model.user.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository {

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

    void update(User user);

    void create(User user);

    void insertUserRole(@Param("userId") Long id,@Param("role") Role role);

    boolean isTaskOwner(@Param("userId") Long userId,@Param("taskId") Long taskId);

    void delete(Long id);
}
