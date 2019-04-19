package br.com.lucas.gestorfinanceiroapi.resource;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.gestorfinanceiroapi.domain.request.CategoriaSalvarRequest;
import br.com.lucas.gestorfinanceiroapi.domain.request.CategoriaUpdateRequest;
import br.com.lucas.gestorfinanceiroapi.domain.response.CategoriaDespesaResponse;
import br.com.lucas.gestorfinanceiroapi.domain.response.PageCategoriasResponse;
import br.com.lucas.gestorfinanceiroapi.exception.BadRequestCustom;
import br.com.lucas.gestorfinanceiroapi.exception.ExceptionsMessagesEnum;
import br.com.lucas.gestorfinanceiroapi.service.CategoriaService;
import br.com.lucas.gestorfinanceiroapi.util.AppConstantes;

@RestController
@RequestMapping(value = AppConstantes.PATH_CATEGORIAS, produces = APPLICATION_JSON_UTF8_VALUE)
public class CategoriaResource implements CategoriaDefinition {
	
	@Autowired
	private CategoriaService categoriaService;

	
	@GetMapping(value = AppConstantes.PATH_LISTAR, produces = APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<PageCategoriasResponse> listarCategorias(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "50") Integer size) {
		return ResponseEntity.ok(categoriaService.listarCategorias(page, size));
	}

	@GetMapping(value = AppConstantes.PATH_ID, produces = APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> buscarCategoriaPorId(Long id) {
		BadRequestCustom.checkThrow(Objects.isNull(id), ExceptionsMessagesEnum.REQUIRED_ID);

		return categoriaService.buscarCategoriaPorId(id);
	}

	@PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> salvarCategoria(@RequestBody(required = true) @Valid CategoriaSalvarRequest categoria) {
		return categoriaService.salvarCategoria(categoria);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = AppConstantes.PATH_ID, produces = APPLICATION_JSON_UTF8_VALUE)
	public void excluir(Long id) {
		categoriaService.excluirCategoria(id);
	}

	@PatchMapping(value = AppConstantes.PATH_ID, produces = APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CategoriaDespesaResponse> atualizarCategoria(Long id, @RequestBody(required = true) @Valid CategoriaUpdateRequest update) {
		return categoriaService.atualizarCategoria(id, update);
	}
}
