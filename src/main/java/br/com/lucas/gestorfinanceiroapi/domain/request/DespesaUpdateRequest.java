package br.com.lucas.gestorfinanceiroapi.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(value=Include.NON_NULL)
@ApiModel(value="Objeto de atualização da despesa")
public class DespesaUpdateRequest implements Serializable{
	private static final long serialVersionUID = -2703265774427681662L;
	
	@Size(max = 100, message = "quantidade de caracteres deve ser menor que 100")
	@ApiModelProperty(value = "Descrição da conta", position = 1)
	private String descricao;
	
	@ApiModelProperty(value = "Identificador da conta", example = "1", position = 2)
	private Long idConta;

	@ApiModelProperty(value = "Identificador da categoria da despesa", example = "2", position = 3)
	private Long idCategoria;

    @ApiModelProperty(value = "Data da despesa", example = "2019-04-13", position = 4)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataDespesa;

    @ApiModelProperty(value = "Valor total da despesa", example = "20.10", position = 5)
	private BigDecimal total;
	
	

}
