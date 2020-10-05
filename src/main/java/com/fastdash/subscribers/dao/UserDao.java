package com.fastdash.subscribers.dao;

import com.fastdash.subscribers.models.Users;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao extends CRUDDao<Users>{

    Users findByUsername(String username);

    List<Users> getUserList();

}
