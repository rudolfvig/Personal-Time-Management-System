package com.vigrudolf.productivity.Personal_Time_Management_System.services;


import com.vigrudolf.productivity.Personal_Time_Management_System.dtos.CreateUserDTO;
import com.vigrudolf.productivity.Personal_Time_Management_System.dtos.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<UserDTO> getAllUsers();
    public UserDTO getUserById(Long id);
    public Optional<UserDTO> getUserByName(String name);
    public Optional<UserDTO> getUserByEmail(String email);
    public void deleteUserById(Long id);
    public boolean deleteUserByName(String name);
    public UserDTO createUser(UserDTO user);
    public UserDTO updateUser(Long id, UserDTO user);

}
