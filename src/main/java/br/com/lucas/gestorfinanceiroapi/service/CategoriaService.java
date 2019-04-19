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
import br.com.lucas.gestorfinanceiroapi.domain.request.CategoriaSalvarRequest;
import br.com.lucas.gestorfinanceiroapi.domain.request.CategoriaUpdateRequest;
import br.com.lucas.gestorfinanceiroapi.domain.response.CategoriaDespesaResponse;
import br.com.lucas.gestorfinanceiroapi.domain.response.PageCategoriasResponse;
import br.com.lucas.gestorfinanceiroapi.exception.BadRequestCustom;
import br.com.lucas.gestorfinanceiroapi.exception.ExceptionsMessagesEnum;
import br.com.lucas.gestorfinanceiroapi.exception.NotFoundCustom;
import br.com.lucas.gestorfinanceiroapi.repository.CategoriaRepository;
import br.com.lucas.gestorfinanceiroapi.util.GenericConvert;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	

	public ResponseEntity<CategoriaDespesaResponse> salvarCategoria(@Valid CategoriaSalvarRequest categoriaRequest) {
		CategoriaDespesa categoria = convertCategoriaSalvarRequesttInCategoria(categoriaRequest);
		CategoriaDespesa categoriaSaved = categoriaRepository.save(categoria);
		
		if(java.util.Objects.isNull(categoriaSaved)) {
			return new ResponseEntity<CategoriaDespesaResponse>(HttpStatus.INTERNAL_SERVER_ERROR);		
		}
		return new ResponseEntity<CategoriaDespesaResponse>(makeResponse(categoriaSaved), HttpStatus.CREATED);
	}


	public ResponseEntity<CategoriaDespesaResponse> buscarCategoriaPorId(Long id) {
		CategoriaDespesa categoria = categoriaRepository.findById(id).orElse(new CategoriaDespesa());
		NotFoundCustom.checkThrow(Objects.isNull(categoria.getId()), ExceptionsMessagesEnum.CATEGORIA_NAO_ENCONTRADA);
		
		return new ResponseEntity<CategoriaDespesaResponse>(makeResponse(categoria), HttpStatus.OK);
	}

	public PageCategoriasResponse listarCategorias(Integer page, Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		
		Page<CategoriaDespesa> listaCategorias = categoriaRepository.findAll(pageable);
		BadRequestCustom.checkThrow(Objects.isNull(listaCategorias) || listaCategorias.getContent().isEmpty(), ExceptionsMessagesEnum.PESQUISA_NAO_ENCONTRADA);
		
		PageCategoriasResponse pageCategoriasResponse = new PageCategoriasResponse(GenericConvert
				.convertModelMapperToPageResponse(listaCategorias, new TypeToken<List<CategoriaDespesaResponse>>() {
				}.getType()));

		return pageCategoriasResponse;
	}
	

	public void excluirCategoria(Long id) {
		CategoriaDespesa categoria = categoriaRepository.findById(id).orElse(new CategoriaDespesa());
		NotFoundCustom.checkThrow(Objects.isNull(categoria.getId()), ExceptionsMessagesEnum.CATEGORIA_NAO_ENCONTRADA);
		
		categoriaRepository.delete(categoria);
	}

	public ResponseEntity<CategoriaDespesaResponse> atualizarCategoria(Long id, @Valid CategoriaUpdateRequest update) {
		CategoriaDespesa categoria = categoriaRepository.findById(id).orElse(new CategoriaDespesa());
		NotFoundCustom.checkThrow(Objects.isNull(categoria.getId()), ExceptionsMessagesEnum.CATEGORIA_NAO_ENCONTRADA);
		
		 if (Objects.nonNull(update.getDescricao()))
			 categoria.setDescricao(update.getDescricao());
		 
		 if (Objects.nonNull(update.getTipoCategoria()))
			 categoria.setTipoCategoria(update.getTipoCategoria());
		 
		
		CategoriaDespesa categoriaUpdated = categoriaRepository.save(categoria);
		
		if(java.util.Objects.isNull(categoriaUpdated)) {
			return new ResponseEntity<CategoriaDespesaResponse>(HttpStatus.INTERNAL_SERVER_ERROR);		
		}
		
		return new ResponseEntity<CategoriaDespesaResponse>(makeResponse(categoriaUpdated), HttpStatus.OK);
	}
	
	
	private CategoriaDespesaResponse makeResponse(CategoriaDespesa categoriaSaved) {
		CategoriaDespesaResponse retorno = new CategoriaDespesaResponse();
		retorno.setId(categoriaSaved.getId());
		retorno.setDescricao(categoriaSaved.getDescricao());
		retorno.setTipoCategoria(categoriaSaved.getTipoCategoria());
		return retorno;
	}
	
	private CategoriaDespesa convertCategoriaSalvarRequesttInCategoria(@Valid CategoriaSalvarRequest categoriaRequest) {
		CategoriaDespesa retorno = new CategoriaDespesa();
		retorno.setDescricao(categoriaRequest.getDescricao());
		retorno.setTipoCategoria(categoriaRequest.getTipoCategoria());
		return retorno;
	}

}
