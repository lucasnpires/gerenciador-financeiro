package br.com.lucas.gestorfinanceiroapi.domain.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	@ApiModelProperty(value = "Identificador da conta", position = 2)
	private String descricao;

	@ApiModelProperty(value = "Identificador da conta", position = 3)
	private Long idConta;

	@ApiModelProperty(value = "Identificador da categoria", position = 4)
	private Long idCategoria;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = ISO.DATE)
    @ApiModelProperty(value = "Data da despesa", position = 5)
	private LocalDate dataDespesa;

    @ApiModelProperty(value = "Valor total da despesa", position = 6)
	private BigDecimal total;

}
