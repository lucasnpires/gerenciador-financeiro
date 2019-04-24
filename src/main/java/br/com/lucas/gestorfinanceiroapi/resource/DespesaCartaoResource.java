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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.gestorfinanceiroapi.domain.request.DespesaCartaoSalvarRequest;
import br.com.lucas.gestorfinanceiroapi.domain.request.DespesaCartaoUpdateRequest;
import br.com.lucas.gestorfinanceiroapi.domain.response.DespesaCartaoResponse;
import br.com.lucas.gestorfinanceiroapi.domain.response.PageDespesasCartaoResponse;
import br.com.lucas.gestorfinanceiroapi.exception.BadRequestCustom;
import br.com.lucas.gestorfinanceiroapi.exception.ExceptionsMessagesEnum;
import br.com.lucas.gestorfinanceiroapi.service.DespesaCartaoService;
import br.com.lucas.gestorfinanceiroapi.util.AppConstantes;

@RestController
@RequestMapping(value = AppConstantes.PATH_DESPESAS_CARTAO, produces = APPLICATION_JSON_UTF8_VALUE)
public class DespesaCartaoResource implements DespesaCartaoDefinition {

	@Autowired
	private DespesaCartaoService despesaCartaoService;

	@GetMapping(value = AppConstantes.PATH_LISTAR, produces = APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<PageDespesasCartaoResponse> listarDespesasCartao(Integer page, Integer size) {
		return ResponseEntity.ok(despesaCartaoService.listarDespesasCartao(page, size));
	}

	@GetMapping(value = AppConstantes.PATH_ID, produces = APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<DespesaCartaoResponse> buscarDespesasCartaoPorId(Long id) {
		BadRequestCustom.checkThrow(Objects.isNull(id), ExceptionsMessagesEnum.REQUIRED_ID);

		return despesaCartaoService.buscarDespesasCartaoPorId(id);
	}

	@PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<DespesaCartaoResponse> salvarDespesaCartao(@Valid DespesaCartaoSalvarRequest despesaCartao) {
		return despesaCartaoService.salvarDespesaCartao(despesaCartao);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = AppConstantes.PATH_ID, produces = APPLICATION_JSON_UTF8_VALUE)
	public void excluir(Long id) {
		despesaCartaoService.excluirDespesaCartao(id);
	}

	@PatchMapping(value = AppConstantes.PATH_ID, produces = APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<DespesaCartaoResponse> atualizarDespesaCartao(Long id,
			@Valid DespesaCartaoUpdateRequest update) {
		return despesaCartaoService.atualizarDespesaCartao(id, update);
	}

}
