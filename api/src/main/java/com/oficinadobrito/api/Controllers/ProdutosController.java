package com.oficinadobrito.api.Controllers;
import com.oficinadobrito.api.Controllers.Dtos.Creates.ProdutoCreateDto;
import com.oficinadobrito.api.Controllers.Dtos.Updates.ProdutoUpdateDto;
import com.oficinadobrito.api.Controllers.Interfaces.ICrudController;
import com.oficinadobrito.api.Entities.Produto;
import com.oficinadobrito.api.Services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Produtos", description = "All endpoints related to the resource")
@RestController
@RequestMapping("/produtos")
public class ProdutosController implements ICrudController<Produto, ProdutoCreateDto, ProdutoUpdateDto> {

    @Autowired
    private ProdutoService produtoService;

    @Operation(summary = "get all products")
    @SecurityRequirement(name = "JWT")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping()
    @Override
    public ResponseEntity<List<Produto>> getAllResource() {
        List<Produto> produtos = this.produtoService.getAllResources();
        return ResponseEntity.ok(produtos);
    }

    @Operation(summary = "create one product")
    @PermitAll
    @PostMapping()
    @Override
    public ResponseEntity<Produto> postResource(@RequestBody @Valid ProdutoCreateDto resource) {
        Produto produto = Produto.toEntity(resource);
        produto = this.produtoService.createResource(produto);
        return ResponseEntity.ok(produto);
    }

    @Operation(summary = "update a product with this id")
    @PreAuthorize("hasRole('VENDEDOR')")
    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Produto> updateResource(@PathVariable("id") long id , @RequestBody ProdutoUpdateDto resource) {
        Produto produtoUpd = Produto.toEntity(resource);
        produtoUpd = this.produtoService.updateResource(id, produtoUpd);
        return ResponseEntity.ok(produtoUpd);
    }

    @Operation(summary = "delete a product with this id")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> deleteResourceById(@PathVariable("id") long id) {
        boolean produtoDeletadoh = this.produtoService.deleteteResource(id);
        if(produtoDeletadoh){ ResponseEntity.noContent().build();}
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "get one product with this id")
    @PreAuthorize("hasRole('VENDEDOR')")
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Produto> getResourceById(long id) {
        Produto p = this.produtoService.getResourceById(id);
        return ResponseEntity.ok(p);
    }
}
