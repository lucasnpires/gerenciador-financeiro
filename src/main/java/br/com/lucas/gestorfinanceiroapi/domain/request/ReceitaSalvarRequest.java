package br.com.lucas.gestorfinanceiroapi.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@ApiModel(value = "ReceitaSalvarRequest", description = "ReceitaSalvarRequest")
public class ReceitaSalvarRequest implements Serializable {
	private static final long serialVersionUID = 4418237925512496364L;
	
	@Size(max = 100, message = "quantidade de caracteres deve ser menor que 100")
	@NotNull(message = "não pode ser null")
	@ApiModelProperty(value = "Descrição da Receita", example = "Recebimento Salário Empresa X", position = 1)
	private String descricao;

	@NotNull(message = "não pode ser null")
	@ApiModelProperty(value = "Identificador da Conta", example = "1", position = 2)
	private Long idContaReceita;
	
	@NotNull(message = "não pode ser null")
	@ApiModelProperty(value = "Identificador da Categoria", example = "2", position = 3)
	private Long idCategoriaReceita;
	
	@NotNull(message = "não pode ser null")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = ISO.DATE)
	@ApiModelProperty(value = "Data da receita", example = "2019-04-20", position = 4)
	private LocalDate dataReceita;
	
	@NotNull(message = "não pode ser null")
	@ApiModelProperty(value = "Identificador se a Receita está paga ou não", example = "true", position = 5)
	private Boolean estaPago;
	
	@NotNull(message = "não pode ser null")
	@ApiModelProperty(value = "Valor total da Receita", example = "4000.00", position = 6)
	private BigDecimal total;
	
	@Enumerated
	@NotNull(message = "não pode ser null")
	@ApiModelProperty(value = "Status da Receita", example = "ATIVO", position = 7)
	private StatusEnum statusEnum;

}
