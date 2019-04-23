package br.com.lucas.gestorfinanceiroapi.enums;

public enum StatusEnum {

	ATIVO(1), 
	INATIVO(2); 

	private Integer valor;

	StatusEnum(Integer valor) {
		this.valor = valor;
	}

	public Integer getValor() {
		return valor;
	}
	
	public String getDescricao(Integer valor) {
		String descricao = "";
		switch (valor) {
		case 1:
			descricao =  "Ativo";			
			break;
		case 2:
			descricao =  "Inativo";			
			break;
		default:
			descricao = "Erro";
			break;
		}
		
		return descricao;
	}

}
