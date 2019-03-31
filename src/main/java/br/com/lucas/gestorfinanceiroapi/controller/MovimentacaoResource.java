package br.com.lucas.gestorfinanceiroapi.controller;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.gestorfinanceiroapi.data.Movimentacao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/movimentacoes")
@Api(value="Movimentacao",produces = MediaType.APPLICATION_JSON_VALUE)
public class MovimentacaoResource {

	@ApiOperation(value = "Lista todas as movimentações")
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movimentacao listar() {
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDataMovimentacao(new Date());
		return movimentacao;
	}

	@ApiOperation(value = "Recupera movimentação por id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movimentacao get(@PathVariable String id) {
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDataMovimentacao(new Date());
		return movimentacao;
	}
}
