package com.oficinadobrito.api.Controllers;

import com.oficinadobrito.api.Controllers.Dtos.OptimizationRequestData;
import com.oficinadobrito.api.Entities.Optimization;
import com.oficinadobrito.api.Services.OptimizationServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@Tag(name = "Optimizations", description = "All endpoints related to the resource")
@RestController
@RequestMapping("/optimizations")
public class OptimizationController {

    @Autowired
    private OptimizationServices optimizationServices;

    @PermitAll
    @Operation(summary = "optimization buying")
    @Async
    @PostMapping("/optimizeValues")
    public CompletableFuture<Optimization> otimizationAsyncDispostoAGastar(@RequestBody OptimizationRequestData dados) {
        return this.optimizationServices.otimizationAsyncDispostoAGastarObterMaxValue(dados);
    }


    @PermitAll
    @Operation(summary = "optimization kilometros")
    @Async
    @PostMapping("/optimizeKilometros")
    public CompletableFuture<Optimization> otimizationAsyncOtimizationKilometragem(@RequestBody OptimizationRequestData dados) {
        return this.optimizationServices.otimizationKilometragem(dados);
    }
}
