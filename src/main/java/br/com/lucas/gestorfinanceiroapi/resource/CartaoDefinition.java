package br.com.lucas.gestorfinanceiroapi.resource;

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

import br.com.lucas.gestorfinanceiroapi.domain.request.CartaoSalvarRequest;
import br.com.lucas.gestorfinanceiroapi.domain.request.CartaoUpdateRequest;
import br.com.lucas.gestorfinanceiroapi.domain.response.CartaoResponse;
import br.com.lucas.gestorfinanceiroapi.domain.response.PageCartoesResponse;
import br.com.lucas.gestorfinanceiroapi.exception.ErroInfo;
import br.com.lucas.gestorfinanceiroapi.util.AppConstantes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = AppConstantes.PATH_CARTOES, produces = APPLICATION_JSON_UTF8_VALUE, tags = { "Cartoes" })
public interface CartaoDefinition {

	@ApiOperation(value = "Listar os Cartões", notes = "Listar os Cartões", response = PageCartoesResponse.class)
	@ApiResponses({ 
			@ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
			@ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
			@ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
			@ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
			@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<?> listarCartoes(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "50") Integer size);

	@ApiOperation(value = "Buscar Cartão por id", notes = "Buscar Cartão por id", response = CartaoResponse.class)
	@ApiResponses({ 
			@ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
			@ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
			@ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
			@ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
			@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<?> buscarCartaoPorId(
			@ApiParam(value = "Id do Cartão", required = true) @PathVariable(name = "id") Long id);

	@ApiOperation(value = "Salvar um Cartão", notes = "Salvar um Cartão")
	@ApiResponses({ 
			@ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
			@ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
			@ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
			@ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
			@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<?> salvarCartao(@RequestBody(required = true) @Valid CartaoSalvarRequest cartao);

	@ApiOperation(value = "Excluir um Cartão", notes = "Excluir um Cartão")
	@ApiResponses({ 
			@ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
			@ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
			@ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
			@ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
			@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	void excluir(
			@ApiParam(value = "Id do Cartão, (Ex. 1)", example = "1", required = true) @PathVariable(name = "id") Long id);

	@ApiOperation(value = "Atualizar um Cartão", notes = "Atualizar um Cartão", response = CartaoResponse.class)
	@ApiResponses({ 
			@ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
			@ApiResponse(code = 412, message = MENSAGEM_GLOBAL_412, response = ErroInfo.class),
			@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<CartaoResponse> atualizarCartao(@PathVariable(name = "id") Long id,
			@RequestBody(required = true) @Valid CartaoUpdateRequest request);

}
