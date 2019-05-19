package br.com.lucas.gestorfinanceiroapi.service;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.lucas.gestorfinanceiroapi.data.Cartao;
import br.com.lucas.gestorfinanceiroapi.data.Conta;
import br.com.lucas.gestorfinanceiroapi.domain.request.CartaoSalvarRequest;
import br.com.lucas.gestorfinanceiroapi.domain.response.CartaoResponse;
import br.com.lucas.gestorfinanceiroapi.domain.response.PageCartoesResponse;
import br.com.lucas.gestorfinanceiroapi.exception.NoContentCustom;
import br.com.lucas.gestorfinanceiroapi.exception.NotFoundCustom;
import br.com.lucas.gestorfinanceiroapi.repository.CartaoRepository;
import br.com.lucas.gestorfinanceiroapi.repository.ContaRepository;

@RunWith(MockitoJUnitRunner.class)
public class CartaoServiceTest {

	@InjectMocks
	private CartaoService cartaoService;

	@Mock
	private CartaoRepository cartaoRepository;
	
	@Mock
	private ContaRepository contaRepository;
	
	Optional<Cartao> mockOptCartao;
	Optional<Conta> mockOptConta;
	
	Cartao mockCartao;
	
	Pageable mockPageable;
	Page<Cartao> mockPageResponseCartoes;
	
	List<Cartao> listaCartoes;
	CartaoSalvarRequest mockCartaoSalvar;
	
	Integer tamanhoPagina = 50;
	Integer pagina = 0;

	@Before
	public void init() {
		mockCartaoSalvar = CartaoSalvarRequest.builder().idConta(10L).build();
		mockPageable = PageRequest.of(pagina, tamanhoPagina);
		mockCartao = Cartao.builder().id(10L).build();
		mockOptCartao = Optional.of(mockCartao);
		mockOptConta = Optional.of(Conta.builder().id(10L).build());

		listaCartoes = new ArrayList<Cartao>();
		listaCartoes.add(Cartao.builder().build());
		mockPageResponseCartoes = new PageImpl<Cartao>(listaCartoes, mockPageable, 1L);

	}

	@Test
	public void deveListarCartoesComSucesso() {
		when(cartaoRepository.findAll(mockPageable)).thenReturn(mockPageResponseCartoes);

		PageCartoesResponse response = cartaoService.listarCartoes(pagina, tamanhoPagina);

		assertNotNull(response);
		
	}
	
	
	@Test
	public void deveRetornarNoContentCustomNaoFoiEncontradoCartoes() {
		when(cartaoRepository.findAll(mockPageable)).thenReturn(null);

		try {
			cartaoService.listarCartoes(pagina, tamanhoPagina);
			Assert.fail();
		} catch (NoContentCustom e) {
			assertEquals("Registros não encontrados", e.getMessage());
			assertEquals(HttpStatus.NO_CONTENT, e.getStatus());
		}
	}
	
	@Test
	public void deveRetornarCartaoPorIdComSucesso() {
		when(cartaoRepository.findById(Mockito.anyLong())).thenReturn(mockOptCartao);
		
		ResponseEntity<CartaoResponse> response = cartaoService.buscarCartaoPorId(Mockito.anyLong());
		
		assertNotNull(response);
		assertNotNull(response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void deveRetornarNotFoundCustomPoisCartaoNaoFoiEncontrado() {
		mockOptCartao = Optional.empty();
		when(cartaoRepository.findById(Mockito.anyLong())).thenReturn(mockOptCartao);
		
		try {
			cartaoService.buscarCartaoPorId(Mockito.anyLong());
			Assert.fail();
		} catch (NotFoundCustom e) {
			assertEquals("Cartão não encontrado", e.getMessage());
			assertEquals(HttpStatus.NOT_FOUND, e.getStatus());
		}
	}
	
	@Test
	public void deveSalvarCartaoComSucesso() {
		when(contaRepository.findById(mockCartaoSalvar.getIdConta())).thenReturn(mockOptConta);
		when(cartaoRepository.save(mockCartao)).thenReturn(mockCartao);
		
		ResponseEntity<CartaoResponse> response = cartaoService.salvarCartao(mockCartaoSalvar);
		
		assertNotNull(response);
		assertNotNull(response.getBody());
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		
		
	}
}
