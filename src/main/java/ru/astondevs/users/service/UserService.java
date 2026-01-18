package ru.astondevs.users.service;

import ru.astondevs.users.dto.UserCreateDto;
import ru.astondevs.users.dto.UserResponseDto;
import ru.astondevs.users.dto.UserUpdateDto;

import java.util.List;

public interface UserService {
    UserResponseDto create(UserCreateDto dto);

    UserResponseDto getById(long id);

    List<UserResponseDto> getAll();

    UserResponseDto update(long id, UserUpdateDto dto);

    void delete(long id);
}
