package com.GerenciadorCavalo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.GerenciadorCavalo.entities.ApostaCavalos;
import com.GerenciadorCavalo.repository.ApostaCavalosRepository;

@Service
public class ApostaCavalosService {
	private final ApostaCavalosRepository apostaCavalosRepository;

	public ApostaCavalosService(ApostaCavalosRepository apostaCavalosRepository) {
		this.apostaCavalosRepository = apostaCavalosRepository;
	}

	public ApostaCavalos saveApostaCavalos(ApostaCavalos apostaCavalos) {
		return apostaCavalosRepository.save(apostaCavalos);
	}

	public ApostaCavalos getApostaCavalosById(Long id) {
		return apostaCavalosRepository.findById(id).orElse(null);
	}

	public List<ApostaCavalos> getAllApostaCavalos(){
		return apostaCavalosRepository.findAll();
	}

	public boolean deleteApostaCavalos(Long id) {
		Optional <ApostaCavalos> existeapostaCavalos = apostaCavalosRepository.findById(id);
		if (existeapostaCavalos.isPresent()) {
			apostaCavalosRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public ApostaCavalos updateApostaCavalos(Long id, ApostaCavalos putApostaCavalos) {
		Optional <ApostaCavalos> existeapostaCavalos = apostaCavalosRepository.findById(id);
		if (existeapostaCavalos.isPresent()) {
			putApostaCavalos.setId(id);
			return apostaCavalosRepository.save(putApostaCavalos);
		}
		return null;
	}

}
