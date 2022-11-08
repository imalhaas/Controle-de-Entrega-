package com.algaworks.algalog.demo.api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Getter
@Setter
public class OcorrenciaModel {

    private Long id;
    private String descricao;
    private OffsetDateTime dataRegistro;


}
