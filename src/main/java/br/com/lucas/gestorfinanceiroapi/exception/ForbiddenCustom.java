package br.com.lucas.gestorfinanceiroapi.exception;

import static org.springframework.http.HttpStatus.FORBIDDEN;


public class ForbiddenCustom extends ExceptionCustom {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /**
   * 
   */

  public ForbiddenCustom(final String message) {
    super(FORBIDDEN, message);

  }


}
