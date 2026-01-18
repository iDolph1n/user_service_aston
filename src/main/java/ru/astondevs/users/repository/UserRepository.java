package ru.astondevs.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.astondevs.users.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmailIgnoreCase(String email);
}
