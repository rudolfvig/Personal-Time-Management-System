package com.vigrudolf.productivity.Personal_Time_Management_System.controllers;

import com.vigrudolf.productivity.Personal_Time_Management_System.dtos.CreateUserDTO;
import com.vigrudolf.productivity.Personal_Time_Management_System.dtos.UserDTO;
import com.vigrudolf.productivity.Personal_Time_Management_System.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<UserDTO> getUserByName(@PathVariable String name) {
        UserDTO user = userService.getUserByName(name);
        return ResponseEntity.ok(user);
    }

    @

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserDTO createUserDTO) {
        UserDTO savedUser = userService.createUser(createUserDTO);
        return ResponseEntity.created(URI.create("/users/" + savedUser.getId()))
                .body(savedUser);
    }




}
