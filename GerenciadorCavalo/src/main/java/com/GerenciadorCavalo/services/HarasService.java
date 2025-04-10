package com.GerenciadorCavalo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.GerenciadorCavalo.entities.Haras;
import com.GerenciadorCavalo.repository.HarasRepository;

@Service
public class HarasService {
	private final HarasRepository harasRepository;

	public HarasService(HarasRepository harasRepository) {
		this.harasRepository = harasRepository;
	}
	public Haras saveHaras(Haras haras) {
		return harasRepository.save(haras);
	}

	public Haras getHarasById(Long id) {
		return harasRepository.findById(id).orElse(null);
	}

	public List<Haras> getAllHaras(){
		return harasRepository.findAll();
	}

	public Haras updateHaras(Long id, Haras putHaras) {
		Optional <Haras> existeHaras = harasRepository.findById(id);
		if (existeHaras.isPresent()) {
			putHaras.setId(id);
			return harasRepository.save(putHaras);
		}
		return null;
	}
	
	public boolean deleteHaras(Long id) {
		Optional <Haras> existeHaras = harasRepository.findById(id);
		if (existeHaras.isPresent()) {
			harasRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
