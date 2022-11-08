package com.algaworks.algalog.demo.api.exeptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class Problema {
    private Integer status;
    private OffsetDateTime dataHora;
    private String titulo;
    private List<Campo> campos ;

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCampos(List<Campo> campos) {
        this.campos = campos;
    }

    @AllArgsConstructor

    public static class Campo{
        private String nome;
        private String mensagem;

        public String getNome() {
            return nome;
        }

        public String getMensagem() {
            return mensagem;
        }
    }


}
