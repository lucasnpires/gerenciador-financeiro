package br.com.lucas.gestorfinanceiroapi.enums;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.lucas.gestorfinanceiroapi.exception.EnumValidationException;

public enum StatusSaldoInicialEnum {
	
	SIM, NAO;
	
    @JsonCreator
    public static StatusSaldoInicialEnum initCreator (String value) throws EnumValidationException {
        if(Objects.isNull(value )) {
            throw new EnumValidationException("null", "TipoProduto");
        }
        for(StatusSaldoInicialEnum v : values()) {
            if(value.equals(v.name())) {
                return v;
            }
        }
        throw new EnumValidationException(value, "StatusSaldoInicial");
    }
    
    public static StatusSaldoInicialEnum equalsTipo(String produto) {
         
    	StatusSaldoInicialEnum saldoInicial = null;
         
         if(StatusSaldoInicialEnum.SIM.name().equals(produto)){
              saldoInicial = StatusSaldoInicialEnum.SIM;
         }else if(StatusSaldoInicialEnum.NAO.name().equals(produto)){
              saldoInicial = StatusSaldoInicialEnum.NAO;
         }
         return saldoInicial;
    }

}
