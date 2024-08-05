package com.oficinadobrito.api.Controllers.Dtos;

import lombok.Data;

@Data
public class LoginDto {
    String email;
    String password;

    public LoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
