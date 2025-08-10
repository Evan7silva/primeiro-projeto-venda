package com.evandev.dsvenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evandev.dsvenda.model.Produto;
import com.evandev.dsvenda.service.ProdutoService;

@RestController
@RequestMapping("/prudutos")
@CrossOrigin(origins = "*")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public List<Produto> listar(){
		return service.listarTodos();
	}
	
	@PostMapping
	public Produto salvar(@RequestBody Produto produto) {
		return service.salvar(produto);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		service.deletar(id);
	}
}
