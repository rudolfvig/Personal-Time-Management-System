package com.vigrudolf.productivity.Personal_Time_Management_System.services;

import com.vigrudolf.productivity.Personal_Time_Management_System.dtos.CreateUserDTO;
import com.vigrudolf.productivity.Personal_Time_Management_System.dtos.UpdateUserPasswordDTO;
import com.vigrudolf.productivity.Personal_Time_Management_System.dtos.UserDTO;
import com.vigrudolf.productivity.Personal_Time_Management_System.entities.User;
import com.vigrudolf.productivity.Personal_Time_Management_System.exception.*;
import com.vigrudolf.productivity.Personal_Time_Management_System.repositories.UserRepository;
import com.vigrudolf.productivity.Personal_Time_Management_System.mappers.UserMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
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
    public UserDTO getUserByName(String name) {
        User user = userRepository.findByName(name)
                .orElseThrow(() -> new UserNotFoundException("User not found with name: " + name));

        // Check if there are multiple users with the same name
        if (userRepository.countByName(name) > 1) {
            throw new DuplicateUserNameException("Multiple users found with the name: " + name);
        }

        return userMapper.toUserDTO(user);
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));

        return userMapper.toUserDTO(user);
    }

    @Override
    public boolean deleteUserById(Long id) {
        try {
            userRepository.findById(id)
                    .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

            userRepository.deleteById(id);

            return true;

        } catch (UserDeleteException e){
            return false;
        } catch (Exception e){
            throw new UserDeleteException("An unexpected error occurred while deleting user with id: " + id, e);
        }
    }

    @Override
    public boolean deleteUserByName(String name) {
        try {
            userRepository.findByName(name)
                    .orElseThrow(() -> new UserNotFoundException("User not found with name: " + name));

            userRepository.deleteByName(name);

            return true;

        } catch (UserDeleteException e){
            return false;
        } catch (Exception e){
            throw new UserDeleteException("An unexpected error occurred while deleting user with name: " + name, e);
        }
    }

    @Override
    public UserDTO createUser(@Valid CreateUserDTO createUserDTO) {
        User createdUser = User.builder()
                        .createdAt(LocalDateTime.now())
                        .name(createUserDTO.getName())
                        .email(createUserDTO.getEmail())
                        .password(passwordEncoder.encode(createUserDTO.getPassword()))
                        .role(createUserDTO.getRole())
                        .lastModifiedAt(LocalDateTime.now())
                        .build();

        User savedUser = userRepository.save(createdUser);
        return userMapper.toUserDTO(savedUser);

    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User userToUpdate = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User to update is not found with id: " + id));

        userToUpdate.setLastModifiedAt(LocalDateTime.now());

        // Validate and update name
        if (userDTO.getName() != null) {
            if (userDTO.getName().trim().isEmpty()) {
                throw new UserUpdateException("Name cannot be blank.", null);
            }
            userToUpdate.setName(userDTO.getName());
        }

        // Validate and update email
        if (userDTO.getEmail() != null) {
            if (!userDTO.getEmail().contains("@")) {
                throw new InvalidEmailFormatException("Invalid email format: " + userDTO.getEmail());
            }
            if (userRepository.existsByEmail(userDTO.getEmail())) {
                throw new DuplicateEmailException("Email is already taken: " + userDTO.getEmail());
            }
            userToUpdate.setEmail(userDTO.getEmail());
        }

        User updatedUser = userRepository.save(userToUpdate);
        return userMapper.toUserDTO(updatedUser);
    }

    @Override
    public void updateUserPassword(Long userId, UpdateUserPasswordDTO updateUserPasswordDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (!passwordEncoder.matches(updateUserPasswordDTO.getOldPassword(), user.getPassword())) {
            throw new UpdatePasswordException("Old password is incorrect");
        }

        user.setPassword(passwordEncoder.encode(updateUserPasswordDTO.getNewPassword()));
        user.setLastModifiedAt(LocalDateTime.now());
        userRepository.save(user);
    }

}
