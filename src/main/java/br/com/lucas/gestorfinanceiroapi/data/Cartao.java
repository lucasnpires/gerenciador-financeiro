package br.com.lucas.gestorfinanceiroapi.data;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.lucas.gestorfinanceiroapi.enums.BandeiraEnum;
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
public class Cartao implements Serializable {
	private static final long serialVersionUID = -9064115717740360716L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String descricao;
	
	private BigDecimal limite;
	
	@Enumerated
	private BandeiraEnum bandeira;
	
	private Integer dataFechamento;
	
	private Integer diaPagamento;
	
	@OneToOne
	private Conta conta;
	

}
