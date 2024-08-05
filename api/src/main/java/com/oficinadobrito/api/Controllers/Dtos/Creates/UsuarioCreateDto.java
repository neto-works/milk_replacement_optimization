package com.oficinadobrito.api.Controllers.Dtos.Creates;

import com.oficinadobrito.api.Entities.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UsuarioCreateDto {
    @NotEmpty(message = "property 'username' cannot be null, is required a value")
    private String username;

    @Email(message = "property 'email' cannot be null, is required a value, a valid email")
    private String email;

    @NotEmpty(message = "property 'Password' cannot be null, is required a value")
    private String password;

    @NotEmpty(message = "property 'Role' cannot be null, is required a value")
    private UserRole role;

}
