package com.vigrudolf.productivity.Personal_Time_Management_System.services;

import com.vigrudolf.productivity.Personal_Time_Management_System.dtos.UserDTO;
import com.vigrudolf.productivity.Personal_Time_Management_System.repositories.UserRepository;
import com.vigrudolf.productivity.Personal_Time_Management_System.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDTO> getAllUsers(){
        return null;
    }
}
