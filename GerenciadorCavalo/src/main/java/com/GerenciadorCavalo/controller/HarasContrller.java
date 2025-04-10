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

import com.GerenciadorCavalo.entities.Haras;
import com.GerenciadorCavalo.services.HarasService;

@RestController
@RequestMapping("/haras")
public class HarasContrller {
	private final HarasService harasService;

	public HarasContrller(HarasService harasService) {
		this.harasService = harasService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Haras>> getAllHaras() {
		List<Haras> haras = harasService.getAllHaras();
		return ResponseEntity.ok(haras);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Haras> getHarasById(@PathVariable Long id) {
		Haras haras = harasService.getHarasById(id);
		if (haras != null) {
			return ResponseEntity.ok(haras);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/")
	public ResponseEntity<Haras> criarHaras(@RequestBody Haras haras) {
		Haras criaHaras= harasService.saveHaras(haras);
		return ResponseEntity.status(HttpStatus.CREATED).body(criaHaras);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Haras> alteraHaras(@PathVariable Long id, @RequestBody Haras haras) {
		Haras alteraHaras= harasService.updateHaras(id, haras);
		if (alteraHaras != null) {
			return ResponseEntity.ok(alteraHaras);
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteHaras(@PathVariable Long id) {
		boolean deleted = harasService.deleteHaras(id);
		if (deleted) {
			return ResponseEntity.ok().body("O Haras foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
