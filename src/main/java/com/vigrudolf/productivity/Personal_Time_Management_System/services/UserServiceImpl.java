package com.vigrudolf.productivity.Personal_Time_Management_System.services;

import com.vigrudolf.productivity.Personal_Time_Management_System.dtos.CreateUserDTO;
import com.vigrudolf.productivity.Personal_Time_Management_System.dtos.UserDTO;
import com.vigrudolf.productivity.Personal_Time_Management_System.repositories.UserRepository;
import com.vigrudolf.productivity.Personal_Time_Management_System.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

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

    @Override
    public Optional<UserDTO> getUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDTO> getUserByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDTO> getUserByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public boolean deleteUserByName(String name) {
        return false;
    }

    @Override
    public UserDTO createUser(CreateUserDTO user) {
        return null;
    }

    @Override
    public UserDTO updateUser(Long id, CreateUserDTO user) {
        return null;
    }

    @Override
    public UserDTO updateUserLevel(Long id, int deltaValue) {
        return null;
    }
}
