package com.fabiozanela.hotel.dto;

import java.io.Serializable;

import com.fabiozanela.hotel.domain.Categoria;
import com.fabiozanela.hotel.domain.Item;

public class ItemNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Double valor;
	private String codigoBarro;
	private int quantidade;
	
	private Categoria categoria;
	
	public ItemNewDTO() {}

	public ItemNewDTO(Item item) {
		super();
		this.id = item.getId();
		this.nome = item.getNome();
		this.valor = item.getValor();
		this.codigoBarro = item.getCodigoBarro();
		this.quantidade = item.getQuantidade();
		this.categoria = item.getCategoria();
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	

}
