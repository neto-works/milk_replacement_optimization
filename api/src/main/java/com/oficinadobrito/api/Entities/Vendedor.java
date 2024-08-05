package com.oficinadobrito.api.Entities;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import com.oficinadobrito.api.Controllers.Dtos.Creates.VendedorCreateDto;
import com.oficinadobrito.api.Controllers.Dtos.Updates.VendedorUpdateDto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_vendedores")
public class Vendedor extends Usuario {
	@Serial
	private static final long serialVersionUID = 1L;

	@Column(name = "CPF", length = 16)
	private String cpf;

	@Column(length = 254)
	private String local;

	private double totalKmAteCidade;

	@OneToMany(mappedBy = "vendedor")
	private List<Recolhimento> recolhimentos;

	@ManyToMany(cascade = { CascadeType.REMOVE })
	@JoinTable(name = "vendedor_produto", joinColumns = { @JoinColumn(name = "vendedor_id") }, inverseJoinColumns = {
			@JoinColumn(name = "produto_id") })
	private List<Produto> produtos;

	public Vendedor() {
		recolhimentos = new ArrayList<Recolhimento>();
		produtos = new ArrayList<Produto>();
	}

	public Vendedor(String cpf, String local, double totalKmAteCidade) {
		this();
		this.cpf = cpf;
		this.local = local;
		this.totalKmAteCidade = totalKmAteCidade;
	}
	public static Vendedor toEntity(VendedorCreateDto dto) {
		return new Vendedor(dto.getCpf(), dto.getLocal(), dto.getTotalKmAteCidade());
	}
	public static Vendedor toEntity(VendedorUpdateDto dto) {
		return new Vendedor(dto.getCpf(), dto.getLocal(), dto.getTotalKmAteCidade());
	}
	public static Vendedor copyByUsuario(Usuario usuario){
		Vendedor v = new Vendedor();
		v.setUsername(usuario.getUsername());
		v.setEmail(usuario.getEmail());
		v.setPassword(usuario.getPassword());
		v.setRole(usuario.getRole());
		return  v ;
	}

}
