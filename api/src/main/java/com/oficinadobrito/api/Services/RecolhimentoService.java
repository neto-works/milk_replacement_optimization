package com.oficinadobrito.api.Services;

import com.oficinadobrito.api.Entities.Recolhimento;
import com.oficinadobrito.api.Repositories.RecolhimentoRepository;
import com.oficinadobrito.api.Services.Generics.GenericService;
import org.springframework.stereotype.Service;

@Service
public class RecolhimentoService extends GenericService<Recolhimento> {
    public RecolhimentoService(RecolhimentoRepository recolhimentoRepository){super(recolhimentoRepository);}
}
