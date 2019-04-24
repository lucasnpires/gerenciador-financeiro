package br.com.lucas.gestorfinanceiroapi.enums;

public enum FaturaEnum {
	MES_ATUAL("MÊS ATUAL"), 
	PROXIMO_MÊS("PRÓXIMO MÊS");
	
	private String valor;

	FaturaEnum(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

}
