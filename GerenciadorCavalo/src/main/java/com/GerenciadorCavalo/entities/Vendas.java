package com.GerenciadorCavalo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vendas")
public class Vendas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Dono Anterior")
	private String donoAnterior;
	
	@Column(name = "Dono Atual")
	private String donoAtual;
	
	@Column(name = "Valor da Venda")
	private double valorVenda;
	
	@Column(name = "Cavalo")
	private String cavalo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDonoAnterior() {
		return donoAnterior;
	}

	public void setDonoAnterior(String donoAnterior) {
		this.donoAnterior = donoAnterior;
	}

	public String getDonoAtual() {
		return donoAtual;
	}

	public void setDonoAtual(String donoAtual) {
		this.donoAtual = donoAtual;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public String getCavalo() {
		return cavalo;
	}

	public void setCavalo(String cavalo) {
		this.cavalo = cavalo;
	}
	
}
