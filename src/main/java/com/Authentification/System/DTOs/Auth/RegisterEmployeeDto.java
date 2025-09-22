package com.Authentification.System.DTOs.Auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterEmployeeDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
