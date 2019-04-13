package br.com.lucas.gestorfinanceiroapi.resource;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static br.com.lucas.gestorfinanceiroapi.exception.GlobalExceptionHandler.MENSAGEM_GLOBAL_400;
import static br.com.lucas.gestorfinanceiroapi.exception.GlobalExceptionHandler.MENSAGEM_GLOBAL_401;
import static br.com.lucas.gestorfinanceiroapi.exception.GlobalExceptionHandler.MENSAGEM_GLOBAL_403;
import static br.com.lucas.gestorfinanceiroapi.exception.GlobalExceptionHandler.MENSAGEM_GLOBAL_404;
import static br.com.lucas.gestorfinanceiroapi.exception.GlobalExceptionHandler.MENSAGEM_GLOBAL_500;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.lucas.gestorfinanceiroapi.data.Despesa;
import br.com.lucas.gestorfinanceiroapi.domain.response.DespesaResponse;
import br.com.lucas.gestorfinanceiroapi.domain.response.PageDespesasResponse;
import br.com.lucas.gestorfinanceiroapi.exception.ErroInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import br.com.lucas.gestorfinanceiroapi.util.*;

@Api(value = AppConstantes.PATH_CARTOES, produces = APPLICATION_JSON_UTF8_VALUE, tags = { "Despesas" })
public interface DespesaDefinition {

	@ApiOperation(value = "listar despesas", notes = "Lista as despesas", response = DespesaResponse.class)
	@ApiResponses({ @ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
			@ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
			@ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
			@ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
			@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<?> listarDespesas();

	@ApiOperation(value = "Recupera despesa por id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista de despesas", response = PageDespesasResponse.class),
			@ApiResponse(code = 204, message = "Lista de despesas", response = PageDespesasResponse.class),
			@ApiResponse(code = 404, message = "Nenhum registo encontrado", response = PageDespesasResponse.class) })
	ResponseEntity<?> buscarDespesaPorId(@PathVariable String id);

	@ApiOperation(value = "Salva uma despesa")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Despesa salva com sucesso", response = PageDespesasResponse.class),
			@ApiResponse(code = 500, message = "Erro interno no sistema", response = PageDespesasResponse.class) })
	ResponseEntity<?> salvarDespesa(@Valid Despesa despesa);

}
