package com.vigrudolf.productivity.Personal_Time_Management_System.mappers;

import com.vigrudolf.productivity.Personal_Time_Management_System.dtos.UserDTO;
import com.vigrudolf.productivity.Personal_Time_Management_System.entities.User;

public class UserMapperImpl implements UserMapper {

    @Override
    public User toUserEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setCreatedAt(dto.getCreatedAt());
        user.setLastModifiedAt(dto.getLastModifiedAt());
        user.setName(dto.getName());
        user.setRole(dto.getRole());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }

    @Override
    public UserDTO toUserDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setLastModifiedAt(user.getLastModifiedAt());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setPassword(user.getPassword());
        return dto;
    }
}
