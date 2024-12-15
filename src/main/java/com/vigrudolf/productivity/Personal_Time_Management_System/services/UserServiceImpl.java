package com.vigrudolf.productivity.Personal_Time_Management_System.services;

import com.vigrudolf.productivity.Personal_Time_Management_System.dtos.UserDTO;
import com.vigrudolf.productivity.Personal_Time_Management_System.entities.User;
import com.vigrudolf.productivity.Personal_Time_Management_System.exception.UserNotFoundException;
import com.vigrudolf.productivity.Personal_Time_Management_System.repositories.UserRepository;
import com.vigrudolf.productivity.Personal_Time_Management_System.mappers.UserMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        return userRepository.findAll().stream()
                .map(userMapper::toUserDTO)
                .toList();
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

           return userMapper.toUserDTO(user);
    }

    @Override
    public Optional<UserDTO> getUserByName(String name) {
        User user = userRepository.findByName(name);
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
    public UserDTO createUser(@Valid UserDTO userDTO) {
        try{
            User createdUser = userMapper.toUserEntity(userDTO);
            createdUser.setCreatedAt(LocalDateTime.now());
            createdUser.setLastModifiedAt(LocalDateTime.now());
            User savedUser = userRepository.save(createdUser);
            return userMapper.toUserDTO(savedUser);
        } catch (Exception e){
            throw new RuntimeException("Failed to create user", e);
        }
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        try {

        }catch (Exception e){
            throw new RuntimeException("Failed to update user", e);
        }
    }

}
