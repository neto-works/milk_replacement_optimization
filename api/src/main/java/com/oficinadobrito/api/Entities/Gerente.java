package com.oficinadobrito.api.Entities;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

import com.oficinadobrito.api.Controllers.Dtos.Creates.GerenteCreateDto;
import com.oficinadobrito.api.Controllers.Dtos.Updates.GerenteUpdateDto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_gerentes")
public class Gerente extends Usuario {
	@Serial
	private static final long serialVersionUID = 1L;

	private String cnpj;

	@OneToMany(mappedBy = "gerente")
	private List<Recolhimento> recolhimentos;

	@OneToMany(mappedBy = "gerenteOpt")
	private List<Optimization> optimizations;

	public Gerente() {
		recolhimentos = new ArrayList<Recolhimento>();
		optimizations = new ArrayList<Optimization>();
	}
	
	public Gerente(String cnpj) {
		this();
		this.cnpj = cnpj;
	}

	public static Gerente toEntity(GerenteCreateDto dto) {
		return new Gerente(dto.getCnpj());
	}
	public static Gerente toEntity(GerenteUpdateDto dto) {
		return new Gerente(dto.getCnpj());
	}
	
	
}
