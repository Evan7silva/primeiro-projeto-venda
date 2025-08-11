package com.evandev.dsvenda.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.evandev.dsvenda.dto.ItemVendaDTO;
import com.evandev.dsvenda.dto.VendaRequest;
import com.evandev.dsvenda.exception.NegocioException;
import com.evandev.dsvenda.model.ItemVenda;
import com.evandev.dsvenda.model.Produto;
import com.evandev.dsvenda.model.Venda;
import com.evandev.dsvenda.repository.ClienteRepository;
import com.evandev.dsvenda.repository.ProdutoRepository;
import com.evandev.dsvenda.repository.VendaRepository;

@Service
public class VendaService {
	
	private final ProdutoRepository produtoRepo;
	private final ClienteRepository clienteRepo;
    private final VendaRepository vendaRepo;
    
	public VendaService(ProdutoRepository produtoRepo, ClienteRepository clienteRepo, VendaRepository vendaRepo) {
		super();
		this.produtoRepo = produtoRepo;
		this.clienteRepo = clienteRepo;
		this.vendaRepo = vendaRepo;
	}
    
    public Venda registrarVenda(VendaRequest request) {
    	if (request.getItens() == null || request.getItens().isEmpty()) {
    		throw new NegocioException("Venda deve ter ao menos 1 item");
    	}
    	
    	// buscar produtos e validar estoque
        Map<Long, Produto> produtosMap = produtoRepo.findAllById(
                request.getItens().stream().map(ItemVendaDTO::getProdutoId).collect(Collectors.toSet())
        ).stream().collect(Collectors.toMap(Produto::getId, p -> p));

        List<ItemVenda> itens = new ArrayList<>();
        
        double total = 0.0;
        
        for (ItemVendaDTO dto : request.getItens()) {
        	Produto p = produtosMap.get(dto.getProdutoId());
        	if (p == null) throw new NegocioException("Produto não encontrado: " + dto.getProdutoId());
        	
        	 if (p.getQuantidade() < dto.getQuantidade()) {
                 throw new NegocioException("Estoque insuficiente para produto: " + p.getNome());
             }
        	 
        	// criar item
             ItemVenda item = new ItemVenda();
             item.setProduto(p);
             item.setQuantidade(dto.getQuantidade());
             item.setPreco(p.getPreco());
             item.setSubTotal(p.getPreco() * dto.getQuantidade());
             itens.add(item);

             // decrementar estoque
             p.setQuantidade(p.getQuantidade() - dto.getQuantidade());
             produtoRepo.save(p);

             total += item.getSubTotal();
         }

         Venda venda = new Venda();
         venda.setDataHora(LocalDateTime.now());
         if (request.getClienteId() != null) {
             clienteRepo.findById(request.getClienteId()).ifPresent(venda::setCliente);
         }
         venda.setItens(itens);
         venda.setValorTotal(total);

         return vendaRepo.save(venda);
     }
 }