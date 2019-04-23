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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.gestorfinanceiroapi.domain.request.ReceitaSalvarRequest;
import br.com.lucas.gestorfinanceiroapi.domain.request.ReceitaUpdateRequest;
import br.com.lucas.gestorfinanceiroapi.domain.response.PageReceitasResponse;
import br.com.lucas.gestorfinanceiroapi.domain.response.ReceitaResponse;
import br.com.lucas.gestorfinanceiroapi.exception.BadRequestCustom;
import br.com.lucas.gestorfinanceiroapi.exception.ExceptionsMessagesEnum;
import br.com.lucas.gestorfinanceiroapi.service.ReceitaService;
import br.com.lucas.gestorfinanceiroapi.util.AppConstantes;

@RestController
@RequestMapping(value = AppConstantes.PATH_RECEITAS, produces = APPLICATION_JSON_UTF8_VALUE)
public class ReceitaResource implements ReceitaDefinition {
	
	@Autowired
	private ReceitaService receitaService;

	@GetMapping(value = AppConstantes.PATH_LISTAR, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<PageReceitasResponse> listarReceitas(Integer page, Integer size) {
		return ResponseEntity.ok(receitaService.listarReceitas(page, size));
	}

	@GetMapping(value = AppConstantes.PATH_ID, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReceitaResponse> buscarReceitaPorId(Long id) {
		BadRequestCustom.checkThrow(Objects.isNull(id), ExceptionsMessagesEnum.REQUIRED_ID);

		return receitaService.buscarReceitaPorId(id);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReceitaResponse> salvarReceita(@Valid ReceitaSalvarRequest receita) {
		return receitaService.salvarReceita(receita);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = AppConstantes.PATH_ID, produces = APPLICATION_JSON_UTF8_VALUE)
	public void excluir(Long id) {
		receitaService.excluirReceita(id);		
	}

	@PatchMapping(value = AppConstantes.PATH_ID, produces = APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReceitaResponse> atualizarReceita(Long id, @Valid ReceitaUpdateRequest update) {
		return receitaService.atualizarReceita(id, update);
	}

}
