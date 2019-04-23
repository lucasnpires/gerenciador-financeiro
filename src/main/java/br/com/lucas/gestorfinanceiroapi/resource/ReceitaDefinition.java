package br.com.lucas.gestorfinanceiroapi.resource;

import static br.com.lucas.gestorfinanceiroapi.exception.GlobalExceptionHandler.MENSAGEM_GLOBAL_200;
import static br.com.lucas.gestorfinanceiroapi.exception.GlobalExceptionHandler.MENSAGEM_GLOBAL_400;
import static br.com.lucas.gestorfinanceiroapi.exception.GlobalExceptionHandler.MENSAGEM_GLOBAL_401;
import static br.com.lucas.gestorfinanceiroapi.exception.GlobalExceptionHandler.MENSAGEM_GLOBAL_403;
import static br.com.lucas.gestorfinanceiroapi.exception.GlobalExceptionHandler.MENSAGEM_GLOBAL_404;
import static br.com.lucas.gestorfinanceiroapi.exception.GlobalExceptionHandler.MENSAGEM_GLOBAL_412;
import static br.com.lucas.gestorfinanceiroapi.exception.GlobalExceptionHandler.MENSAGEM_GLOBAL_500;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.lucas.gestorfinanceiroapi.domain.request.ReceitaSalvarRequest;
import br.com.lucas.gestorfinanceiroapi.domain.request.ReceitaUpdateRequest;
import br.com.lucas.gestorfinanceiroapi.domain.response.PageReceitasResponse;
import br.com.lucas.gestorfinanceiroapi.domain.response.ReceitaResponse;
import br.com.lucas.gestorfinanceiroapi.exception.ErroInfo;
import br.com.lucas.gestorfinanceiroapi.util.AppConstantes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = AppConstantes.PATH_RECEITAS, produces = APPLICATION_JSON_UTF8_VALUE, tags = { "Receitas" })
public interface ReceitaDefinition {

	@ApiOperation(value = "Listar as Receitas", notes = "Listar as Receitas", response = PageReceitasResponse.class)
	@ApiResponses({ 
			@ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
			@ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
			@ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
			@ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
			@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<?> listarReceitas(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "50") Integer size);

	@ApiOperation(value = "Buscar Receita por id", notes = "Buscar Receita por id", response = ReceitaResponse.class)
	@ApiResponses({ 
		@ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
		@ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
		@ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
		@ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
		@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<?> buscarReceitaPorId(@PathVariable(name = "id") Long id);

	@ApiOperation(value = "Salvar uma Receita", notes = "Salvar uma Receita")
	@ApiResponses({ 
		@ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
		@ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
		@ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
		@ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
		@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<?> salvarReceita(@RequestBody(required = true) @Valid ReceitaSalvarRequest receita);
	
	
	@ApiOperation(value = "Excluir uma Receita", notes = "Excluir uma Receita")
    @ApiResponses({
         @ApiResponse(code = 200, message = MENSAGEM_GLOBAL_200),
         @ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
         @ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
         @ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
         @ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
         @ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class)})
	void excluir(
            @ApiParam(value = "Id da Receita", required = true)
            @PathVariable("id") Long id);
	
	@ApiOperation(value = "Atualizar uma Receita", notes = "Atualizar uma Receita", response = ReceitaResponse.class)
	@ApiResponses({ 
			@ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
			@ApiResponse(code = 412, message = MENSAGEM_GLOBAL_412, response = ErroInfo.class),
			@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<?> atualizarReceita(@PathVariable(name = "id") Long id,
			@RequestBody(required = true) @Valid ReceitaUpdateRequest update);

}
