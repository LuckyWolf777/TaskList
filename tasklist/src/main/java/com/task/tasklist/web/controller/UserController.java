package com.task.tasklist.web.controller;

import com.task.tasklist.model.task.Task;
import com.task.tasklist.model.user.User;
import com.task.tasklist.service.TaskService;
import com.task.tasklist.service.UserService;
import com.task.tasklist.web.dto.task.TaskDto;
import com.task.tasklist.web.dto.user.UserDto;
import com.task.tasklist.web.dto.validation.OnCreate;
import com.task.tasklist.web.dto.validation.OnUpdate;
import com.task.tasklist.web.mappers.TaskMapper;
import com.task.tasklist.web.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final TaskService taskService;

    private final UserMapper userMapper;
    private final TaskMapper taskMapper;

    @PutMapping("/{id}")
    public UserDto update (@Validated(OnUpdate.class) @RequestBody UserDto dto) {
        User user = userMapper.toEntity(dto);
        User updateUser = userService.update(user);
        return userMapper.toDto(updateUser);
    }

    @GetMapping("/{id}")
    public UserDto getById (@PathVariable Long id) {
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById (@PathVariable Long id) {
        userService.delete(id);
    }

    @GetMapping("/{id}/tasks")
    public List<TaskDto> getTaskByUserId (@PathVariable Long id) {
        List<Task> tasks = taskService.getAllByUserId(id);
        return taskMapper.toDto(tasks);
    }

    @PostMapping("/{id}/tasks")
    public TaskDto createById (@PathVariable Long id,
                               @Validated (OnCreate.class) @RequestBody TaskDto dto) {
        Task task = taskMapper.toEntity(dto);
        Task createdTask = taskService.create(task, id);
        return taskMapper.toDto(createdTask);
    }
}
