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

import br.com.lucas.gestorfinanceiroapi.data.Conta;
import br.com.lucas.gestorfinanceiroapi.domain.request.ContaSalvarRequest;
import br.com.lucas.gestorfinanceiroapi.domain.request.ContaUpdateRequest;
import br.com.lucas.gestorfinanceiroapi.domain.response.ContaResponse;
import br.com.lucas.gestorfinanceiroapi.domain.response.PageContasResponse;
import br.com.lucas.gestorfinanceiroapi.exception.ErroInfo;
import br.com.lucas.gestorfinanceiroapi.util.AppConstantes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = AppConstantes.PATH_CONTAS, produces = APPLICATION_JSON_UTF8_VALUE, tags = { "Contas" })
public interface ContaDefinition {
	
	@ApiOperation(value = "Listar as contas", notes = "Listar as contas", response = PageContasResponse.class)
	@ApiResponses({ 
			@ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
			@ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
			@ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
			@ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
			@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<?> listarContas(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "50") Integer size);

	@ApiOperation(value = "Buscar conta por id", notes = "Buscar conta por id", response = ContaResponse.class)
	@ApiResponses({ 
		@ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
		@ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
		@ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
		@ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
		@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<?> buscarContaPorId(@PathVariable(name = "id") Long id);

	@ApiOperation(value = "Salvar conta", notes = "Salvar conta")
	@ApiResponses({ 
		@ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
		@ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
		@ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
		@ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
		@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<?> salvarDespesa(@RequestBody(required = true) @Valid ContaSalvarRequest conta);
	
	@ApiOperation(value = "Excluir uma conta", notes = "Excluir uma conta")
    @ApiResponses({
         @ApiResponse(code = 200, message = MENSAGEM_GLOBAL_200),
         @ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
         @ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
         @ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
         @ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
         @ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class)})
	void excluir(
            @ApiParam(value = "Id da conta", required = true)
            @PathVariable("id") Long id);
	
	@ApiOperation(value = "Atualizar Conta", notes = "Atualizar Conta", response = ContaResponse.class)
	@ApiResponses({ @ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
			@ApiResponse(code = 412, message = MENSAGEM_GLOBAL_412, response = ErroInfo.class),
			@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<?> atualizarConta(@PathVariable(name = "id") Long id,
			@RequestBody(required = true) @Valid ContaUpdateRequest request);


}
