package com.algaworks.algalog.demo.domain.service;

import com.algaworks.algalog.demo.domain.exeption.EntidadeNaoEncontradaException;
import com.algaworks.algalog.demo.domain.exeption.NegocioExeption;
import com.algaworks.algalog.demo.domain.model.Entrega;
import com.algaworks.algalog.demo.domain.repository.EntregaReposiroty;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    private EntregaReposiroty entregaReposiroty;

    public Entrega buscar(Long entregaId){
         return entregaReposiroty.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega nao encontrada"));

    }

}
