package br.com.lucas.gestorfinanceiroapi.enums;

public enum StatusSaldoInicialEnum {
	
	SIM ("SIM"), NAO ("NAO");
	
	
	private String valor;
    
	StatusSaldoInicialEnum(String valor) {
    	this.valor = valor;
    }
    
    public String getValor(){
        return valor;
    }
	

}
