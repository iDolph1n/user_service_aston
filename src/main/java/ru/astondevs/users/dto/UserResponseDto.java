package ru.astondevs.users.dto;

import lombok.Builder;
import java.time.LocalDateTime;

@Builder
public record UserResponseDto(
        long id,
        String name,
        String email,
        Integer age,
        LocalDateTime createdAt
) {
}
