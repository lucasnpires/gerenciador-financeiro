package br.com.lucas.gestorfinanceiroapi.exception;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

public class UnprocessableEntityCustom extends ExceptionCustom {

     /**
      * 
      */
     private static final long serialVersionUID = 1L;

     public UnprocessableEntityCustom(final String message) {

          super(UNPROCESSABLE_ENTITY, message);
     }
}
