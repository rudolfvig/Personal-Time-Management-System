package com.vigrudolf.productivity.Personal_Time_Management_System.services;


import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<UserDTO> getAllUsers();
    public Optional<UserDTO> getUserById(Long id);
    public Optional<UserDTO> getUserByName(String name);
    public Optional<UserDTO> getUserByEmail(String email);
    public void deleteUserById(Long id);
    public boolean deleteUserByName(String name);
    public UserDTO createUser(UserCreateDTO user);
    public UserDTO updateUser(Long id, UserCreateDTO user);
    public UserDTO updateUserLevel(Long id, int deltaValue);

}
