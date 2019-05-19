package br.com.lucas.gestorfinanceiroapi.enums;

public enum FaturaEnum {
	MESATUAL("MÊS ATUAL"), 
	PROXIMOMES("PRÓXIMO MÊS");
	
	private String valor;

	FaturaEnum(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

}
