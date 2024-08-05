package com.oficinadobrito.api.Repositories;

import com.oficinadobrito.api.Entities.Recolhimento;
import com.oficinadobrito.api.Repositories.Generics.IGenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecolhimentoRepository extends IGenericRepository<Recolhimento> {
    @Query(value = "SELECT r FROM Recolhimento r JOIN r.produtos p WHERE p.preco >= :precoEstimado AND r.quantidade >= :quant")
    List<Recolhimento> findRecolhimentoWithProdutosMinKilometr(@Param("precoEstimado") double precoEstimado, @Param("quant") int quant);
}
