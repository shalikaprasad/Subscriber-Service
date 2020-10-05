package com.fastdash.subscribers.service.impl;

import com.fastdash.subscribers.dao.RoleDao;
import com.fastdash.subscribers.dao.UserDao;
import com.fastdash.subscribers.models.Roles;
import com.fastdash.subscribers.models.Users;
import com.fastdash.subscribers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao userDao;

    @Autowired
    public RoleDao roleDao;


    @Override
    public Users getUserByUsername(String name) throws UsernameNotFoundException {
        return userDao.findByUsername(name);
    }

    @Override
    public List<Users> getAllUsers() {
        return userDao.getUserList();
    }

    @Override
    public Long deleteUser(Long id) {
        try {
            Users user = userDao.find(id);
            user.setIs_deleted(true);
            userDao.update(user);
            return id;
        }
        catch (Exception e){
            System.out.println("Cannot Find User");
            return null;
        }
    }

    @Override
    public Users createUser(Users user) {
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setCredentialsNonExpired(true);
        user.setAccountNonLocked(true);
        try {
            Users user1 = userDao.findByUsername(user.getUserName());
            long id = user1.getId();
            user.setId(id);
            return userDao.update(user);
        }catch (Exception e){
            user.setId(null);
            return userDao.create(user);
        }
    }

    @Override
    public Roles getRoleByRoleName(String roleName) {
        return roleDao.findByRoleNme(roleName);
    }

}
