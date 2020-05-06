package com.example.chat.task.repository;

import com.example.chat.task.model.Status;
import com.example.chat.task.model.StatusName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Optional<Status> findByName(StatusName statusName);
}
