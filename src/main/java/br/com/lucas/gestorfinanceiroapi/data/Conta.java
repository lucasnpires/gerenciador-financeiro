package br.com.lucas.gestorfinanceiroapi.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.lucas.gestorfinanceiroapi.enums.StatusSaldoInicialEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Conta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;

	@Enumerated
	private StatusSaldoInicialEnum statusSaldoInicial;

	private BigDecimal saldoInicial;
	
	@JsonIgnore
	@OneToMany(mappedBy = "contaDespesa", cascade = {CascadeType.PERSIST})
    private List<Despesa> despesas;
	
	@JsonIgnore
	@OneToMany(mappedBy = "contaReceita", cascade = {CascadeType.PERSIST})
    private List<Receita> receitas;

}
