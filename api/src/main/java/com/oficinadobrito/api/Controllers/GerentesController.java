package com.oficinadobrito.api.Controllers;

import com.oficinadobrito.api.Controllers.Dtos.Creates.GerenteCreateDto;
import com.oficinadobrito.api.Controllers.Dtos.Updates.GerenteUpdateDto;
import com.oficinadobrito.api.Controllers.Interfaces.ICrudUsersController;
import com.oficinadobrito.api.Entities.Gerente;
import com.oficinadobrito.api.Services.GerenteServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@Tag(name = "Gerentes", description = "All endpoints related to the resource")
@RestController
@RequestMapping("/Gerentes")
public class GerentesController implements ICrudUsersController<Gerente, GerenteCreateDto, GerenteUpdateDto> {

    @Autowired
    private GerenteServices GerenteService;

    @Operation(summary = "get all Gerentes")
    @PermitAll
    @GetMapping()
    @Override
    public ResponseEntity<List<Gerente>> getAllResource() {
        List<Gerente> gerentes = this.GerenteService.getAllResources();
        return ResponseEntity.ok(gerentes);
    }
    
    @Operation(summary = "update a Gerente with this id")
    @PreAuthorize("hasRole('Gerente')")
    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Gerente> updateResource(@PathVariable("id") UUID id , @RequestBody GerenteUpdateDto resource) {
        Gerente gerenteUpd = Gerente.toEntity(resource);
        gerenteUpd = this.GerenteService.updateResource(id, gerenteUpd);
        return ResponseEntity.ok(gerenteUpd);
    }

    @Operation(summary = "delete a Gerente with this id")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> deleteResourceById(@PathVariable("id") UUID id) {
        boolean gerenteDeletadoh = this.GerenteService.deleteteResource(id);
        if(gerenteDeletadoh){ ResponseEntity.noContent().build();}
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "get one Gerente with this id")
    @PreAuthorize("hasRole('Gerente')")
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Gerente> getResourceById(UUID id) {
        Gerente p = this.GerenteService.getResourceById(id);
        return ResponseEntity.ok(p);
    }
}
