package com.GerenciadorCavalo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.GerenciadorCavalo.entities.Cavalo;
import com.GerenciadorCavalo.repository.CavaloRepository;

@Service
public class CavaloService {
	private final CavaloRepository cavaloRepository;

	public CavaloService(CavaloRepository cavaloRepository) {
		this.cavaloRepository = cavaloRepository;
	}

	public Cavalo saveCavalo(Cavalo cavalo) {
		return cavaloRepository.save(cavalo);
	}

	public Cavalo getCavaloById(Long id) {
		return cavaloRepository.findById(id).orElse(null);
	}

	public List<Cavalo> getAllCavalo(){
		return cavaloRepository.findAll();
	}

	public Cavalo updateCavalo(Long id, Cavalo putCavalo) {
		Optional <Cavalo> existeCavalo = cavaloRepository.findById(id);
		if (existeCavalo.isPresent()) {
			putCavalo.setId(id);
			return cavaloRepository.save(putCavalo);
		} else {			
			return null;
		}
	}

	public boolean deleteCavalo(Long id) {
		Optional <Cavalo> existeCavalo = cavaloRepository.findById(id);
		if (existeCavalo.isPresent()) {
			cavaloRepository.deleteById(id);
			return true;
		} else {
			return false;		
		}
	}
}
