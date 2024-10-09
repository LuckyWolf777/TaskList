package com.task.tasklist.repository;

import com.task.tasklist.model.task.Task;

import java.util.List;
import java.util.Optional;


public interface TaskRepository {

    Optional<Task> findById(Long id);

    List<Task> findAllByUserID(Long id);

    void assignToUserById(Long taskId, Long userId);

    void update(Task task);

    void create(Task task);

    void delete(Long id);
}
