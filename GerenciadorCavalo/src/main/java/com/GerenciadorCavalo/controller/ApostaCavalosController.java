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

import com.GerenciadorCavalo.entities.ApostaCavalos;
import com.GerenciadorCavalo.services.ApostaCavalosService;

@RestController
@RequestMapping("/apostaCavalo")
public class ApostaCavalosController {
	private final ApostaCavalosService apostaCavalosService;

	public ApostaCavalosController(ApostaCavalosService apostaCavalosService) {
		this.apostaCavalosService = apostaCavalosService;
	}
	 @GetMapping("/")
	public ResponseEntity<List<ApostaCavalos>> getAllApostaCavalos() {
		List<ApostaCavalos> apostaCavalos = apostaCavalosService.getAllApostaCavalos();
		return ResponseEntity.ok(apostaCavalos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApostaCavalos> getApostaCavalosById(@PathVariable Long id) {
		ApostaCavalos apostaCavalos = apostaCavalosService.getApostaCavalosById(id);
		if (apostaCavalos != null) {
			return ResponseEntity.ok(apostaCavalos);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/")
	public ResponseEntity<ApostaCavalos> criarApostaCavalos(@RequestBody ApostaCavalos apostaCavalos) {
		ApostaCavalos criaApostaCavalos= apostaCavalosService.saveApostaCavalos(apostaCavalos);
		return ResponseEntity.status(HttpStatus.CREATED).body(criaApostaCavalos);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ApostaCavalos> alteraApostaCavalos(@PathVariable Long id, @RequestBody ApostaCavalos apostaCavalos) {
		ApostaCavalos alteraApostaCavalos = apostaCavalosService.updateApostaCavalos(id, apostaCavalos);
		if (alteraApostaCavalos != null) {
			return ResponseEntity.ok(alteraApostaCavalos);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteApostaCavalos(@PathVariable Long id) {
		boolean deleted = apostaCavalosService.deleteApostaCavalos(id);
		if (deleted) {
			return ResponseEntity.ok().body("A aposta foi excluída com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
