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
import br.com.lucas.gestorfinanceiroapi.data.Despesa;
import br.com.lucas.gestorfinanceiroapi.domain.request.DespesaSalvarRequest;
import br.com.lucas.gestorfinanceiroapi.domain.request.DespesaUpdateRequest;
import br.com.lucas.gestorfinanceiroapi.domain.response.DespesaResponse;
import br.com.lucas.gestorfinanceiroapi.domain.response.PageDespesasResponse;
import br.com.lucas.gestorfinanceiroapi.exception.BadRequestCustom;
import br.com.lucas.gestorfinanceiroapi.exception.ExceptionsMessagesEnum;
import br.com.lucas.gestorfinanceiroapi.exception.NotFoundCustom;
import br.com.lucas.gestorfinanceiroapi.repository.CategoriaRepository;
import br.com.lucas.gestorfinanceiroapi.repository.ContaRepository;
import br.com.lucas.gestorfinanceiroapi.repository.DespesaRepository;
import br.com.lucas.gestorfinanceiroapi.util.GenericConvert;

@Service
public class DespesaService {

	@Autowired
	private DespesaRepository despesaRepository;

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	public PageDespesasResponse listarDespesas(Integer page, Integer size) {
		Pageable pageable = PageRequest.of(page, size);

		Page<Despesa> listaDespesas = despesaRepository.findAll(pageable);

		BadRequestCustom.checkThrow(Objects.isNull(listaDespesas) || listaDespesas.getContent().isEmpty(),
				ExceptionsMessagesEnum.PESQUISA_NAO_ENCONTRADA);

		PageDespesasResponse pageDespesasResponse = new PageDespesasResponse(
				GenericConvert.convertModelMapperToPageResponse(listaDespesas, new TypeToken<List<DespesaResponse>>() {
				}.getType()));

		return pageDespesasResponse;
	}

	public ResponseEntity<DespesaResponse> buscarDespesaPorId(Long id) {
		Despesa despesa = despesaRepository.findById(id).orElse(new Despesa());

		NotFoundCustom.checkThrow(Objects.isNull(despesa.getId()), ExceptionsMessagesEnum.DESPESA_NAO_ENCONTRADA);

		return new ResponseEntity<DespesaResponse>(makeResponse(despesa), HttpStatus.OK);
	}

	public ResponseEntity<?> salvarDespesa(DespesaSalvarRequest despesaRequest) {
		Conta conta = contaRepository.findById(despesaRequest.getIdConta()).orElse(new Conta());
		NotFoundCustom.checkThrow(Objects.isNull(conta.getId()), ExceptionsMessagesEnum.CONTA_NAO_ENCONTRADA);

		CategoriaDespesa categoria = categoriaRepository.findById(despesaRequest.getIdCategoria())
				.orElse(new CategoriaDespesa());
		NotFoundCustom.checkThrow(Objects.isNull(categoria.getId()), ExceptionsMessagesEnum.CATEGORIA_NAO_ENCONTRADA);

		Despesa despesa = convertDespesaRequestInDespesa(despesaRequest, conta, categoria);
		
		Despesa despesaSave = despesaRepository.save(despesa);

		if (java.util.Objects.isNull(despesaSave)) {
			return new ResponseEntity<DespesaResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<DespesaResponse>(makeResponse(despesa), HttpStatus.CREATED);
	}

	public void excluirConta(Long id) {
		Despesa despesa = despesaRepository.findById(id).orElse(new Despesa());
		NotFoundCustom.checkThrow(Objects.isNull(despesa.getId()), ExceptionsMessagesEnum.DESPESA_NAO_ENCONTRADA);

		despesaRepository.delete(despesa);

	}

	public ResponseEntity<DespesaResponse> atualizarDespesa(Long id, @Valid DespesaUpdateRequest update) {
		Despesa despesa = despesaRepository.findById(id).orElse(new Despesa());
		NotFoundCustom.checkThrow(Objects.isNull(despesa.getId()), ExceptionsMessagesEnum.DESPESA_NAO_ENCONTRADA);

		Conta conta = contaRepository.findById(update.getIdConta()).orElse(new Conta());
		NotFoundCustom.checkThrow(Objects.isNull(conta.getId()), ExceptionsMessagesEnum.CONTA_NAO_ENCONTRADA);

		CategoriaDespesa categoria = categoriaRepository.findById(update.getIdCategoria())
				.orElse(new CategoriaDespesa());
		NotFoundCustom.checkThrow(Objects.isNull(categoria.getId()), ExceptionsMessagesEnum.CATEGORIA_NAO_ENCONTRADA);

		if (Objects.nonNull(update.getDescricao()))
			despesa.setDescricao(update.getDescricao());

		if (Objects.nonNull(update.getIdConta()))
			despesa.setConta(conta);

		if (Objects.nonNull(update.getIdCategoria()))
			despesa.setCategoria(categoria);

		if (Objects.nonNull(update.getDataDespesa()))
			despesa.setDataDespesa(update.getDataDespesa());

		if (Objects.nonNull(update.getDataDespesa()))
			despesa.setTotal(update.getTotal());

		Despesa despesaUpdated = despesaRepository.save(despesa);

		if (java.util.Objects.isNull(despesaUpdated)) {
			return new ResponseEntity<DespesaResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<DespesaResponse>(makeResponse(despesaUpdated), HttpStatus.OK);
	}

	private DespesaResponse makeResponse(Despesa despesaSaved) {
		DespesaResponse retorno = new DespesaResponse();
		retorno.setId(despesaSaved.getId());
		retorno.setDescricao(despesaSaved.getDescricao());
		retorno.setIdCategoria(despesaSaved.getCategoria().getId());
		retorno.setIdConta(despesaSaved.getConta().getId());
		retorno.setDataDespesa(despesaSaved.getDataDespesa());
		retorno.setTotal(despesaSaved.getTotal());
		return retorno;
	}

	private Despesa convertDespesaRequestInDespesa(DespesaSalvarRequest despesaRequest, Conta conta, CategoriaDespesa categoria) {
		Despesa retorno = new Despesa();
		retorno.setDescricao(despesaRequest.getDescricao());
		retorno.setCategoria(categoria);
		retorno.setTotal(despesaRequest.getTotal());
		retorno.setConta(conta);
		return retorno;
	}
}
