package com.fapa.salessystem.domain.enums;

public enum Perfil {
	
	ADMIN(1, "ROLE_ADMIN"),
	CLIENTE(2, "ROLE_CLIENTE");

	
	private int cod;
	private String tipo;
	
	private Perfil(int cod, String tipo) {
		this.cod = cod;
		this.tipo = tipo;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String tipo() {
		return tipo;
	}
	
	public static Perfil toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for (Perfil x : Perfil.values() ) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id de enum inválido: " + cod);
	}
}
