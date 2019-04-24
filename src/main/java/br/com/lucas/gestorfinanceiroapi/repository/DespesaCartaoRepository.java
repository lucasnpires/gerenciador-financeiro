package br.com.lucas.gestorfinanceiroapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lucas.gestorfinanceiroapi.data.DespesaCartao;

@Repository
public interface DespesaCartaoRepository extends JpaRepository<DespesaCartao, Long> {

}
