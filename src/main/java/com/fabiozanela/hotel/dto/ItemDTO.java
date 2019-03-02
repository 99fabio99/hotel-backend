package com.fabiozanela.hotel.dto;

import java.io.Serializable;

import com.fabiozanela.hotel.domain.Item;

public class ItemDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Double valor;
	private String codigoBarro;
	private int quantidade;
	
	public ItemDTO(Item item) {
		this.id = item.getId();
		this.nome = item.getNome();
		this.quantidade = item.getQuantidade();
		this.valor = item.getValor();
		this.codigoBarro = item.getCodigoBarro();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getCodigoBarro() {
		return codigoBarro;
	}

	public void setCodigoBarro(String codigoBarro) {
		this.codigoBarro = codigoBarro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
