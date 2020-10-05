package com.fastdash.subscribers.controller;

import com.fastdash.subscribers.dto.UserDto;
import com.fastdash.subscribers.models.Roles;
import com.fastdash.subscribers.models.Users;
import com.fastdash.subscribers.rest.response.ResponseWrapper;
import com.fastdash.subscribers.service.UserService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prasad on 12/15/19.
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/api/user")
@Api(value = "user", tags = "User Controller")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public ResponseWrapper getUser(Authentication authentication) {
        logger.info(">> Getting User");
        Users user = userService.getUserByUsername(authentication.getName());
        return ResponseWrapper.success(user);
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public ResponseWrapper getAllUsers(Authentication authentication) {
        logger.info(">> Getting User");
        Users user = userService.getUserByUsername(authentication.getName());
        if(user != null){
            List<Users> userList = userService.getAllUsers();
            return ResponseWrapper.success(userList);
        }
        else {
            return null;
        }
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ResponseWrapper deleteUser(Authentication authentication, @RequestParam("userId") String id) {
        logger.info(">> Getting User");
        Users user = userService.getUserByUsername(authentication.getName());
        if(user != null){
            return ResponseWrapper.success(userService.deleteUser(Long.valueOf(id)));
        }
        else {
            return null;
        }
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public ResponseWrapper createUser(Authentication authentication, @RequestBody UserDto userDto) {
        logger.info(">> Getting User");
        Users user = userService.getUserByUsername(authentication.getName());

        if(user != null){
            userDto.setCreatedUserId(user.getId());
            ModelMapper modelMapper = new ModelMapper();
            Users user1 = modelMapper.map(userDto, Users.class);
            user1.setId(userDto.getId());
            user1.setIs_deleted(false);
            Roles role = userService.getRoleByRoleName(userDto.getRoles());
            List<Roles> roleList = new ArrayList<>();
            roleList.add(role);
            user1.setRoles(roleList);
            user1.setPassword(passwordEncoder.encode(userDto.getPassword()));
            return ResponseWrapper.success(userService.createUser(user1));
        }
        else {
            return null;
        }
    }


}
