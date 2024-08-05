package com.oficinadobrito.api.Repositories.Generics;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericIdUUIDRepository<T> extends JpaRepository<T, UUID> {
}
