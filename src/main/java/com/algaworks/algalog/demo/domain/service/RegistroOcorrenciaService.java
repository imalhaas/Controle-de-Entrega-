package com.algaworks.algalog.demo.domain.service;

import com.algaworks.algalog.demo.domain.exeption.NegocioExeption;
import com.algaworks.algalog.demo.domain.model.Entrega;
import com.algaworks.algalog.demo.domain.model.Ocorrencia;
import com.algaworks.algalog.demo.domain.repository.EntregaReposiroty;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

    private BuscaEntregaService buscaEntregaService ;

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return entrega.adicionarOcorrencia(descricao);
    }
}

