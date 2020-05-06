package com.example.chat.task.repository;

import com.example.chat.task.model.Project;
import com.example.chat.task.model.Task;
import com.example.chat.task.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByNameOrderByDateDesc(User user);


    Page<Task> findByCreatedBy(Long userId,Pageable pageable);
}
