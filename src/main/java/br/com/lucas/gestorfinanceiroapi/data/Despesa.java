package br.com.lucas.gestorfinanceiroapi.data;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Despesa {
	
	private Long id;
	
	private String categoria;
	
	private Date dataDespesa;
	
	private BigDecimal total;

}
