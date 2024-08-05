package com.oficinadobrito.api.Services;

import com.oficinadobrito.api.Services.Generics.GenericUsersService;
import org.springframework.stereotype.Service;
import com.oficinadobrito.api.Entities.Gerente;
import com.oficinadobrito.api.Repositories.GerenteRepository;

@Service
public class GerenteServices extends GenericUsersService<Gerente> {
    public GerenteServices(GerenteRepository gerenteRepository){
        super(gerenteRepository);
    }
}
