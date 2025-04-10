package com.GerenciadorCavalo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GerenciadorCavalo.entities.Vendas;
import com.GerenciadorCavalo.services.VendasService;

@RestController
@RequestMapping("/vendas")
public class VendasController {
	private final VendasService vendasService;

	public VendasController(VendasService vendasService) {
		this.vendasService = vendasService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Vendas>> getAllVendas() {
		List<Vendas> vendas = vendasService.getAllVendas();
		return ResponseEntity.ok(vendas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Vendas> getVendasById(@PathVariable Long id) {
		Vendas vendas = vendasService.getVendasById(id);
		if (vendas != null) {
			return ResponseEntity.ok(vendas);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/")
	public ResponseEntity<Vendas> criarVendas(@RequestBody Vendas vendas) {
		Vendas criaVendas= vendasService.saveVendas(vendas);
		return ResponseEntity.status(HttpStatus.CREATED).body(criaVendas);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Vendas> alteraVendas(@PathVariable Long id, @RequestBody Vendas vendas) {
		Vendas alteraVendas= vendasService.updateVendas(id, vendas);
		if (alteraVendas != null) {
			return ResponseEntity.ok(alteraVendas);
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteVendas(@PathVariable Long id) {
		boolean deleted = vendasService.deleteVendas(id);
		if (deleted) {
			return ResponseEntity.ok().body("A Venda foi excluída com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
