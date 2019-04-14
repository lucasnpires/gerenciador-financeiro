package br.com.lucas.gestorfinanceiroapi.enums;

public enum BandeiraEnum {

	VISA("VISA"), 
	MASTERCARD("MASTERCARD"), 
	HIPERCARD("HIPERCARD"), 
	AMERICAN_EXPRESS("AMERICAN EXPRESS"), 
	ELO("ELO"),
	DINERS_CLUB("DINERS CLUB");

	private String valor;

	BandeiraEnum(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

}
