package com.example.chat.task.repository;

import com.example.chat.task.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsernameOrEmail(String username, String email);

    List<User> findByIdIn(List<Long> userID);

    Optional<User> findByUsername(String username);
    Optional<User> findByFirstName(String firstName);
    Optional<User> findByLastName(String lastName);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
