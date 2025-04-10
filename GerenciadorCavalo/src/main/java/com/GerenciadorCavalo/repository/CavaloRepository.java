package com.GerenciadorCavalo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.GerenciadorCavalo.entities.Cavalo;

public interface CavaloRepository extends JpaRepository<Cavalo, Long>{

}
