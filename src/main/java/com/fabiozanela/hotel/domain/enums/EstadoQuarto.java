package com.fabiozanela.hotel.domain.enums;

public enum EstadoQuarto {

	LIVRE(1, "Livre"),
	OCUPADO(2, "Ocupado"),
	MANUTENCAO(3, "Manutenção"),
	RESERVADO(4, "Reservado");
	
	private int cod;
	private String descricao;
	
	private EstadoQuarto(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoCliente x : TipoCliente.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
