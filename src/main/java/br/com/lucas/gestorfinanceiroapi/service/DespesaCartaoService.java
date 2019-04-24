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

import br.com.lucas.gestorfinanceiroapi.data.Categoria;
import br.com.lucas.gestorfinanceiroapi.data.Conta;
import br.com.lucas.gestorfinanceiroapi.data.DespesaCartao;
import br.com.lucas.gestorfinanceiroapi.domain.request.DespesaCartaoSalvarRequest;
import br.com.lucas.gestorfinanceiroapi.domain.request.DespesaCartaoUpdateRequest;
import br.com.lucas.gestorfinanceiroapi.domain.response.DespesaCartaoResponse;
import br.com.lucas.gestorfinanceiroapi.domain.response.PageDespesasCartaoResponse;
import br.com.lucas.gestorfinanceiroapi.exception.BadRequestCustom;
import br.com.lucas.gestorfinanceiroapi.exception.ExceptionsMessagesEnum;
import br.com.lucas.gestorfinanceiroapi.exception.NotFoundCustom;
import br.com.lucas.gestorfinanceiroapi.repository.CategoriaRepository;
import br.com.lucas.gestorfinanceiroapi.repository.ContaRepository;
import br.com.lucas.gestorfinanceiroapi.repository.DespesaCartaoRepository;
import br.com.lucas.gestorfinanceiroapi.util.GenericConvert;


@Service
public class DespesaCartaoService {
	
	@Autowired
	private DespesaCartaoRepository despesaCartaoRepository;
	
	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	public PageDespesasCartaoResponse listarDespesasCartao(Integer page, Integer size) {
		Pageable pageable = PageRequest.of(page, size);

		Page<DespesaCartao> listaDespesas = despesaCartaoRepository.findAll(pageable);

		BadRequestCustom.checkThrow(Objects.isNull(listaDespesas) || listaDespesas.getContent().isEmpty(),
				ExceptionsMessagesEnum.PESQUISA_NAO_ENCONTRADA);
		
		PageDespesasCartaoResponse pageDespesasResponse = new PageDespesasCartaoResponse(
				GenericConvert.convertModelMapperToPageResponse(listaDespesas, new TypeToken<List<DespesaCartaoResponse>>() {
				}.getType()));

		return pageDespesasResponse;
	}

	public ResponseEntity<DespesaCartaoResponse> buscarDespesasCartaoPorId(Long id) {
		DespesaCartao despesa = despesaCartaoRepository.findById(id).orElse(new DespesaCartao());

		NotFoundCustom.checkThrow(Objects.isNull(despesa.getId()), ExceptionsMessagesEnum.DESPESA_CARTAO_NAO_ENCONTRADA);

		return new ResponseEntity<DespesaCartaoResponse>(makeResponse(despesa), HttpStatus.OK);
	}

	public ResponseEntity<DespesaCartaoResponse> salvarDespesaCartao(@Valid DespesaCartaoSalvarRequest despesaCartaoRequest) {
		Conta conta = contaRepository.findById(despesaCartaoRequest.getIdContaDespesa()).orElse(new Conta());
		NotFoundCustom.checkThrow(Objects.isNull(conta.getId()), ExceptionsMessagesEnum.CONTA_NAO_ENCONTRADA);

		Categoria categoria = categoriaRepository.findById(despesaCartaoRequest.getIdCategoriaDespesa())
				.orElse(new Categoria());
		NotFoundCustom.checkThrow(Objects.isNull(categoria.getId()), ExceptionsMessagesEnum.CATEGORIA_NAO_ENCONTRADA);

		DespesaCartao despesaCartao = convertDespesaCartaoRequestInDespesaCartao(despesaCartaoRequest, conta, categoria);
		
		DespesaCartao despesaCartaoSave = despesaCartaoRepository.save(despesaCartao);

		if (java.util.Objects.isNull(despesaCartaoSave)) {
			return new ResponseEntity<DespesaCartaoResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<DespesaCartaoResponse>(makeResponse(despesaCartao), HttpStatus.CREATED);
	}

	public void excluirDespesaCartao(Long id) {
		DespesaCartao despesaCartao = despesaCartaoRepository.findById(id).orElse(new DespesaCartao());
		NotFoundCustom.checkThrow(Objects.isNull(despesaCartao.getId()), ExceptionsMessagesEnum.DESPESA_CARTAO_NAO_ENCONTRADA);

		despesaCartaoRepository.delete(despesaCartao);
	}

	public ResponseEntity<DespesaCartaoResponse> atualizarDespesaCartao(Long id,
			@Valid DespesaCartaoUpdateRequest update) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private DespesaCartaoResponse makeResponse(DespesaCartao despesa) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private DespesaCartao convertDespesaCartaoRequestInDespesaCartao(DespesaCartaoSalvarRequest despesaCartaoRequest, Conta conta,
			Categoria categoria) {
		return null;
	}

}
