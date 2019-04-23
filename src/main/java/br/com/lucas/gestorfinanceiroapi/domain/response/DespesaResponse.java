package br.com.lucas.gestorfinanceiroapi.domain.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.lucas.gestorfinanceiroapi.data.Categoria;
import br.com.lucas.gestorfinanceiroapi.data.Conta;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ApiModel(value = "DespesaResponse", description = "DespesaResponse")
public class DespesaResponse implements Serializable{
	private static final long serialVersionUID = -694708603550870601L;
	
	@ApiModelProperty(value = "Identificador da despesa", position = 1)
	private Long id;
	
	@ApiModelProperty(value = "Descrição da conta", position = 2)
	private String descricao;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = ISO.DATE)
	@ApiModelProperty(value = "Data da despesa", position = 3)
	private LocalDate dataDespesa;
	
	@ApiModelProperty(value = "Valor total da despesa", position = 4)
	private BigDecimal total;

	@ApiModelProperty(value = "Identificador da conta", position = 5)
	private Conta conta;

	@ApiModelProperty(value = "Identificador da categoria", position = 6)
	private Categoria categoria;


}
