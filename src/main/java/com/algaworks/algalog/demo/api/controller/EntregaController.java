package com.algaworks.algalog.demo.api.controller;


import com.algaworks.algalog.demo.api.assembler.EntregaAssembler;
import com.algaworks.algalog.demo.api.model.DestinatarioModel;
import com.algaworks.algalog.demo.api.model.EntregaModel;
import com.algaworks.algalog.demo.domain.model.Destinatario;
import com.algaworks.algalog.demo.domain.model.Entrega;
import com.algaworks.algalog.demo.domain.repository.EntregaReposiroty;
import com.algaworks.algalog.demo.domain.service.FinalizacaoEntregaService;
import com.algaworks.algalog.demo.domain.service.SolicitacaoEntregaService;
import com.algaworks.algalog.demo.input.EntregaInput;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {
    private EntregaReposiroty entregaReposiroty;
    private SolicitacaoEntregaService solicitacaoEntregaService;
    private FinalizacaoEntregaService finalizacaoEntregaService;
    private ModelMapper modelMapper;
    private EntregaAssembler entregaAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaModel solicitar(@Valid @RequestBody EntregaInput entregaInput){
        Entrega novaEntrega = entregaAssembler.toEntity(entregaInput);
        Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);
       return entregaAssembler.toModel(entregaSolicitada);
    }

    @PutMapping("/{entregaId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long entregaId){
        finalizacaoEntregaService.finalizar(entregaId);
    }

    @GetMapping
    public List<EntregaModel> Listar(){
        return entregaAssembler.toCollectionModel(entregaReposiroty.findAll());
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaModel> Buscar(@PathVariable Long entregaId){
        return entregaReposiroty.findById(entregaId)
                .map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }
}
