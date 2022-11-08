package com.algaworks.algalog.demo.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Destinatario {

    @NotBlank
    @Column(name = "Destinatario_nome")
    private String nome;

    @NotBlank
    @Column(name = "Destinatario_logradouro")
    private String logradouro;

    @NotBlank
    @Column(name = "Destinatario_numero")
    private String numero;

    @NotBlank
    @Column(name = "Destinatario_complemento")
    private String complemento;

    @NotBlank
    @Column(name = "Destinatario_bairro ")
    private String bairro;

}
