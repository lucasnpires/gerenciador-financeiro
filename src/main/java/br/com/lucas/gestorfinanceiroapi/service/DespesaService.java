package br.com.lucas.gestorfinanceiroapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucas.gestorfinanceiroapi.data.Despesa;
import br.com.lucas.gestorfinanceiroapi.repository.DespesaRepository;

@Service
public class DespesaService {
	
	@Autowired
	private DespesaRepository despesasRepository;

	public List<Despesa> listarDespesas() {
		return despesasRepository.findAll();
	}

}
