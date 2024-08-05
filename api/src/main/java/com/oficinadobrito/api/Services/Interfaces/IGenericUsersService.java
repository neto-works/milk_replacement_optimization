package com.oficinadobrito.api.Services.Interfaces;

import java.util.List;
import java.util.UUID;

public interface IGenericUsersService<T> {
    T createResource(T recurso);
    boolean deleteteResource(UUID id);
    T updateResource(UUID id, T recurso);
    T getResourceById(UUID id);
    List<T> getAllResources();

}
