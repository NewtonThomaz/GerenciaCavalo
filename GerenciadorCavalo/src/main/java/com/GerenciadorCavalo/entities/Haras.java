package com.GerenciadorCavalo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Haras")
public class Haras {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;

	@Column(name = "local")
	private String local;
	
	@Column(name = "dono")
	private String dono;
	
	@Column(name = "quantidade de Cavalos")
	private String quantidadeCavalos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

	public String getQuantidadeCavalos() {
		return quantidadeCavalos;
	}

	public void setQuantidadeCavalos(String quantidadeCavalos) {
		this.quantidadeCavalos = quantidadeCavalos;
	}
	
}
