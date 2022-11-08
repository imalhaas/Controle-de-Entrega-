package com.algaworks.algalog.demo.domain.repository;

import com.algaworks.algalog.demo.domain.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaReposiroty extends JpaRepository<Entrega, Long> {


}
