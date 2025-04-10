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

import com.GerenciadorCavalo.entities.Cavalo;
import com.GerenciadorCavalo.services.CavaloService;

@RestController
@RequestMapping("/cavalo")
public class CavaloController {
	private final CavaloService cavaloService;

	public CavaloController(CavaloService cavaloService) {
		this.cavaloService = cavaloService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Cavalo>> getAllCavalo() {
		List<Cavalo> cavalo = cavaloService.getAllCavalo();
		return ResponseEntity.ok(cavalo);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cavalo> getCavaloById(@PathVariable Long id) {
		Cavalo cavalo = cavaloService.getCavaloById(id);
		if (cavalo != null) {
			return ResponseEntity.ok(cavalo);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/")
	public ResponseEntity<Cavalo> criarCavalo(@RequestBody Cavalo cavalo) {
		Cavalo criaCavalo = cavaloService.saveCavalo(cavalo);
		return ResponseEntity.status(HttpStatus.CREATED).body(criaCavalo);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cavalo> alteraCavalo(@PathVariable Long id, @RequestBody Cavalo cavalo) {
		Cavalo alteraCavalo = cavaloService.updateCavalo(id, cavalo);
		if (alteraCavalo != null) {
			return ResponseEntity.ok(alteraCavalo);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCavalo(@PathVariable Long id) {
		boolean deleted = cavaloService.deleteCavalo(id);
		if (deleted) {
			return ResponseEntity.ok().body("O Cavalo foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}