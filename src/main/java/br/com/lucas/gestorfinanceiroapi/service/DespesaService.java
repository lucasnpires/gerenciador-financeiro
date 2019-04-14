package br.com.lucas.gestorfinanceiroapi.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.lucas.gestorfinanceiroapi.data.CategoriaDespesa;
import br.com.lucas.gestorfinanceiroapi.data.Conta;
import br.com.lucas.gestorfinanceiroapi.data.Despesa;
import br.com.lucas.gestorfinanceiroapi.domain.request.DespesaSalvarRequest;
import br.com.lucas.gestorfinanceiroapi.exception.BadRequestCustom;
import br.com.lucas.gestorfinanceiroapi.exception.ExceptionsMessagesEnum;
import br.com.lucas.gestorfinanceiroapi.exception.NotFoundCustom;
import br.com.lucas.gestorfinanceiroapi.repository.CategoriaRepository;
import br.com.lucas.gestorfinanceiroapi.repository.ContaRepository;
import br.com.lucas.gestorfinanceiroapi.repository.DespesaRepository;

@Service
public class DespesaService {
	
	@Autowired
	private DespesaRepository despesaRepository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public ResponseEntity<Page<Despesa>> listarDespesas(Integer page, Integer size) {
		Pageable pageable = PageRequest.of(page, size); 
		
		Page<Despesa> despesas = despesaRepository.findAll(pageable);
		
		BadRequestCustom.checkThrow(Objects.isNull(despesas), ExceptionsMessagesEnum.GLOBAL_ERRO_SERVIDOR);
		
		return new ResponseEntity<Page<Despesa>>(despesas, HttpStatus.OK);
	}
	
	public ResponseEntity<Despesa> buscarDespesaPorId(Long id) {
		Despesa despesa = despesaRepository.findById(id).orElse(new Despesa());
		
		NotFoundCustom.checkThrow(Objects.isNull(despesa.getId()), ExceptionsMessagesEnum.DESPESA_NAO_ENCONTRADA);
		
		return new ResponseEntity<Despesa>(despesa, HttpStatus.OK);
	}

	public ResponseEntity<?> salvarDespesa(DespesaSalvarRequest despesaRequest) {
		Conta conta = contaRepository.findById(despesaRequest.getIdConta()).orElse(new Conta());
		NotFoundCustom.checkThrow(Objects.isNull(conta.getId()), ExceptionsMessagesEnum.CONTA_NAO_ENCONTRADA);
		
		CategoriaDespesa categoria = categoriaRepository.findById(despesaRequest.getIdCategoria()).orElse(new CategoriaDespesa());
		NotFoundCustom.checkThrow(Objects.isNull(categoria.getId()), ExceptionsMessagesEnum.CATEGORIA_NAO_ENCONTRADA);
		
		Despesa despesa = convertDespesaRequestInDespesa(despesaRequest);
		
		Despesa despesaSave = despesaRepository.save(despesa);
		
		if(java.util.Objects.isNull(despesaSave)) {
			return new ResponseEntity<Despesa>(HttpStatus.INTERNAL_SERVER_ERROR);		
		}
		
		return new ResponseEntity<Despesa>(despesaSave, HttpStatus.CREATED);
	}

	private Despesa convertDespesaRequestInDespesa(DespesaSalvarRequest despesaRequest) {
		Despesa retorno = new Despesa();
		retorno.setConta(contaRepository.findById(despesaRequest.getIdConta()).orElse(new Conta()));
		retorno.setCategoria(categoriaRepository.findById(despesaRequest.getIdCategoria()).orElse(new CategoriaDespesa()));
		retorno.setDataDespesa(despesaRequest.getDataDespesa());
		retorno.setTotal(despesaRequest.getTotal());
		return retorno;
	}

	public void excluirConta(Long id) {
		Despesa despesa = despesaRepository.findById(id).orElse(new Despesa());
		NotFoundCustom.checkThrow(Objects.isNull(despesa.getId()), ExceptionsMessagesEnum.DESPESA_NAO_ENCONTRADA);
		
		despesaRepository.delete(despesa);
		
	}
	
}
