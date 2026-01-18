package ru.astondevs.users.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.astondevs.users.dto.UserCreateDto;
import ru.astondevs.users.dto.UserResponseDto;
import ru.astondevs.users.dto.UserUpdateDto;
import ru.astondevs.users.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserResponseDto getById(@PathVariable long id) {
        return userService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto create(@Valid @RequestBody UserCreateDto dto) {
        return userService.create(dto);
    }

    @PutMapping("/{id}")
    public UserResponseDto update(@PathVariable long id, @Valid @RequestBody UserUpdateDto dto) {
        return userService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        userService.delete(id);
    }
}
