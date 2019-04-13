package br.com.lucas.gestorfinanceiroapi.resource;


import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.gestorfinanceiroapi.data.Despesa;
import br.com.lucas.gestorfinanceiroapi.service.DespesaService;
import br.com.lucas.gestorfinanceiroapi.util.AppConstantes;

@RestController
@RequestMapping(value = AppConstantes.PATH_DESPESAS, produces = APPLICATION_JSON_UTF8_VALUE)
public class DespesaResource implements DespesaDefinition {
	
	@Autowired
	private DespesaService despesasService;

	@GetMapping(value = AppConstantes.PATH_LISTAR, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> listarDespesas() {
		List<Despesa> despesas = despesasService.listarDespesas();
		
		if(despesas.isEmpty()) {
			return new ResponseEntity<List<Despesa>>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Despesa>>(despesas, HttpStatus.OK);
	}

	@GetMapping(value = AppConstantes.PATH_ID, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> buscarDespesaPorId(String id) {
		return new ResponseEntity<Despesa>(HttpStatus.NOT_IMPLEMENTED);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> salvarDespesa(@Valid Despesa despesa) {
		Despesa despesaSalva = despesasService.salvarDespesa(despesa);
		return new ResponseEntity<Despesa>(despesaSalva, HttpStatus.CREATED);
	}
}
