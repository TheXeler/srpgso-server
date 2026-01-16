package org.thexeler.srpgsoserver.repository;

import org.thexeler.srpgsoserver.dto.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
