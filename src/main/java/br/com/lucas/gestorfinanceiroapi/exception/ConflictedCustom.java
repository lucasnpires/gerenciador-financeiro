package br.com.lucas.gestorfinanceiroapi.exception;

import static org.springframework.http.HttpStatus.CONFLICT;

public class ConflictedCustom extends ExceptionCustom {

     /**
      * 
      */
     private static final long serialVersionUID = 1L;

     public ConflictedCustom(final String message) {

          super(CONFLICT, message);
     }
}
