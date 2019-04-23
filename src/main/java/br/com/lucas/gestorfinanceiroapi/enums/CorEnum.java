package br.com.lucas.gestorfinanceiroapi.enums;

public enum CorEnum {
	AZUL("AZUL"), 
	AMARELO("AMARELO"),
	VERMELHO("VERMELHO"),
	ROXO("ROXO"); 
	
	private String valor;

	CorEnum(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

}
