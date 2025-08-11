package com.evandev.dsvenda.dto;

import java.util.List;

public class VendaRequest {

	private Long ClienteId;
	private List<ItemVendaDTO> itens;
	
	public VendaRequest() {
		
	}

	public VendaRequest(Long clienteId, List<ItemVendaDTO> itens) {
		super();
		ClienteId = clienteId;
		this.itens = itens;
	}

	public Long getClienteId() {
		return ClienteId;
	}

	public void setClienteId(Long clienteId) {
		ClienteId = clienteId;
	}

	public List<ItemVendaDTO> getItens() {
		return itens;
	}

	public void setItens(List<ItemVendaDTO> itens) {
		this.itens = itens;
	}
	
	
}
