package com.algaworks.algalog.demo.input;

import com.sun.istack.NotNull;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class EntregaInput {

    @Valid
    @NotNull
    private ClienteIdInput cliente;

    @Valid
    @NotNull
    private DstinatarioInput destinatario;

    @NotNull
    private BigDecimal taxa;


}
