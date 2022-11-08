package com.algaworks.algalog.demo.common;

import com.algaworks.algalog.demo.api.model.EntregaModel;
import com.algaworks.algalog.demo.domain.model.Entrega;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


 
}
