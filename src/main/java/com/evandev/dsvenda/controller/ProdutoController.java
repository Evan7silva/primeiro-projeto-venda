package com.evandev.dsvenda.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evandev.dsvenda.model.Produto;
import com.evandev.dsvenda.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/prudutos")
@CrossOrigin(origins = "*")
public class ProdutoController {
	private final ProdutoRepository repo;

	public ProdutoController(ProdutoRepository repo) {
		this.repo = repo;
	}

	@GetMapping
	public List<Produto> listar() {
		return repo.findAll();
	}

	@PostMapping
	public Produto criar(@RequestBody Produto p) {
		return repo.save(p);
	}

	@PutMapping("/{id}")
	public Produto atualizar(@PathVariable Long id, @RequestBody Produto p) {
		return repo.findById(id).map(ex -> {
			ex.setNome(p.getNome());
			ex.setPreco(p.getPreco());
			ex.setQuantidade(p.getQuantidade());
			ex.setCategoria(p.getCategoria());
			return repo.save(ex);
		}).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		repo.deleteById(id);
	}
}