package com.guljar.notes.services.impl;

import com.guljar.notes.dtos.UserDto;
import com.guljar.notes.model.AppRole;
import com.guljar.notes.model.Role;
import com.guljar.notes.model.User;
import com.guljar.notes.repositories.RoleRepository;
import com.guljar.notes.repositories.UserRepository;
import com.guljar.notes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void updateUserRole(Long userId, String roleName){
        User user = userRepository.findById(userId).orElseThrow(() ->
                new RuntimeException("User not found"));
        AppRole appRole = AppRole.valueOf(roleName);
        Role role = roleRepository.findByRoleName(appRole).orElseThrow(() ->
                new RuntimeException("Role not found"));
        user.setRole(role);
        userRepository.save(user);

    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public UserDto getUser(Long id){
        User user = userRepository.findById(id).orElseThrow();
        return convertToDto(user);

    }

    private UserDto convertToDto(User user) {
        return new UserDto(
                user.getUserId(),
                user.getUserName(),
                user.getEmail(),
                user.isAccountNonLocked(),
                user.isAccountNonExpired(),
                user.isCredentialsNonExpired(),
                user.isEnabled(),
                user.getCredentialExpiryDate(),
                user.getAccountExpiryDate(),
                user.getTwoFactorSecret(),
                user.isTwoFactorEnabled(),
                user.getSignUpMethod(),
                user.getRole(),
                user.getCreatedDate(),
                user.getUpdateDate()

        );
    }
}
