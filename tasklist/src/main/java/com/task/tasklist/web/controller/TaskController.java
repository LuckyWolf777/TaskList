package com.task.tasklist.web.controller;

import com.task.tasklist.model.task.Task;
import com.task.tasklist.service.TaskService;
import com.task.tasklist.web.dto.task.TaskDto;
import com.task.tasklist.web.dto.validation.OnCreate;
import com.task.tasklist.web.mappers.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @GetMapping("/{id}")
    public TaskDto getById (@PathVariable Long id){
        Task task = taskService.getById(id);
        return taskMapper.toDto(task);
    }

    @DeleteMapping("/{id}")
    public void deleteById (@PathVariable Long id) {
        taskService.delete(id);
    }

    @PutMapping("/{id}/tasks")
    public TaskDto update (@Validated(OnCreate.class) @RequestBody TaskDto dto) {
        Task task = taskMapper.toEntity(dto);
        Task updateTusk = taskService.update(task);
        return taskMapper.toDto(updateTusk);
    }

//    @PostMapping("/{id}/tasks")
//    public TaskDto createTask(@PathVariable Long id, @Validated(OnCreate.class) @RequestBody TaskDto dto) {
//        Task task = taskMapper.toEntity(dto);
//        Task createTask = taskService.create(task, id);
//        return taskMapper.toDto(createTask);
//    }

}
