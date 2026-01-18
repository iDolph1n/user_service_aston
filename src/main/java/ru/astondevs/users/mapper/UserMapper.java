package ru.astondevs.users.mapper;

import ru.astondevs.users.dto.UserResponseDto;
import ru.astondevs.users.entity.User;

public final class UserMapper {

    private UserMapper() {
    }

    public static UserResponseDto toDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .age(user.getAge())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
