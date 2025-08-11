package com.evandev.dsvenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evandev.dsvenda.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{
}
