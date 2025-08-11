package com.evandev.dsvenda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_venda")
public class ItemVenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(optional = false)
	private Produto produto;
	
	private Integer quantidade;
	private Double preco;
	private Double subTotal;
	
	public ItemVenda() {
		
	}

	
	public ItemVenda(Long id, Produto produto, Integer quantidade, Double preco, Double subTotal) {
		super();
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
		this.preco = preco;
		this.subTotal = subTotal;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public Double getSubTotal() {
		return subTotal;
	}


	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}


}
