package com.vigrudolf.productivity.Personal_Time_Management_System.mappers;

import com.vigrudolf.productivity.Personal_Time_Management_System.dtos.UserDTO;
import com.vigrudolf.productivity.Personal_Time_Management_System.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    public User ToUserEntity(UserDTO dto);

    @Mapping(target = "createdAt", ignore = true)
    public UserDTO ToUserDTO(User user);
}
