package br.com.lucas.gestorfinanceiroapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucas.gestorfinanceiroapi.data.Receita;

public interface ReceitaRepository  extends JpaRepository<Receita, Long> {

}
