package com.algaworks.algalog.demo.domain.service;

import com.algaworks.algalog.demo.domain.exeption.NegocioExeption;
import com.algaworks.algalog.demo.domain.model.Cliente;
import com.algaworks.algalog.demo.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CatalogoClienteService {
    public ClienteRepository clienteRepository;
 
    public Cliente buscar(Long clienteid){
        return   clienteRepository.findById(clienteid).orElseThrow(() ->
                new NegocioExeption("CLienten nao encontrado"));
    }


    @Transactional
    public Cliente salvar(Cliente cliente){
       boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
               .stream()
               .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

               if (emailEmUso){
                   throw new NegocioExeption("ja existe um email cadastrado");
               }
        return clienteRepository.save(cliente);
    }


    @Transactional
    public void excluir(Long clientId){
    clienteRepository.deleteById(clientId);
    }

}
