package ru.astondevs.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.astondevs.users.dto.UserCreateDto;
import ru.astondevs.users.dto.UserResponseDto;
import ru.astondevs.users.dto.UserUpdateDto;
import ru.astondevs.users.entity.User;
import ru.astondevs.users.mapper.UserMapper;
import ru.astondevs.users.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto create(UserCreateDto dto) {
        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setAge(dto.age());

        try {
            User saved = userRepository.save(user);
            return UserMapper.toDto(saved);
        } catch (DataIntegrityViolationException e) {
            // например, unique constraint на email
            throw new IllegalArgumentException("User with such email already exists");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponseDto getById(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found: " + id));
        return UserMapper.toDto(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponseDto> getAll() {
        return userRepository.findAll().stream()
                .map(UserMapper::toDto)
                .toList();
    }

    @Override
    public UserResponseDto update(long id, UserUpdateDto dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found: " + id));

        if (dto.name() != null) user.setName(dto.name());
        if (dto.email() != null) user.setEmail(dto.email());
        if (dto.age() != null) user.setAge(dto.age());

        try {
            User saved = userRepository.save(user);
            return UserMapper.toDto(saved);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("User with such email already exists");
        }
    }

    @Override
    public void delete(long id) {
        if (!userRepository.existsById(id)) {
            throw new NoSuchElementException("User not found: " + id);
        }
        userRepository.deleteById(id);
    }
}
