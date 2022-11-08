package com.algaworks.algalog.demo.api.model;

import com.algaworks.algalog.demo.domain.model.Cliente;
import com.algaworks.algalog.demo.domain.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


@Setter
@Getter
public class EntregaModel {

    private Long Id;
    private String nomeCliente;
    private DestinatarioModel destinatarioModel;
    private BigDecimal taxa;
    private StatusEntrega status;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;


}
