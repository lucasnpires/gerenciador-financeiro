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

import br.com.lucas.gestorfinanceiroapi.data.Categoria;
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
		Categoria categoria = convertCategoriaSalvarRequesttInCategoria(categoriaRequest);
		Categoria categoriaSaved = categoriaRepository.save(categoria);
		
		if(java.util.Objects.isNull(categoriaSaved)) {
			return new ResponseEntity<Conta>(HttpStatus.INTERNAL_SERVER_ERROR);		
		}
		
		return new ResponseEntity<Categoria>(categoriaSaved, HttpStatus.CREATED);
	}

	public ResponseEntity<Categoria> buscarCategoriaPorId(Long id) {
		Categoria categoria = categoriaRepository.findById(id).orElse(new Categoria());
		NotFoundCustom.checkThrow(Objects.isNull(categoria.getId()), ExceptionsMessagesEnum.CATEGORIA_NAO_ENCONTRADA);
		
		return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
	}

	public ResponseEntity<Page<Categoria>> listarCategorias(Integer page, Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		
		Page<Categoria> categorias = categoriaRepository.findAll(pageable);
		BadRequestCustom.checkThrow(Objects.isNull(categorias), ExceptionsMessagesEnum.GLOBAL_ERRO_SERVIDOR);

		return new ResponseEntity<Page<Categoria>>(categorias, HttpStatus.OK);
	}
	

	private Categoria convertCategoriaSalvarRequesttInCategoria(@Valid CategoriaSalvarRequest categoriaRequest) {
		Categoria retorno = new Categoria();
		retorno.setDescricao(categoriaRequest.getDescricao());
		retorno.setTipoCategoria(categoriaRequest.getTipoCategoria());
		return retorno;
	}

	public void excluirCategoria(Long id) {
		Categoria categoria = categoriaRepository.findById(id).orElse(new Categoria());
		NotFoundCustom.checkThrow(Objects.isNull(categoria.getId()), ExceptionsMessagesEnum.CATEGORIA_NAO_ENCONTRADA);
		
		categoriaRepository.delete(categoria);
	}

	public ResponseEntity<Categoria> atualizarCategoria(Long id, @Valid CategoriaUpdateRequest update) {
		Categoria categoria = categoriaRepository.findById(id).orElse(new Categoria());
		NotFoundCustom.checkThrow(Objects.isNull(categoria.getId()), ExceptionsMessagesEnum.CATEGORIA_NAO_ENCONTRADA);
		
		 if (Objects.nonNull(update.getDescricao()))
			 categoria.setDescricao(update.getDescricao());
		 
		 if (Objects.nonNull(update.getTipoCategoria()))
			 categoria.setTipoCategoria(update.getTipoCategoria());
		 
		
		Categoria categoriaUpdated = categoriaRepository.save(categoria);
		
		if(java.util.Objects.isNull(categoriaUpdated)) {
			return new ResponseEntity<Categoria>(HttpStatus.INTERNAL_SERVER_ERROR);		
		}
		
		return new ResponseEntity<Categoria>(HttpStatus.OK);
	}

}
