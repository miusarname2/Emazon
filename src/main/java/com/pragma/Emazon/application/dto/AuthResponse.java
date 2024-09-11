package com.pragma.Emazon.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {

    private String username;
    private String message;
    private String jwt;
    private Boolean status;

}
