package com.oficinadobrito.api.Services.Generics;

import com.oficinadobrito.api.Repositories.Generics.IGenericIdUUIDRepository;
import com.oficinadobrito.api.Services.Interfaces.IGenericUsersService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class GenericUsersService<T> implements IGenericUsersService<T> {
    IGenericIdUUIDRepository<T> genericRepository;

    public GenericUsersService(IGenericIdUUIDRepository<T> genericRepository) {
        this.genericRepository = genericRepository;
    }

    public T createResource(T recurso){
        return this.genericRepository.save(recurso);
    }

    @Override
    public boolean deleteteResource(UUID id) {
        Optional<T> resourceOptional = this.genericRepository.findById(id);
        if (resourceOptional.isPresent()) {
            this.genericRepository.delete(resourceOptional.get());
            return true;
        } else {
            throw new RuntimeException("Resourcer not found with id " + id);
        }
    }

    @Override
    public T updateResource(UUID id,T recurso) {
        Optional<T> resourceOptional = this.genericRepository.findById(id);
        if (resourceOptional.isPresent()) {
            return this.genericRepository.save(recurso);
        } else {
            throw new RuntimeException("Resourcer not found with id " + id);
        }
    }

    @Override
    public T getResourceById(UUID id) {
        Optional<T> resourceOptional = this.genericRepository.findById(id);
        if (resourceOptional.isPresent()) {
            return resourceOptional.get();
        } else {
            throw new RuntimeException("Resourcer not found with id " + id);
        }
    }

    @Override
    public List<T> getAllResources() {
        return this.genericRepository.findAll();
    }
}
