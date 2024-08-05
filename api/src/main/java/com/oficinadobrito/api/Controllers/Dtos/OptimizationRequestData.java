package com.oficinadobrito.api.Controllers.Dtos;

import lombok.Data;

@Data
public class OptimizationRequestData {
    private double valorPretendido;
    private double valorGasto;
    private double valorLeite;
    private double valorQueijo;
    private int valorMaxQueijoVende;
}
