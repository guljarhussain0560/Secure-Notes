package com.guljar.notes.services;

import com.guljar.notes.dtos.UserDto;
import com.guljar.notes.model.Role;
import com.guljar.notes.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void updateUserRole(Long userId, String roleName);

    List<User> getAllUsers();

    UserDto getUser(Long id);

    User findByUsername(String username);

    void updatePassword(Long userId, String password);

    void updateAccountLockStatus(Long userId, boolean lock);

    void updateAccountExpiryStatus(Long userId, boolean expire);

    void updateAccountEnabledStatus(Long userId, boolean enabled);

    void updateCredentialsExpiryStatus(Long userId, boolean expire);

    List<Role> getAllRoles();
}
