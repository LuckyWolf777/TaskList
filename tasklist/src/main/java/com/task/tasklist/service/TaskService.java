package com.task.tasklist.service;

import com.task.tasklist.model.task.Task;

import java.util.List;

public interface TaskService {

    Task getById(Long id);

    List<Task> getAllByUserId(Long id);

    Task update(Task task);

    Task create(Task task, Long UserId);

    void delete(Long id);
}
