package com.oficinadobrito.api.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "optimization_data")
public class Optimization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long optimizationId;
    private String titulo;
    private LocalDate data;
    private double quantVisitados;
    private double gastoNoPeriodo;

    private double dispostoAGastarPeriodo;
    private String[] variaveis;
    private double[] resultados;
    private double resultadoFinal;
    private String setMensagemErro;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "optimization_recolhimento",joinColumns = {@JoinColumn(name = "optimizationId")},inverseJoinColumns ={@JoinColumn(name = "recolhimentoId")} )
    private List<Recolhimento> recolhimentos;

    @ManyToOne
    @JoinColumn(name = "gerenteId")
    private Gerente gerenteOpt;

    public  Optimization(){
        recolhimentos = new ArrayList<Recolhimento>();
    }

}
