package br.com.lucas.gestorfinanceiroapi.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Despesa implements Serializable {
	private static final long serialVersionUID = -8166406585990544021L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany
	private Conta conta;
	
	@OneToMany
	private CategoriaDespesa categoria;
	
	private LocalDate dataDespesa;
	
	private BigDecimal total;

}
