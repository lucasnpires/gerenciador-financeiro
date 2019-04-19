package br.com.lucas.gestorfinanceiroapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucas.gestorfinanceiroapi.data.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {

}
