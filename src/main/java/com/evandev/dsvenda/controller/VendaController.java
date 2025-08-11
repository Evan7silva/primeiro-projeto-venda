package com.evandev.dsvenda.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.evandev.dsvenda.dto.VendaRequest;
import com.evandev.dsvenda.model.Venda;
import com.evandev.dsvenda.repository.VendaRepository;
import com.evandev.dsvenda.service.VendaService;

public class VendaController {

	private final VendaService vendaService;
	private final VendaRepository vendaRepository;
	
	public VendaController(VendaService vendaService, VendaRepository vendaRepository) {
		super();
		this.vendaService = vendaService;
		this.vendaRepository = vendaRepository;
	}
	
	@GetMapping
	public List<Venda> listar() {
		return vendaRepository.findAll();
	}
	
	public Venda registrar(@RequestBody VendaRequest request) {
		return vendaService.registrarVenda(request);
	}
	
}
