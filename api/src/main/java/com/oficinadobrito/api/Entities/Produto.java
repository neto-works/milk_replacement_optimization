package com.oficinadobrito.api.Entities;

import com.oficinadobrito.api.Controllers.Dtos.Creates.ProdutoCreateDto;
import com.oficinadobrito.api.Controllers.Dtos.Updates.ProdutoUpdateDto;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_produtos")
public class Produto implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long produtoId;

	@Column(length = 100)
	private String nome;

	@Column(length = 50)
	private String unidadeMedida;

	private double preco;

	private boolean precisaManutencao;

	private int quantidadeMesesAteManutencao;

	@ManyToMany(mappedBy = "produtos")
	private List<Vendedor> vendedores;

	@ManyToMany
	@JoinTable(name = "produto_recolhimento", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "recolhimento_id"))
	private List<Recolhimento> recolhimentos;

	public Produto() {
		vendedores = new ArrayList<Vendedor>();
		recolhimentos = new ArrayList<Recolhimento>();
	}

	public static Produto toEntity(ProdutoCreateDto dto){
		Produto p = new Produto();
		p.nome = dto.getNome();
		p.unidadeMedida = dto.getUnidadeMedida();
		p.preco = dto.getPreco();
		return  p;
	}
	public static Produto toEntity(ProdutoUpdateDto dto){
		Produto p = new Produto();
		p.nome = dto.getNome();
		p.unidadeMedida = dto.getUnidadeMedida();
		p.preco = dto.getPreco();
		return  p;
	}
}
