package br.com.lucas.gestorfinanceiroapi.service;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.lucas.gestorfinanceiroapi.data.CategoriaDespesa;
import br.com.lucas.gestorfinanceiroapi.data.Conta;
import br.com.lucas.gestorfinanceiroapi.domain.request.ContaSalvarRequest;
import br.com.lucas.gestorfinanceiroapi.domain.request.ContaUpdateRequest;
import br.com.lucas.gestorfinanceiroapi.domain.response.CategoriaDespesaResponse;
import br.com.lucas.gestorfinanceiroapi.domain.response.ContaResponse;
import br.com.lucas.gestorfinanceiroapi.domain.response.PageContasResponse;
import br.com.lucas.gestorfinanceiroapi.exception.BadRequestCustom;
import br.com.lucas.gestorfinanceiroapi.exception.ExceptionsMessagesEnum;
import br.com.lucas.gestorfinanceiroapi.exception.NotFoundCustom;
import br.com.lucas.gestorfinanceiroapi.repository.ContaRepository;
import br.com.lucas.gestorfinanceiroapi.util.GenericConvert;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository contaRepository;

	public PageContasResponse listarContas(Integer page, Integer size) {
		Pageable pageable = PageRequest.of(page, size); 
		
		Page<Conta> listaContas = contaRepository.findAll(pageable);
		BadRequestCustom.checkThrow(Objects.isNull(listaContas) || listaContas.getContent().isEmpty(), ExceptionsMessagesEnum.PESQUISA_NAO_ENCONTRADA);
		
		PageContasResponse pageContasResponse = new PageContasResponse(GenericConvert.convertModelMapperToPageResponse(listaContas, new TypeToken<List<ContaResponse>>() {
        }.getType()));
		
		return pageContasResponse;
	}

	public ResponseEntity<Conta> buscarContaPorId(Long id) {
		Conta conta = contaRepository.findById(id).orElse(new Conta());
		NotFoundCustom.checkThrow(Objects.isNull(conta.getId()), ExceptionsMessagesEnum.CONTA_NAO_ENCONTRADA);
		
		return new ResponseEntity<Conta>(conta, HttpStatus.OK);
	}

	public ResponseEntity<ContaResponse> salvarConta(@Valid ContaSalvarRequest contaRequest) {
		Conta conta = convertContaSalvarRequestInConta(contaRequest);
		Conta contaSaved = contaRepository.save(conta);
		
		if(java.util.Objects.isNull(contaSaved)) {
			return new ResponseEntity<ContaResponse>(HttpStatus.INTERNAL_SERVER_ERROR);		
		}
		
		return new ResponseEntity<ContaResponse>(makeResponse(contaSaved), HttpStatus.CREATED);
	}
	
	public void excluirConta(Long id) {
		Conta conta = contaRepository.findById(id).orElse(new Conta());
		NotFoundCustom.checkThrow(Objects.isNull(conta.getId()), ExceptionsMessagesEnum.CONTA_NAO_ENCONTRADA);
		
		contaRepository.delete(conta);
	}

	public ResponseEntity<ContaResponse> atualizarConta(Long id, @Valid ContaUpdateRequest update) {
		Conta conta = contaRepository.findById(id).orElse(new Conta());
		NotFoundCustom.checkThrow(Objects.isNull(conta.getId()), ExceptionsMessagesEnum.CONTA_NAO_ENCONTRADA);
		
		 if (Objects.nonNull(update.getNome()))
			 conta.setNome(update.getNome());
		 
		 if (Objects.nonNull(update.getStatusSaldoInicial()))
			 conta.setStatusSaldoInicial(update.getStatusSaldoInicial());
		 
		 if (Objects.nonNull(update.getSaldoInicial()))
			 conta.setSaldoInicial(update.getSaldoInicial());
		 
		
		 Conta contaUpdated = contaRepository.save(conta);
		
		if(java.util.Objects.isNull(contaUpdated)) {
			return new ResponseEntity<ContaResponse>(HttpStatus.INTERNAL_SERVER_ERROR);		
		}
		
		return new ResponseEntity<ContaResponse>(makeResponse(contaUpdated), HttpStatus.OK);
	}
	
	private ContaResponse makeResponse(Conta contaSaved) {
		ContaResponse retorno = new ContaResponse();
		retorno.setId(contaSaved.getId());
		retorno.setNome(contaSaved.getNome());
		retorno.setSaldoInicial(contaSaved.getSaldoInicial());
		retorno.setStatusSaldoInicial(contaSaved.getStatusSaldoInicial());
		return retorno;
	}
	
	private Conta convertContaSalvarRequestInConta(ContaSalvarRequest contaRequest) {
		Conta retorno = new Conta();
		retorno.setNome(contaRequest.getNome());
		retorno.setSaldoInicial(contaRequest.getSaldoInicial());
		retorno.setStatusSaldoInicial(contaRequest.getStatusSaldoInicial());
		return retorno;
	}

}
