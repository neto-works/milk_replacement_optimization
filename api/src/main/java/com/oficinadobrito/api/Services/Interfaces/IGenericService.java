package com.oficinadobrito.api.Services.Interfaces;

import java.util.List;

public interface IGenericService<T> {
    T createResource(T recurso);
    boolean deleteteResource(long id);
    T updateResource(long id, T recurso);
    T getResourceById(long id);
    List<T> getAllResources();

}
