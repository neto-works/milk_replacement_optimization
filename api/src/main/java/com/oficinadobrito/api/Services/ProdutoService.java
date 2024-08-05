package com.oficinadobrito.api.Services;

import com.oficinadobrito.api.Entities.Produto;
import com.oficinadobrito.api.Repositories.ProdutoRepository;
import com.oficinadobrito.api.Services.Generics.GenericService;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService extends GenericService<Produto> {
    public ProdutoService(ProdutoRepository produtoRepository) {
        super(produtoRepository);
    }
}
