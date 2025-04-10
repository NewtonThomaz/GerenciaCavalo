package com.GerenciadorCavalo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Aposta de Cavalos")
public class ApostaCavalos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Valor da Aposta")
	private double ValorAposta;
	
	@Column(name = "O cavalo apostado")
	private String cavaloApostado;
	
	@Column(name = "Cliente")
	private String cliente;
	
	@Column(name = "donoCavalo")
	private String NomeDono;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValorAposta() {
		return ValorAposta;
	}

	public void setValorAposta(double valorAposta) {
		ValorAposta = valorAposta;
	}

	public String getCavaloApostado() {
		return cavaloApostado;
	}

	public void setCavaloApostado(String cavaloApostado) {
		this.cavaloApostado = cavaloApostado;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getNomeDono() {
		return NomeDono;
	}

	public void setNomeDono(String nomeDono) {
		NomeDono = nomeDono;
	}
	
}
