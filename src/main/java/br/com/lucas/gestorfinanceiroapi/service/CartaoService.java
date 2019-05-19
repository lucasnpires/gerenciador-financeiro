package br.com.lucas.gestorfinanceiroapi.service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

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

import br.com.lucas.gestorfinanceiroapi.data.Cartao;
import br.com.lucas.gestorfinanceiroapi.data.Conta;
import br.com.lucas.gestorfinanceiroapi.domain.request.CartaoSalvarRequest;
import br.com.lucas.gestorfinanceiroapi.domain.request.CartaoUpdateRequest;
import br.com.lucas.gestorfinanceiroapi.domain.response.CartaoResponse;
import br.com.lucas.gestorfinanceiroapi.domain.response.PageCartoesResponse;
import br.com.lucas.gestorfinanceiroapi.exception.BadRequestCustom;
import br.com.lucas.gestorfinanceiroapi.exception.ExceptionsMessagesEnum;
import br.com.lucas.gestorfinanceiroapi.exception.NotFoundCustom;
import br.com.lucas.gestorfinanceiroapi.repository.CartaoRepository;
import br.com.lucas.gestorfinanceiroapi.repository.ContaRepository;
import br.com.lucas.gestorfinanceiroapi.util.GenericConvert;

@Service
public class CartaoService {

	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private ContaRepository contaRepository;

	public PageCartoesResponse listarCartoes(Integer page, Integer size) {
		Pageable pageable = PageRequest.of(page, size);

		Page<Cartao> listaCartoes = cartaoRepository.findAll(pageable);
		BadRequestCustom.checkThrow(isNull(listaCartoes),
				ExceptionsMessagesEnum.PESQUISA_NAO_ENCONTRADA);

		return new PageCartoesResponse(GenericConvert
				.convertModelMapperToPageResponse(listaCartoes, new TypeToken<List<CartaoResponse>>() {
				}.getType()));
	}

	public ResponseEntity<CartaoResponse> buscarCartaoPorId(Long id) {
		Cartao cartao = cartaoRepository.findById(id).orElse(new Cartao());
		NotFoundCustom.checkThrow(isNull(cartao.getId()), ExceptionsMessagesEnum.CARTAO_NAO_ENCONTRADO);

		return new ResponseEntity<>(makeResponse(cartao), HttpStatus.OK);
	}

	public ResponseEntity<CartaoResponse> salvarCartao(@Valid CartaoSalvarRequest cartaoRequest) {
		// busca a conta pelo id informado e verifica se existe
		Conta conta = contaRepository.findById(cartaoRequest.getIdConta()).orElse(new Conta());
		NotFoundCustom.checkThrow(isNull(conta.getId()), ExceptionsMessagesEnum.CONTA_NAO_ENCONTRADA);

		Cartao cartao = convertCartaoSalvarRequestInCartao(cartaoRequest, conta);
		
		Cartao cartaoSaved = cartaoRepository.save(cartao);

		if (isNull(cartaoSaved)) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(makeResponse(cartaoSaved), HttpStatus.CREATED);
	}

	public void excluirCartao(Long id) {
		Cartao cartao = cartaoRepository.findById(id).orElse(new Cartao());
		NotFoundCustom.checkThrow(Objects.isNull(cartao.getId()), ExceptionsMessagesEnum.CARTAO_NAO_ENCONTRADO);
		
		cartaoRepository.delete(cartao);

	}

	public ResponseEntity<CartaoResponse> atualizarCartao(Long id, @Valid CartaoUpdateRequest update) {
		Cartao cartao = cartaoRepository.findById(id).orElse(new Cartao());
		NotFoundCustom.checkThrow(Objects.isNull(cartao.getId()), ExceptionsMessagesEnum.CARTAO_NAO_ENCONTRADO);
		
		Conta conta = contaRepository.findById(update.getIdConta()).orElse(new Conta());	
		NotFoundCustom.checkThrow(Objects.isNull(conta.getId()), ExceptionsMessagesEnum.CONTA_NAO_ENCONTRADA);
		
		 if (nonNull(update.getDescricao()))
			 cartao.setDescricao(update.getDescricao());
		 
		 if (nonNull(update.getLimite()))
			 cartao.setLimite(update.getLimite());
		 
		 if (nonNull(update.getDiaFechamento()))
			 cartao.setDiaFechamento(update.getDiaFechamento());
		 
		 if (nonNull(update.getDiaPagamento()))
			 cartao.setDiaPagamento(update.getDiaPagamento());
		 
		 if (nonNull(update.getBandeira()))
			 cartao.setBandeira(update.getBandeira());
		 
		 if (nonNull(update.getIdConta()))
			 cartao.setConta(conta);
		
		 Cartao cartaoUpdated = cartaoRepository.save(cartao);
		
		if(isNull(cartaoUpdated)) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);		
		}
		
		return new ResponseEntity<>(makeResponse(cartaoUpdated), HttpStatus.OK);
	}

	private Cartao convertCartaoSalvarRequestInCartao(CartaoSalvarRequest cartaoRequest, Conta conta) {
		Cartao cartao = new Cartao();
		cartao.setDescricao(cartaoRequest.getDescricao());
		cartao.setBandeira(cartaoRequest.getBandeira());
		cartao.setConta(conta);
		cartao.setDiaFechamento(cartaoRequest.getDiaFechamento());
		cartao.setDiaPagamento(cartaoRequest.getDiaPagamento());
		cartao.setLimite(cartaoRequest.getLimite());
		return cartao;
	}

	private CartaoResponse makeResponse(Cartao cartaoSaved) {
		CartaoResponse cartaoResponse = new CartaoResponse();
		cartaoResponse.setId(cartaoSaved.getId());
		cartaoResponse.setDescricao(cartaoSaved.getDescricao());
		cartaoResponse.setBandeira(cartaoSaved.getBandeira());
		cartaoResponse.setDiaFechamento(cartaoSaved.getDiaFechamento());
		cartaoResponse.setDiaPagamento(cartaoSaved.getDiaPagamento());
		cartaoResponse.setConta(cartaoSaved.getConta());
		cartaoResponse.setLimite(cartaoSaved.getLimite());
		return cartaoResponse;
	}

}
