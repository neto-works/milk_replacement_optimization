package com.oficinadobrito.api.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oficinadobrito.api.Entities.Vendedor;
import com.oficinadobrito.api.Repositories.Generics.IGenericIdUUIDRepository;

import java.util.List;

@Repository
public interface VendedorRepository extends IGenericIdUUIDRepository<Vendedor> {
    @Query(value = "SELECT v.* FROM Vendedor v JOIN Produto p ON v.id = p.vendedor_id WHERE p.preco <= :valor ORDER BY p.preco ASC", nativeQuery = true)
    List<Vendedor> findVendedoresWithProdutosBelowPrice(@Param("valor") double valor);
}
