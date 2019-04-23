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
import br.com.lucas.gestorfinanceiroapi.data.Receita;
import br.com.lucas.gestorfinanceiroapi.domain.request.ReceitaSalvarRequest;
import br.com.lucas.gestorfinanceiroapi.domain.request.ReceitaUpdateRequest;
import br.com.lucas.gestorfinanceiroapi.domain.response.PageReceitasResponse;
import br.com.lucas.gestorfinanceiroapi.domain.response.ReceitaResponse;
import br.com.lucas.gestorfinanceiroapi.exception.BadRequestCustom;
import br.com.lucas.gestorfinanceiroapi.exception.ExceptionsMessagesEnum;
import br.com.lucas.gestorfinanceiroapi.exception.NotFoundCustom;
import br.com.lucas.gestorfinanceiroapi.repository.CategoriaRepository;
import br.com.lucas.gestorfinanceiroapi.repository.ContaRepository;
import br.com.lucas.gestorfinanceiroapi.repository.ReceitaRepository;
import br.com.lucas.gestorfinanceiroapi.util.GenericConvert;

@Service
public class ReceitaService {

	@Autowired
	private ReceitaRepository receitaRepository;

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	public PageReceitasResponse listarReceitas(Integer page, Integer size) {
		Pageable pageable = PageRequest.of(page, size);

		Page<Receita> listaReceitas = receitaRepository.findAll(pageable);
		BadRequestCustom.checkThrow(Objects.isNull(listaReceitas) || listaReceitas.getContent().isEmpty(),
				ExceptionsMessagesEnum.PESQUISA_NAO_ENCONTRADA);

		PageReceitasResponse pageReceitasResponse = new PageReceitasResponse(
				GenericConvert.convertModelMapperToPageResponse(listaReceitas, new TypeToken<List<ReceitaResponse>>() {
				}.getType()));

		return pageReceitasResponse;
	}

	public ResponseEntity<ReceitaResponse> buscarReceitaPorId(Long id) {
		Receita receita = receitaRepository.findById(id).orElse(new Receita());
		NotFoundCustom.checkThrow(Objects.isNull(receita.getId()), ExceptionsMessagesEnum.RECEITA_NAO_ENCONTRADA);

		return new ResponseEntity<ReceitaResponse>(makeResponse(receita), HttpStatus.OK);
	}

	public ResponseEntity<ReceitaResponse> salvarReceita(@Valid ReceitaSalvarRequest receitaRequest) {
		Conta conta = contaRepository.findById(receitaRequest.getIdContaReceita()).orElse(new Conta());
		NotFoundCustom.checkThrow(Objects.isNull(conta.getId()), ExceptionsMessagesEnum.CONTA_NAO_ENCONTRADA);

		Categoria categoria = categoriaRepository.findById(receitaRequest.getIdCategoriaReceita())
				.orElse(new Categoria());
		NotFoundCustom.checkThrow(Objects.isNull(categoria.getId()), ExceptionsMessagesEnum.CATEGORIA_NAO_ENCONTRADA);

		Receita receita = convertReceitaRequestInReceita(receitaRequest, conta, categoria);

		Receita receitaSaved = receitaRepository.save(receita);

		if (java.util.Objects.isNull(receitaSaved)) {
			return new ResponseEntity<ReceitaResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<ReceitaResponse>(makeResponse(receita), HttpStatus.CREATED);
	}

	public void excluirReceita(Long id) {
		Receita receita = receitaRepository.findById(id).orElse(new Receita());
		NotFoundCustom.checkThrow(Objects.isNull(receita.getId()), ExceptionsMessagesEnum.RECEITA_NAO_ENCONTRADA);

		receitaRepository.delete(receita);
	}

	public ResponseEntity<ReceitaResponse> atualizarReceita(Long id, @Valid ReceitaUpdateRequest update) {
		Receita receita = receitaRepository.findById(id).orElse(new Receita());
		NotFoundCustom.checkThrow(Objects.isNull(receita.getId()), ExceptionsMessagesEnum.RECEITA_NAO_ENCONTRADA);

		Conta conta = contaRepository.findById(update.getIdContaReceita()).orElse(new Conta());
		NotFoundCustom.checkThrow(Objects.isNull(conta.getId()), ExceptionsMessagesEnum.CONTA_NAO_ENCONTRADA);

		Categoria categoria = categoriaRepository.findById(update.getIdCategoriaReceita())
				.orElse(new Categoria());
		NotFoundCustom.checkThrow(Objects.isNull(categoria.getId()), ExceptionsMessagesEnum.CATEGORIA_NAO_ENCONTRADA);

		if (Objects.nonNull(update.getDescricao()))
			receita.setDescricao(update.getDescricao());
		
		if (Objects.nonNull(update.getDataReceita()))
			receita.setDataReceita(update.getDataReceita());


		Receita receitaUpdated = receitaRepository.save(receita);

		if (java.util.Objects.isNull(receitaUpdated)) {
			return new ResponseEntity<ReceitaResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<ReceitaResponse>(makeResponse(receitaUpdated), HttpStatus.OK);
	}

	private ReceitaResponse makeResponse(Receita receita) {
		// TODO Auto-generated method stub
		return null;
	}

	private Receita convertReceitaRequestInReceita(@Valid ReceitaSalvarRequest receitaRequest, Conta conta,
			Categoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}

}
