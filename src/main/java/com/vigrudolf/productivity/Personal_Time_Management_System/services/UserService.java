package com.vigrudolf.productivity.Personal_Time_Management_System.services;


import com.vigrudolf.productivity.Personal_Time_Management_System.dtos.CreateUserDTO;
import com.vigrudolf.productivity.Personal_Time_Management_System.dtos.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<UserDTO> getAllUsers();
    public UserDTO getUserById(Long id);
    public UserDTO getUserByName(String name);
    public UserDTO getUserByEmail(String email);
    public boolean deleteUserById(Long id);
    public boolean deleteUserByName(String name);
    public UserDTO createUser(CreateUserDTO createUserDTO);
    public UserDTO updateUser(Long id, UserDTO user);

}
