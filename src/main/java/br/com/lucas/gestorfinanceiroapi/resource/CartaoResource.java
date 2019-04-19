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

import br.com.lucas.gestorfinanceiroapi.domain.request.CartaoSalvarRequest;
import br.com.lucas.gestorfinanceiroapi.domain.request.CartaoUpdateRequest;
import br.com.lucas.gestorfinanceiroapi.domain.response.CartaoResponse;
import br.com.lucas.gestorfinanceiroapi.exception.BadRequestCustom;
import br.com.lucas.gestorfinanceiroapi.exception.ExceptionsMessagesEnum;
import br.com.lucas.gestorfinanceiroapi.service.CartaoService;
import br.com.lucas.gestorfinanceiroapi.util.AppConstantes;

@RestController
@RequestMapping(value = AppConstantes.PATH_CARTOES, produces = APPLICATION_JSON_UTF8_VALUE)
public class CartaoResource implements CartaoDefinition {
	
	@Autowired
	private CartaoService cartaoService;

	@GetMapping(value = AppConstantes.PATH_LISTAR, produces = APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> listarCartoes(Integer page, Integer size) {
		return ResponseEntity.ok(cartaoService.listarCartoes(page, size));
	}

	@GetMapping(value = AppConstantes.PATH_ID, produces = APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> buscarCartaoPorId(Long id) {
		BadRequestCustom.checkThrow(Objects.isNull(id), ExceptionsMessagesEnum.REQUIRED_ID);

		return cartaoService.buscarCartaoPorId(id);
	}

	@PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> salvarCartao(@Valid CartaoSalvarRequest cartao) {
		return cartaoService.salvarCartao(cartao);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = AppConstantes.PATH_ID, produces = APPLICATION_JSON_UTF8_VALUE)
	public void excluir(Long id) {
		cartaoService.excluirCartao(id);
	}

	@PatchMapping(value = AppConstantes.PATH_ID, produces = APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CartaoResponse> atualizarCartao(Long id, @Valid CartaoUpdateRequest update) {
		return cartaoService.atualizarCartao(id, update);
	}
}
