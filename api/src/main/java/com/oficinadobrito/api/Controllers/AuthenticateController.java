package com.oficinadobrito.api.Controllers;

import com.oficinadobrito.api.Controllers.Dtos.Creates.UsuarioCreateDto;
import com.oficinadobrito.api.Controllers.Dtos.LoginDto;
import com.oficinadobrito.api.Controllers.Dtos.TokenResponse;
import com.oficinadobrito.api.Entities.UserRole;
import com.oficinadobrito.api.Entities.Usuario;
import com.oficinadobrito.api.Entities.Vendedor;
import com.oficinadobrito.api.Services.UsuarioService;
import com.oficinadobrito.api.Services.VendedorServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Autenticação de usuarios", description = "All endpoints related to the resource")
@RestController
@RequestMapping("/auth")
public class AuthenticateController {
    private Vendedor vend;
    private Usuario user;

    @Autowired
    private UsuarioService userService;
    @Autowired
    private VendedorServices vendedorServices;


    @PermitAll
    @PostMapping("/login")
    public ResponseEntity<TokenResponse> autenticar(@RequestBody LoginDto usuario) {
        var token = this.userService.authenticarusuario(usuario);
        if (token.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new TokenResponse("User with credentials not found or invalid"));
        }
        TokenResponse tokenResponse = new TokenResponse(token);
        return ResponseEntity.ok().body(tokenResponse);
    }

    @PermitAll
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UsuarioCreateDto userDto) {
        this.user = Usuario.toEntity(userDto);
        try {
            switch (user.getRole()) {
                case UserRole.USER:
                    user = this.userService.createNewUser(user);
                    break;
                case UserRole.VENDEDOR:
                    this.vend = this.vendedorServices.createResource(Vendedor.copyByUsuario(user));
                    break;
                default:
                    return ResponseEntity.badRequest().body("Role inválido");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao criar usuário: " + e.getMessage());
        }

        return ResponseEntity.ok(user);
    }
}
