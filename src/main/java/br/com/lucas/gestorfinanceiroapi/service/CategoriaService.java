package br.com.lucas.gestorfinanceiroapi.service;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.lucas.gestorfinanceiroapi.data.CategoriaDespesa;
import br.com.lucas.gestorfinanceiroapi.data.Conta;
import br.com.lucas.gestorfinanceiroapi.domain.request.CategoriaSalvarRequest;
import br.com.lucas.gestorfinanceiroapi.domain.request.CategoriaUpdateRequest;
import br.com.lucas.gestorfinanceiroapi.exception.BadRequestCustom;
import br.com.lucas.gestorfinanceiroapi.exception.ExceptionsMessagesEnum;
import br.com.lucas.gestorfinanceiroapi.exception.NotFoundCustom;
import br.com.lucas.gestorfinanceiroapi.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	

	public ResponseEntity<?> salvarCategoria(@Valid CategoriaSalvarRequest categoriaRequest) {
		CategoriaDespesa categoria = convertCategoriaSalvarRequesttInCategoria(categoriaRequest);
		CategoriaDespesa categoriaSaved = categoriaRepository.save(categoria);
		
		if(java.util.Objects.isNull(categoriaSaved)) {
			return new ResponseEntity<Conta>(HttpStatus.INTERNAL_SERVER_ERROR);		
		}
		
		return new ResponseEntity<CategoriaDespesa>(categoriaSaved, HttpStatus.CREATED);
	}

	public ResponseEntity<CategoriaDespesa> buscarCategoriaPorId(Long id) {
		CategoriaDespesa categoria = categoriaRepository.findById(id).orElse(new CategoriaDespesa());
		NotFoundCustom.checkThrow(Objects.isNull(categoria.getId()), ExceptionsMessagesEnum.CATEGORIA_NAO_ENCONTRADA);
		
		return new ResponseEntity<CategoriaDespesa>(categoria, HttpStatus.OK);
	}

	public ResponseEntity<Page<CategoriaDespesa>> listarCategorias(Integer page, Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		
		Page<CategoriaDespesa> categorias = categoriaRepository.findAll(pageable);
		BadRequestCustom.checkThrow(Objects.isNull(categorias), ExceptionsMessagesEnum.GLOBAL_ERRO_SERVIDOR);

		return new ResponseEntity<Page<CategoriaDespesa>>(categorias, HttpStatus.OK);
	}
	

	private CategoriaDespesa convertCategoriaSalvarRequesttInCategoria(@Valid CategoriaSalvarRequest categoriaRequest) {
		CategoriaDespesa retorno = new CategoriaDespesa();
		retorno.setDescricao(categoriaRequest.getDescricao());
		retorno.setTipoCategoria(categoriaRequest.getTipoCategoria());
		return retorno;
	}

	public void excluirCategoria(Long id) {
		CategoriaDespesa categoria = categoriaRepository.findById(id).orElse(new CategoriaDespesa());
		NotFoundCustom.checkThrow(Objects.isNull(categoria.getId()), ExceptionsMessagesEnum.CATEGORIA_NAO_ENCONTRADA);
		
		categoriaRepository.delete(categoria);
	}

	public ResponseEntity<CategoriaDespesa> atualizarCategoria(Long id, @Valid CategoriaUpdateRequest update) {
		CategoriaDespesa categoria = categoriaRepository.findById(id).orElse(new CategoriaDespesa());
		NotFoundCustom.checkThrow(Objects.isNull(categoria.getId()), ExceptionsMessagesEnum.CATEGORIA_NAO_ENCONTRADA);
		
		 if (Objects.nonNull(update.getDescricao()))
			 categoria.setDescricao(update.getDescricao());
		 
		 if (Objects.nonNull(update.getTipoCategoria()))
			 categoria.setTipoCategoria(update.getTipoCategoria());
		 
		
		CategoriaDespesa categoriaUpdated = categoriaRepository.save(categoria);
		
		if(java.util.Objects.isNull(categoriaUpdated)) {
			return new ResponseEntity<CategoriaDespesa>(HttpStatus.INTERNAL_SERVER_ERROR);		
		}
		
		return new ResponseEntity<CategoriaDespesa>(HttpStatus.OK);
	}

}
