package br.com.lucas.gestorfinanceiroapi.enums;

public enum TipoCategoriaEnum {
	RECEITA(1),
	DESPESA(2);
	 
    private Integer valor;
    private String descricao;
    
    TipoCategoriaEnum(Integer valor) {
    	this.valor = valor;
    }
    
    public Integer getValor(){
        return valor;
    }
    
    public String getDescricao(Integer valor) {
    	switch (valor) {
		case 1:
			this.descricao =  "Receita";
			break;
		case 2:
			this.descricao =  "Despesa";
			break;
		}
    	
    	return this.descricao;
    }
}
