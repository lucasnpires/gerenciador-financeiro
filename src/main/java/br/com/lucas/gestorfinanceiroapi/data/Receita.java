package br.com.lucas.gestorfinanceiroapi.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.lucas.gestorfinanceiroapi.enums.StatusEnum;
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
public class Receita implements Serializable {
	private static final long serialVersionUID = -3761375038850612729L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String descricao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Conta contaReceita;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Categoria categoriaReceita;
	
	private LocalDate dataReceita;
	
	private Boolean estaPago;
	
	private BigDecimal total;
	
	@Enumerated
	private StatusEnum statusEnum;

}
