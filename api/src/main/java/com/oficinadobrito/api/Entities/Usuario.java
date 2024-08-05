package com.oficinadobrito.api.Entities;

import com.oficinadobrito.api.Controllers.Dtos.Creates.UsuarioCreateDto;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_usuarios")
public class Usuario implements UserDetails {

	@Id
    @GeneratedValue(generator = "uuid2")
    private UUID usuarioId;

    @Column(length = 50)
    private String username;

    @Column(length = 250)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String token;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) return  List.of(new SimpleGrantedAuthority("ADMIN"),new SimpleGrantedAuthority("USER"));
        else return List.of(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Usuario(){}

    public Usuario(String username, String email, String password,UserRole role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

   public static Usuario toEntity(UsuarioCreateDto dto) {
       return new Usuario(dto.getUsername(), dto.getEmail(), new BCryptPasswordEncoder().encode(dto.getPassword()),dto.getRole());
   }
}
