package com.oficinadobrito.api.Controllers.Dtos.Creates;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class ProdutoCreateDto {
    @NotEmpty(message = "property 'name' cannot be null, is required a value")
    private String nome;

    @NotEmpty(message = "property 'unidade de medida' cannot be null, is required a value")
    private String unidadeMedida;

    @NotEmpty(message = "property 'preço' cannot be null, is required a value")
    private double preco;
}
