package br.com.lucas.gestorfinanceiroapi.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
@ApiModel(value = "DespesaSalvarRequest", description = "DespesaSalvarRequest")
public class DespesaSalvarRequest implements Serializable {
	private static final long serialVersionUID = -275315652363839668L;
	
	@Size(max = 100, message = "quantidade de caracteres deve ser menor que 100")
	@NotNull(message = "não pode ser null")
	@ApiModelProperty(value = "Descrição da conta", example = "Conta de Aluguel", position = 1)
	private String descricao;

	@NotNull(message = "não pode ser null")
	@ApiModelProperty(value = "Identificador da conta", example = "1", position = 2)
	private Long idConta;

	@NotNull(message = "não pode ser null")
	@ApiModelProperty(value = "Identificador da categoria da despesa", example = "2", position = 3)
	private Long idCategoria;

	@NotNull(message = "não pode ser null")
    @ApiModelProperty(value = "Data da despesa", example = "2019-04-13", position = 4)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataDespesa;

    @NotNull(message = "não pode ser null")
    @ApiModelProperty(value = "Valor total da despesa", example = "20.10", position = 5)
	private BigDecimal total;

}
