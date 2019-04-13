package br.com.lucas.gestorfinanceiroapi.util;

import static br.com.lucas.gestorfinanceiroapi.constantes.Constantes.CLIENT_ID;
import static br.com.lucas.gestorfinanceiroapi.constantes.Constantes.OAUTH_GRANT_TYPE;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class HeadersDefaultOAuth {
	
	@Value("${app.oauth.headers.client.id}")
	private String clientId_value;

	private String oauthGranType = "password";
	
	public HttpHeaders creatHeaders() {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON_UTF8);
		header.set(CLIENT_ID, clientId_value);
		header.set(OAUTH_GRANT_TYPE, oauthGranType);
		return header;
	}
}
