package com.pragma.Emazon.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthCreateUserRequest {

    private String username;
    private String password;

}
