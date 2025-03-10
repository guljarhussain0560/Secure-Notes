package com.guljar.notes.services;

import com.guljar.notes.dtos.UserDto;
import com.guljar.notes.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void updateUserRole(Long userId, String roleName);

    List<User> getAllUsers();

    UserDto getUser(Long id);

    User findByUsername(String username);
}
