package br.com.lucas.gestorfinanceiroapi.resource;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import org.springframework.http.ResponseEntity;

import br.com.lucas.gestorfinanceiroapi.domain.response.PageDespesasResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(produces= APPLICATION_JSON_UTF8_VALUE, tags= "Despesas")
public interface DespesaDefinition {
	
	@ApiOperation(value="Lista despesas", notes="Lista as despesas")
	@ApiResponses(value = {
			@ApiResponse(code=200, message = "Lista de despesas", response=  PageDespesasResponse.class),
			@ApiResponse(code=204, message = "Lista de despesas", response=  PageDespesasResponse.class)
	})
	ResponseEntity<?> listarDespesas();

}
