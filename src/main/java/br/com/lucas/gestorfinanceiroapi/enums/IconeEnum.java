package br.com.lucas.gestorfinanceiroapi.enums;

public enum IconeEnum {
	CARRO("CARRO"), 
	CASA("CASA"),
	EDUCACAO("EDUCACAO"); 
	
	private String valor;

	IconeEnum(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

}
