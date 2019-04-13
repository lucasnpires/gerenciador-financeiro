package br.com.lucas.gestorfinanceiroapi.definition;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.lucas.gestorfinanceiroapi.data.Despesa;
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
			@ApiResponse(code=204, message = "Lista de despesas", response=  PageDespesasResponse.class),
			@ApiResponse(code=404, message = "Nenhum registo encontrado", response=  PageDespesasResponse.class)
	})
	ResponseEntity<?> listarDespesas();
	
	
	
	@ApiOperation(value = "Recupera despesa por id")
	@ApiResponses(value = {
			@ApiResponse(code=200, message = "Lista de despesas", response=  PageDespesasResponse.class),
			@ApiResponse(code=204, message = "Lista de despesas", response=  PageDespesasResponse.class),
			@ApiResponse(code=404, message = "Nenhum registo encontrado", response=  PageDespesasResponse.class)
	})
	ResponseEntity<?> buscarDespesaPorId(@PathVariable String id);
	
	@ApiOperation(value = "Salva uma despesa")
	@ApiResponses(value = {
			@ApiResponse(code=200, message = "Despesa salva com sucesso", response=  PageDespesasResponse.class),
			@ApiResponse(code=500, message = "Erro interno no sistema", response=  PageDespesasResponse.class)
	})
	ResponseEntity<?> salvarDespesa(@Valid Despesa despesa);

}
