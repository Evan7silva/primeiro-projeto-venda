package com.evandev.dsvenda.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "venda")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime dataHora;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Cliente cliente;
	
	private Double valorTotal;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<ItemVenda> itens;
	
	public Venda() {
		
	}

	public Venda(Long id, LocalDateTime dataHora, Cliente cliente, Double valorTotal, List<ItemVenda> itens) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.cliente = cliente;
		this.valorTotal = valorTotal;
		this.itens = itens;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}
		
	
}
