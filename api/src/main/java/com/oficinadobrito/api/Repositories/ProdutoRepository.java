package com.oficinadobrito.api.Repositories;
import com.oficinadobrito.api.Entities.Produto;
import com.oficinadobrito.api.Repositories.Generics.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends IGenericRepository<Produto> {
}
