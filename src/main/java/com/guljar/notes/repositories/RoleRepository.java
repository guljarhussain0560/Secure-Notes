package com.guljar.notes.repositories;

import com.guljar.notes.model.AppRole;
import com.guljar.notes.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);
}
