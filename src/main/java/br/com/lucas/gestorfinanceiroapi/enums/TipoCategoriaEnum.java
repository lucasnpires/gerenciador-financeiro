package br.com.lucas.gestorfinanceiroapi.enums;

public enum TipoCategoriaEnum {
	RECEITA("RECEITA"),
	DESPESA("DESPESA");
	 
    private String valor;
    
    TipoCategoriaEnum(String valor) {
    	this.valor = valor;
    }
    
    public String getValor(){
        return valor;
    }
    
}
