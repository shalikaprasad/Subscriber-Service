package com.fastdash.subscribers.service;

import com.fastdash.subscribers.models.Roles;
import com.fastdash.subscribers.models.Users;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * Created by Prasad on 12/15/19.
 */
public interface UserService {

    Users getUserByUsername(String name) throws UsernameNotFoundException;

    List<Users> getAllUsers();

    Long deleteUser(Long valueOf);

    Users createUser(Users user);

    Roles getRoleByRoleName(String roleName);
}

