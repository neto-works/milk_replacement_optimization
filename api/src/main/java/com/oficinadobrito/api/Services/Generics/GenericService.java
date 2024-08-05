package com.oficinadobrito.api.Services.Generics;
import com.oficinadobrito.api.Repositories.Generics.IGenericRepository;
import com.oficinadobrito.api.Services.Interfaces.IGenericService;
import java.util.List;
import java.util.Optional;

public class GenericService<T> implements IGenericService<T> {
    IGenericRepository<T> genericRepository;

    public GenericService(IGenericRepository<T> genericRepository) {
        this.genericRepository = genericRepository;
    }

    public T createResource(T recurso){
        return this.genericRepository.save(recurso);
    }

    @Override
    public boolean deleteteResource(long id) {
        Optional<T> resourceOptional = this.genericRepository.findById(id);
        if (resourceOptional.isPresent()) {
            this.genericRepository.delete(resourceOptional.get());
            return true;
        } else {
            throw new RuntimeException("Resourcer not found with id " + id);
        }
    }

    @Override
    public T updateResource(long id,T recurso) {
        Optional<T> resourceOptional = this.genericRepository.findById(id);
        if (resourceOptional.isPresent()) {
            return this.genericRepository.save(recurso);
        } else {
            throw new RuntimeException("Resourcer not found with id " + id);
        }
    }

    @Override
    public T getResourceById(long id) {
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
