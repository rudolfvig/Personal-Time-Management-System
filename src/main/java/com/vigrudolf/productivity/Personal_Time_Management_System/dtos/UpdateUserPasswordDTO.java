package com.vigrudolf.productivity.Personal_Time_Management_System.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateUserPasswordDTO {

    @NotBlank
    @Size(min = 8, max = 50, message = "the given password is invalid, min 4 character, max 50 character")
    private String oldPassword;
    @NotBlank
    @Size(min = 8, max = 50, message = "the given password is invalid, min 4 character, max 50 character")
    private String newPassword;

}
