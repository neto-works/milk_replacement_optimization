package com.oficinadobrito.api.Controllers.Dtos.Creates;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class GerenteCreateDto {
    @NotEmpty(message = "property 'cnpj' cannot be null, is required a value")
    private String cnpj;
}
