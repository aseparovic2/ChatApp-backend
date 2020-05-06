package com.example.chat.task.repository;

import com.example.chat.task.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository  extends JpaRepository<Project, Long>{

    List<Project> findByName(Project project);

}
