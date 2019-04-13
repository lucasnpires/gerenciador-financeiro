package br.com.lucas.gestorfinanceiroapi.util;

import lombok.Getter;

@Getter
public enum TelefonesTamanho {
     DDD(2), CELULAR(9);

     private int tamanho;

     TelefonesTamanho(int tamanho) {

          this.tamanho = tamanho;
     }

}
