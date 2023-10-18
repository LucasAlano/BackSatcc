package com.satc.com.satc.repository;

import com.satc.com.satc.Model.Cliente;
import com.satc.com.satc.Model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository <Servico, Long>, CustomQuerydslPredicateExecutor<Servico> {
}
