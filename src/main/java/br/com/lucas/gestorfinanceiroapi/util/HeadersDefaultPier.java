package br.com.lucas.gestorfinanceiroapi.util;


import static br.com.lucas.gestorfinanceiroapi.constantes.Constantes.ACCEPT;
import static br.com.lucas.gestorfinanceiroapi.constantes.Constantes.ACCESS_TOKEN;
import static br.com.lucas.gestorfinanceiroapi.constantes.Constantes.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public class HeadersDefaultPier {
	
	@Value("${app.pier.accessToken}")
	private String accessToken;

     public HttpHeaders creatHeaders() {
          HttpHeaders header = new HttpHeaders();
          header.set(ACCESS_TOKEN, accessToken);
          header.set(CONTENT_TYPE, APPLICATION_JSON_UTF8_VALUE);
          header.set(ACCEPT, APPLICATION_JSON_UTF8_VALUE);
          return header;
     }
}
