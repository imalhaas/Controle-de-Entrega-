package com.algaworks.algalog.demo.domain.service;

import com.algaworks.algalog.demo.domain.exeption.NegocioExeption;
import com.algaworks.algalog.demo.domain.model.Cliente;
import com.algaworks.algalog.demo.domain.model.Entrega;
import com.algaworks.algalog.demo.domain.model.StatusEntrega;
import com.algaworks.algalog.demo.domain.repository.ClienteRepository;
import com.algaworks.algalog.demo.domain.repository.EntregaReposiroty;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;


@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private CatalogoClienteService catalogoClienteService;
    private EntregaReposiroty entregaReposiroty;


    @Transactional
    public Entrega solicitar(Entrega entrega){
    Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());

    return entregaReposiroty.save(entrega);
    }
}
