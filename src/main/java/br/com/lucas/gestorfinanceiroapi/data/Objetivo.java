package br.com.lucas.gestorfinanceiroapi.data;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.lucas.gestorfinanceiroapi.enums.CorEnum;
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
public class Objetivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private BigDecimal valorObjetivo;
	
	private BigDecimal valorInicial;
	
	@Enumerated
	private CorEnum corObjetivo;
	
	private String descricao;
	
	@Enumerated
	private StatusEnum status;

}
