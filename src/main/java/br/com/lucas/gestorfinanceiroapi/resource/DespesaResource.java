package br.com.lucas.gestorfinanceiroapi.resource;


import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.gestorfinanceiroapi.domain.request.DespesaSalvarRequest;
import br.com.lucas.gestorfinanceiroapi.domain.request.DespesaUpdateRequest;
import br.com.lucas.gestorfinanceiroapi.domain.response.PageDespesasResponse;
import br.com.lucas.gestorfinanceiroapi.exception.BadRequestCustom;
import br.com.lucas.gestorfinanceiroapi.exception.ExceptionsMessagesEnum;
import br.com.lucas.gestorfinanceiroapi.service.DespesaService;
import br.com.lucas.gestorfinanceiroapi.util.AppConstantes;

@RestController
@RequestMapping(value = AppConstantes.PATH_DESPESAS, produces = APPLICATION_JSON_UTF8_VALUE)
public class DespesaResource implements DespesaDefinition {
	
	@Autowired
	private DespesaService despesaService;

	@GetMapping(value = AppConstantes.PATH_LISTAR, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<PageDespesasResponse> listarDespesas(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "50") Integer size) {
		return ResponseEntity.ok(despesaService.listarDespesas(page, size));
	}

	@GetMapping(value = AppConstantes.PATH_ID, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> buscarDespesaPorId(@PathVariable(name = "id") Long id) {
		BadRequestCustom.checkThrow(Objects.isNull(id), ExceptionsMessagesEnum.REQUIRED_ID);

		return despesaService.buscarDespesaPorId(id);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> salvarDespesa(@RequestBody(required = true) @Valid DespesaSalvarRequest despesa) {
		return despesaService.salvarDespesa(despesa);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = AppConstantes.PATH_ID, produces = APPLICATION_JSON_UTF8_VALUE)
	public void excluir(Long id) {
		despesaService.excluirConta(id);
	}

	@PatchMapping(value = AppConstantes.PATH_ID, produces = APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> atualizarDespesa(Long id, @Valid DespesaUpdateRequest update) {
		return despesaService.atualizarDespesa(id, update);
	}

}
