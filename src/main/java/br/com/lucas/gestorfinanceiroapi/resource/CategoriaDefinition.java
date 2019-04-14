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

import br.com.lucas.gestorfinanceiroapi.data.Categoria;
import br.com.lucas.gestorfinanceiroapi.domain.request.CategoriaSalvarRequest;
import br.com.lucas.gestorfinanceiroapi.domain.request.CategoriaUpdateRequest;
import br.com.lucas.gestorfinanceiroapi.domain.response.PageCategoriasResponse;
import br.com.lucas.gestorfinanceiroapi.exception.ErroInfo;
import br.com.lucas.gestorfinanceiroapi.util.AppConstantes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = AppConstantes.PATH_CATEGORIAS, produces = APPLICATION_JSON_UTF8_VALUE, tags = { "Categorias" })
public interface CategoriaDefinition {

	@ApiOperation(value = "Listar as categorias", notes = "Listar as categorias", response = PageCategoriasResponse.class)
	@ApiResponses({ @ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
			@ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
			@ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
			@ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
			@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<?> listarCategorias(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "50") Integer size);

	@ApiOperation(value = "Buscar categoria por id", notes = "Buscar categoria por id", response = Categoria.class)
	@ApiResponses({ @ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
			@ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
			@ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
			@ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
			@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<?> buscarCategoriaPorId(
			@ApiParam(value = "Id da categoria", required = true) @PathVariable(name = "id") Long id);

	@ApiOperation(value = "Salvar categoria", notes = "Salvar categoria")
	@ApiResponses({ @ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
			@ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
			@ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
			@ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
			@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<?> salvarCategoria(@RequestBody(required = true) @Valid CategoriaSalvarRequest categoria);

	@ApiOperation(value = "Excluir uma categoria", notes = "Excluir uma categoria")
	@ApiResponses({ @ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
			@ApiResponse(code = 401, message = MENSAGEM_GLOBAL_401, response = ErroInfo.class),
			@ApiResponse(code = 403, message = MENSAGEM_GLOBAL_403, response = ErroInfo.class),
			@ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
			@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	void excluir(
			@ApiParam(value = "Id da categoria, (Ex. 1)", example = "1", required = true) @PathVariable(name = "id") Long id);

	@ApiOperation(value = "Atualizar Categoria", notes = "Atualizar Categoria", response = Categoria.class)
	@ApiResponses({ @ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
			@ApiResponse(code = 412, message = MENSAGEM_GLOBAL_412, response = ErroInfo.class),
			@ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class) })
	ResponseEntity<Categoria> atualizarCategoria(@PathVariable(name = "id") Long id,
			@RequestBody(required = true) @Valid CategoriaUpdateRequest request);

}
