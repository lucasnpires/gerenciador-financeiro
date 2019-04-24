package br.com.lucas.gestorfinanceiroapi.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
public class DespesaCartao implements Serializable{
	private static final long serialVersionUID = -1078016651146805111L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String descricao;
	
	private LocalDate dataDespesa;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Categoria categoriaDespesaCartao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Cartao cartaoDespesa;
	
	private String fatura;
	
	private Boolean parcelado;
	
	private Integer qtdParcelas;
	
	private BigDecimal total;

}
