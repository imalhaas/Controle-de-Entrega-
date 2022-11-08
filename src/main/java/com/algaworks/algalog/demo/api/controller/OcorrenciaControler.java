package com.algaworks.algalog.demo.api.controller;


import com.algaworks.algalog.demo.api.assembler.OcorrenciaAssembler;
import com.algaworks.algalog.demo.api.model.OcorrenciaModel;
import com.algaworks.algalog.demo.domain.model.Entrega;
import com.algaworks.algalog.demo.domain.model.Ocorrencia;
import com.algaworks.algalog.demo.domain.service.BuscaEntregaService;
import com.algaworks.algalog.demo.domain.service.RegistroOcorrenciaService;
import com.algaworks.algalog.demo.input.OcorrenciaInput;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaControler {

    private BuscaEntregaService buscaEntregaService;
    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaAssembler ocorrenciaAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModel registrar(@PathVariable Long entregaId,
                                     @Valid @RequestBody OcorrenciaInput ocorrenciaInput){

        Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService
                .registrar(entregaId, ocorrenciaInput.getDescricao());

        return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
    }
    @GetMapping
    public List<OcorrenciaModel> Listar(@PathVariable Long entregaId){
    Entrega entrega = buscaEntregaService.buscar(entregaId);

    return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
    }

}
