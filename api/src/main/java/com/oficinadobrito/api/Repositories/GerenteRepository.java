package com.oficinadobrito.api.Repositories;

import com.oficinadobrito.api.Entities.Gerente;
import com.oficinadobrito.api.Repositories.Generics.IGenericIdUUIDRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenteRepository extends IGenericIdUUIDRepository<Gerente> {
}
