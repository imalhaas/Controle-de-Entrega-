package com.algaworks.algalog.demo.domain.service;

import com.algaworks.algalog.demo.domain.model.Entrega;
import com.algaworks.algalog.demo.domain.model.StatusEntrega;
import com.algaworks.algalog.demo.domain.repository.EntregaReposiroty;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {
    private BuscaEntregaService buscaEntregaService;
    private EntregaReposiroty entregaReposiroty;

    @Transactional
    public void finalizar(Long entregaid){
    Entrega entrega = buscaEntregaService.buscar(entregaid);

    entrega.finalizar();
    }
}
