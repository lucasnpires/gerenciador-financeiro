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

import br.com.lucas.gestorfinanceiroapi.domain.request.DespesaCartaoSalvarRequest;
import br.com.lucas.gestorfinanceiroapi.domain.request.DespesaCartaoUpdateRequest;
import br.com.lucas.gestorfinanceiroapi.domain.response.DespesaCartaoResponse;
import br.com.lucas.gestorfinanceiroapi.domain.response.PageDespesasCartaoResponse;
import br.com.lucas.gestorfinanceiroapi.exception.ErroInfo;
import br.com.lucas.gestorfinanceiroapi.util.AppConstantes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = AppConstantes.PATH_DESPESAS_CARTAO, produces = APPLICATION_JSON_UTF8_VALUE, tags = { AppConstantes.TAG_DESPESAS_CARTAO })
public interface DespesaCartaoDefinition {
	
	
	@ApiOperation(value = "Listar as Despesas do Cartão", notes = "Listar as Despesas do Cartão", response = PageDespesasCartaoResponse.class)
	@ApiResponses({ 
			@ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
			@ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
			@ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
			@ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
			@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<?> listarDespesasCartao(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "50") Integer size);

	@ApiOperation(value = "Buscar Despesa Cartão por id", notes = "Buscar Despesa Cartão por id", response = DespesaCartaoResponse.class)
	@ApiResponses({ 
		@ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
		@ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
		@ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
		@ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
		@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<?> buscarDespesasCartaoPorId(@PathVariable(name = "id") Long id);

	@ApiOperation(value = "Salvar uma Despesa para o Cartão", notes = "Salvar uma Despesa para o Cartão")
	@ApiResponses({ 
		@ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
		@ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
		@ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
		@ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
		@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<?> salvarDespesaCartao(@RequestBody(required = true) @Valid DespesaCartaoSalvarRequest conta);
	
	@ApiOperation(value = "Excluir uma Despesa de Cartão", notes = "Excluir uma Despesa de Cartão")
    @ApiResponses({
         @ApiResponse(code = 200, message = MENSAGEM_GLOBAL_200),
         @ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
         @ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
         @ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
         @ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
         @ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class)})
	void excluir(
            @ApiParam(value = "Id da Despesa do Cartão", required = true)
            @PathVariable("id") Long id);
	
	@ApiOperation(value = "Atualizar uma Despesa para o Cartão", notes = "Atualizar uma Despesa para o Cartão", response = DespesaCartaoResponse.class)
	@ApiResponses({ 
			@ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
			@ApiResponse(code = 412, message = MENSAGEM_GLOBAL_412, response = ErroInfo.class),
			@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<?> atualizarDespesaCartao(@PathVariable(name = "id") Long id,
			@RequestBody(required = true) @Valid DespesaCartaoUpdateRequest request);

}
