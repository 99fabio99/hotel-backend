package com.fabiozanela.hotel.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemConsumido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemConsumidoPK id = new ItemConsumidoPK();
	
	private Double valor;
	private Integer quantidade;
	
	public ItemConsumido() {}
	
	public ItemConsumido(Reserva reserva, Item item, Double valor, Integer quantidade) {
		super();
		id.setReserva(reserva);
		id.setItem(item);
		this.valor = valor;
		this.quantidade = quantidade;
	}
	
	public double getSubTotal() {
		return (this.valor * this.quantidade);
	}
	
	
	@JsonIgnore
	public Reserva getReserva() {
		return this.id.getReserva();
	}
	
	public void setReserva(Reserva reserva) {
		this.id.setReserva(reserva);
	}
	
	public Item getItem() {
		return this.id.getItem();
	}
	
	public void setItem(Item item) {
		this.id.setItem(item);
	}

	public ItemConsumidoPK getId() {
		return id;
	}

	public void setId(ItemConsumidoPK id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	

}
