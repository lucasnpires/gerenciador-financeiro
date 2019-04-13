package br.com.lucas.gestorfinanceiroapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lucas.gestorfinanceiroapi.data.Despesa;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

}
