package br.com.lucas.gestorfinanceiroapi.domain.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.lucas.gestorfinanceiroapi.data.Categoria;
import br.com.lucas.gestorfinanceiroapi.data.Conta;
import br.com.lucas.gestorfinanceiroapi.enums.StatusEnum;
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
@ApiModel(value = "ReceitaResponse", description = "ReceitaResponse")
public class ReceitaResponse implements Serializable{
	private static final long serialVersionUID = 6428359854555075666L;
	
	@ApiModelProperty(value = "Identificador da Receita", position = 1)
	private Long id;
	
	@ApiModelProperty(value = "Descrição da Receita", position = 2)
	private String descricao;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = ISO.DATE)
	@ApiModelProperty(value = "Data da receita", position = 3)
	private LocalDate dataReceita;

	@ApiModelProperty(value = "Identificador se a Receita está paga ou não", position = 4)
	private Boolean estaPago;
	
	@ApiModelProperty(value = "Valor total da Receita", position = 5)
	private BigDecimal total;
	
	@ApiModelProperty(value = "Status da Receita", position = 6)
	private StatusEnum statusEnum;

	@ApiModelProperty(value = "Identificador da Conta", position = 7)
	private Conta contaReceita;
	
	@ApiModelProperty(value = "Identificador da Categoria", position = 8)
	private Categoria categoriaReceita;
	
	
}
