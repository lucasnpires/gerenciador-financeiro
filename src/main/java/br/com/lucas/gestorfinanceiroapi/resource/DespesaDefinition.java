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

import br.com.lucas.gestorfinanceiroapi.data.Despesa;
import br.com.lucas.gestorfinanceiroapi.domain.request.DespesaSalvarRequest;
import br.com.lucas.gestorfinanceiroapi.domain.request.DespesaUpdateRequest;
import br.com.lucas.gestorfinanceiroapi.domain.response.DespesaResponse;
import br.com.lucas.gestorfinanceiroapi.domain.response.PageDespesasResponse;
import br.com.lucas.gestorfinanceiroapi.exception.ErroInfo;
import br.com.lucas.gestorfinanceiroapi.util.AppConstantes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = AppConstantes.PATH_DESPESAS, produces = APPLICATION_JSON_UTF8_VALUE, tags = { "Despesas" })
public interface DespesaDefinition {

	@ApiOperation(value = "Listar as despesas", notes = "Listar as despesas", response = PageDespesasResponse.class)
	@ApiResponses({ 
			@ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
			@ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
			@ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
			@ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
			@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<?> listarDespesas(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "50") Integer size);

	@ApiOperation(value = "Buscar despesa por id", notes = "Buscar despesa por id", response = Despesa.class)
	@ApiResponses({ 
		@ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
		@ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
		@ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
		@ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
		@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<?> buscarDespesaPorId(@PathVariable(name = "id") Long id);

	@ApiOperation(value = "Salvar despesa", notes = "Salvar despesa")
	@ApiResponses({ 
		@ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
		@ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
		@ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
		@ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
		@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<?> salvarDespesa(@RequestBody(required = true) @Valid DespesaSalvarRequest despesa);
	
	
	@ApiOperation(value = "Excluir uma despesa", notes = "Excluir uma despesa")
    @ApiResponses({
         @ApiResponse(code = 200, message = MENSAGEM_GLOBAL_200),
         @ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
         @ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
         @ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
         @ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
         @ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class)})
	void excluir(
            @ApiParam(value = "Id da despesa", required = true)
            @PathVariable("id") Long id);
	
	@ApiOperation(value = "Atualizar despesa", notes = "Atualizar despesa", response = DespesaResponse.class)
	@ApiResponses({ 
			@ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
			@ApiResponse(code = 412, message = MENSAGEM_GLOBAL_412, response = ErroInfo.class),
			@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<?> atualizarDespesa(@PathVariable(name = "id") Long id,
			@RequestBody(required = true) @Valid DespesaUpdateRequest update);

}
