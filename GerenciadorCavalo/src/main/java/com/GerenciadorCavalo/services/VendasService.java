package com.GerenciadorCavalo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.GerenciadorCavalo.entities.Vendas;
import com.GerenciadorCavalo.repository.VendasRepository;

@Service
public class VendasService {
	private final VendasRepository vendasRepository;

	public VendasService(VendasRepository vendasRepository) {
		this.vendasRepository = vendasRepository;
	}

	public Vendas saveVendas(Vendas vendas) {
		return vendasRepository.save(vendas);
	}

	public Vendas getVendasById(Long id) {
		return vendasRepository.findById(id).orElse(null);
	}

	public List<Vendas> getAllVendas(){
		return vendasRepository.findAll();
	}

	public boolean deleteVendas(Long id) {
		Optional <Vendas> existeVendas = vendasRepository.findById(id);
		if (existeVendas.isPresent()) {
			vendasRepository.deleteById(id);
			return true;
		} else {
			return false;		
		}
	}

	public Vendas updateVendas(Long id, Vendas putVendas) {
		Optional <Vendas> existeVendas = vendasRepository.findById(id);
		if (existeVendas.isPresent()) {
			putVendas.setId(id);
			return vendasRepository.save(putVendas);
		} else {
			return null;		
		}
	}
}
