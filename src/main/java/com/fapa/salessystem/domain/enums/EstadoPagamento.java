package com.fapa.salessystem.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int cod;
	private String tipo;
	
	private EstadoPagamento(int cod, String tipo) {
		this.cod = cod;
		this.tipo = tipo;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String tipo() {
		return tipo;
	}
	
	public static EstadoPagamento toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for (EstadoPagamento x : EstadoPagamento.values() ) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id de enum inválido: " + cod);
	}
}
