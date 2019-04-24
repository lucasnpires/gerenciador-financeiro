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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.gestorfinanceiroapi.domain.request.ContaSalvarRequest;
import br.com.lucas.gestorfinanceiroapi.domain.request.ContaUpdateRequest;
import br.com.lucas.gestorfinanceiroapi.domain.response.PageContasResponse;
import br.com.lucas.gestorfinanceiroapi.exception.BadRequestCustom;
import br.com.lucas.gestorfinanceiroapi.exception.ExceptionsMessagesEnum;
import br.com.lucas.gestorfinanceiroapi.service.ContaService;
import br.com.lucas.gestorfinanceiroapi.util.AppConstantes;

@RestController
@RequestMapping(value = AppConstantes.PATH_CONTAS, produces = APPLICATION_JSON_UTF8_VALUE)
public class ContaResource implements ContaDefinition {

	@Autowired
	private ContaService contaService;

	@GetMapping(value = AppConstantes.PATH_LISTAR, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<PageContasResponse> listarContas(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "50") Integer size) {
		return ResponseEntity.ok(contaService.listarContas(page, size));
	}

	@GetMapping(value = AppConstantes.PATH_ID, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> buscarContaPorId(Long id) {
		BadRequestCustom.checkThrow(Objects.isNull(id), ExceptionsMessagesEnum.REQUIRED_ID);

		return contaService.buscarContaPorId(id);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> salvarConta(@RequestBody(required = true) @Valid ContaSalvarRequest conta) {
		return contaService.salvarConta(conta);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = AppConstantes.PATH_ID, produces = APPLICATION_JSON_UTF8_VALUE)
	public void excluir(Long id) {
		contaService.excluirConta(id);
	}

	@PatchMapping(value = AppConstantes.PATH_ID, produces = APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> atualizarConta(Long id, @RequestBody(required = true) @Valid ContaUpdateRequest update) {
		return contaService.atualizarConta(id, update);
	}
}
