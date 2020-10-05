package com.fastdash.subscribers.service;

import com.fastdash.subscribers.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByUserName(String s);
}
