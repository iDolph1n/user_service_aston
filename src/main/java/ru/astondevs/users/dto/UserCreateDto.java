package ru.astondevs.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record UserCreateDto(
        String name,

        @NotBlank(message = "email must not be blank")
        @Email(message = "email must be valid")
        String email,

        @Min(value = 0, message = "age must be >= 0")
        Integer age
) {
}
