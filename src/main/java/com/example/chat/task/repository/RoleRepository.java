package com.example.chat.task.repository;

import com.example.chat.task.model.Role;
import com.example.chat.task.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{
    Optional<Role> findByName(RoleName roleName);
}
