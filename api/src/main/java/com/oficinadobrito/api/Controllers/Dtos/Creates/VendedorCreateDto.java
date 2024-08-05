package com.oficinadobrito.api.Controllers.Dtos.Creates;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import org.hibernate.validator.constraints.br.CPF;

@Data
public class VendedorCreateDto {
    @NotEmpty(message = "property 'local' cannot be null, is required a value")
    private String local;

    @CPF(message = "property 'CPF' cannot be null, is required a value")
    private String cpf;

	private double totalKmAteCidade;

}
