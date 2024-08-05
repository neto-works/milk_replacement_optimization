package com.oficinadobrito.api.Services;

import com.oficinadobrito.api.Controllers.Dtos.OptimizationRequestData;
import com.oficinadobrito.api.Entities.Optimization;
import com.oficinadobrito.api.Entities.Vendedor;
import com.oficinadobrito.api.Repositories.ProdutoRepository;
import com.oficinadobrito.api.Repositories.RecolhimentoRepository;
import com.oficinadobrito.api.Repositories.VendedorRepository;
import org.apache.commons.math3.optim.MaxIter;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.*;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class OptimizationServices {
    // private RecolhimentoRepository reconhecimentoRepository;
    // private ProdutoRepository produtoRepository;
    private VendedorRepository vendedorRepository;
    private Optimization opt;

    public OptimizationServices(ProdutoRepository produtoRepository, VendedorRepository vendedorRepository, RecolhimentoRepository reconhecimentoRepository) {
        this.vendedorRepository = vendedorRepository;
        // this.produtoRepository = produtoRepository;
        // this.reconhecimentoRepository = reconhecimentoRepository;
    }

    @Async
    public CompletableFuture<Optimization> otimizationAsyncDispostoAGastarObterMaxValue(OptimizationRequestData dados){
        LinearObjectiveFunction functionRepresentante = new LinearObjectiveFunction(new double[]{dados.getValorLeite(), dados.getValorQueijo()}, 0);
        Collection<LinearConstraint> constraints = new ArrayList<>();
        constraints.add(new LinearConstraint(new double[]{dados.getValorLeite(), dados.getValorQueijo()}, Relationship.LEQ, dados.getValorPretendido()));
        constraints.add(new LinearConstraint(new double[]{ 0, 1}, Relationship.LEQ, dados.getValorMaxQueijoVende()));

        SimplexSolver solver = new SimplexSolver();
        PointValuePair solution = solver.optimize(new MaxIter(100), functionRepresentante, GoalType.MAXIMIZE, new NonNegativeConstraint(true),  new LinearConstraintSet(constraints));

        opt =  new Optimization();
        opt.setData(LocalDate.now());
        opt.setDispostoAGastarPeriodo(dados.getValorPretendido());
        opt.setResultados(new double[]{solution.getPoint()[0],solution.getPoint()[1]});
        opt.setResultadoFinal(solution.getValue());
        return CompletableFuture.completedFuture(opt);
    }

    @Async
    public CompletableFuture<Optimization> otimizationKilometragem(OptimizationRequestData dados){
        double custoGasolinaPorKm = 5.54 / 9.8;
        double custoTotalPorKm = 1 + custoGasolinaPorKm;
        LinearObjectiveFunction functionKilometragem = new LinearObjectiveFunction(new double[]{custoTotalPorKm}, 0);
        Collection<LinearConstraint> constraints = new ArrayList<>();
        constraints.add(new LinearConstraint(new double[]{2.20, 4.93}, Relationship.LEQ, dados.getValorPretendido()));

        constraints.add(new LinearConstraint(new double[]{1,0}, Relationship.LEQ, dados.getValorGasto() / custoTotalPorKm));

        try {

            SimplexSolver solver = new SimplexSolver();
            PointValuePair solution = solver.optimize(new MaxIter(100), functionKilometragem, GoalType.MINIMIZE, new NonNegativeConstraint(true), new LinearConstraintSet(constraints));

            double quilometragem = solution.getPoint()[0];

            Optimization opt = new Optimization();
            opt.setData(LocalDate.now());
            opt.setDispostoAGastarPeriodo(dados.getValorPretendido());
            opt.setResultados(new double[]{quilometragem});
            opt.setResultadoFinal(solution.getValue());

            return CompletableFuture.completedFuture(opt);
        } catch (NoFeasibleSolutionException e) {
            Optimization opt = new Optimization();
            opt.setData(LocalDate.now());
            opt.setDispostoAGastarPeriodo(dados.getValorPretendido());
            opt.setResultados(new double[]{});
            opt.setResultadoFinal(0);
            opt.setSetMensagemErro("Não há solução viável para os parâmetros fornecidos.");
            return CompletableFuture.completedFuture(opt);
        }
    }

    public List<Vendedor> findVendedorsWhereOtimizationKilometragem(double kilometragem){
        List<Vendedor> lista = this.vendedorRepository.findAll();
        return  lista;
    }


}
