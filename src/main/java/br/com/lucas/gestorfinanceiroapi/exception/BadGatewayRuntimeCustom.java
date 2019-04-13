package br.com.lucas.gestorfinanceiroapi.exception;


import static org.springframework.http.HttpStatus.BAD_GATEWAY;

public class BadGatewayRuntimeCustom extends ExceptionCustom {

	private static final long serialVersionUID = 1L;

	public BadGatewayRuntimeCustom(final String message) {
		super(BAD_GATEWAY, message);
	}
}
