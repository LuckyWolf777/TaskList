package com.task.tasklist.web.mappers;

import com.task.tasklist.model.user.User;
import com.task.tasklist.web.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto dto);
}
