package com.oficinadobrito.api.Controllers.Dtos.Updates;

import lombok.Data;

@Data
public class VendedorUpdateDto {
    private String local;
    private String cpf;
    private double totalKmAteCidade;
}
