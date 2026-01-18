package ru.astondevs.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;

/**
 * Для обновления пользователя. Поля опциональны: null означает "не менять".
 */
public record UserUpdateDto(
        String name,
        @Email(message = "email must be valid")
        String email,
        @Min(value = 0, message = "age must be >= 0")
        Integer age
) {
}
