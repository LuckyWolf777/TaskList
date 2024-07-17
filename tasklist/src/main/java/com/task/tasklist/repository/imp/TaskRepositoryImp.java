package com.task.tasklist.repository.imp;

import com.task.tasklist.model.task.Task;
import com.task.tasklist.repository.TaskRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepositoryImp implements TaskRepository {
    @Override
    public Optional<Task> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Task> findAllByUserID(Long id) {
        return List.of();
    }

    @Override
    public void assignToUserById(Long taskId, Long userId) {

    }

    @Override
    public void update(Task Task) {

    }

    @Override
    public void creat(Task Task) {

    }

    @Override
    public void delete(Long id) {

    }
}
