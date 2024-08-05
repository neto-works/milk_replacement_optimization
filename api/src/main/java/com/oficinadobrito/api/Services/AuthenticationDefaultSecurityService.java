package com.oficinadobrito.api.Services;

import com.oficinadobrito.api.Repositories.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationDefaultSecurityService implements UserDetailsService {
    private final UsuarioRepository userRepository;

    public AuthenticationDefaultSecurityService(UsuarioRepository userRepository){
        this.userRepository =  userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDetails> user = this.userRepository.findByEmail(username);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }
        return user.get();
    }
}
