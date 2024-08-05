package com.oficinadobrito.api.Controllers;

import com.oficinadobrito.api.Controllers.Dtos.Creates.VendedorCreateDto;
import com.oficinadobrito.api.Controllers.Dtos.Updates.VendedorUpdateDto;
import com.oficinadobrito.api.Controllers.Interfaces.ICrudUsersController;
import com.oficinadobrito.api.Entities.Vendedor;
import com.oficinadobrito.api.Services.VendedorServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Vendedores", description = "All endpoints related to the resource")
@RestController
@RequestMapping("/vendedores")
public class VendedoresController implements ICrudUsersController<Vendedor, VendedorCreateDto, VendedorUpdateDto> {

    @Autowired
    private VendedorServices vendedorService;

    @Operation(summary = "get all vendedors")
    @PermitAll
    @GetMapping()
    @Override
    public ResponseEntity<List<Vendedor>> getAllResource() {
        List<Vendedor> vendedores = this.vendedorService.getAllResources();
        return ResponseEntity.ok(vendedores);
    }

    @Operation(summary = "update a vendedor with this id")
    @PreAuthorize("hasRole('VENDEDOR')")
    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Vendedor> updateResource(@PathVariable("id") UUID id , @RequestBody VendedorUpdateDto resource) {
        Vendedor vendedorUpd = Vendedor.toEntity(resource);
        vendedorUpd = this.vendedorService.updateResource(id, vendedorUpd);
        return ResponseEntity.ok(vendedorUpd);
    }

    @Operation(summary = "delete a vendedor with this id")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> deleteResourceById(@PathVariable("id") UUID id) {
        boolean vendedorDeletadoh = this.vendedorService.deleteteResource(id);
        if(vendedorDeletadoh){ ResponseEntity.noContent().build();}
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "get one vendedor with this id")
    @PreAuthorize("hasRole('VENDEDOR')")
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Vendedor> getResourceById(UUID id) {
        Vendedor p = this.vendedorService.getResourceById(id);
        return ResponseEntity.ok(p);
    }
}
