package com.oficinadobrito.api.Services;

import com.oficinadobrito.api.Services.Generics.GenericUsersService;
import org.springframework.stereotype.Service;
import com.oficinadobrito.api.Entities.Vendedor;
import com.oficinadobrito.api.Repositories.VendedorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendedorServices extends GenericUsersService<Vendedor> {
    private final VendedorRepository vendedorRepository;

    public VendedorServices(VendedorRepository vendedorRepository) {
        super(vendedorRepository);
        this.vendedorRepository = vendedorRepository;
    }

    public List<Vendedor> findTopXVendedoresWithProdutosBelowPrice(double valor, int limiter) {
        List<Vendedor> vendedores = this.vendedorRepository.findVendedoresWithProdutosBelowPrice(valor);
        return vendedores.stream().limit(limiter).collect(Collectors.toList());
    }
}
