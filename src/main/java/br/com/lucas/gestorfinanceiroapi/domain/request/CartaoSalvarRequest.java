package br.com.lucas.gestorfinanceiroapi.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.lucas.gestorfinanceiroapi.enums.BandeiraEnum;
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
@ApiModel(value = "CategoriaSalvarRequest", description = "CategoriaSalvarRequest")
public class CartaoSalvarRequest implements Serializable {
	private static final long serialVersionUID = 2940923548708214833L;

	@Size(max = 100, message = "quantidade de caracteres deve ser menor que 100")
	@NotNull(message = "não pode ser null")
	@ApiModelProperty(value = "Descrição do cartão", example = "Cartão Santander", position = 1)
	private String descricao;
	
	@NotNull(message = "não pode ser null")
	@ApiModelProperty(value = "Limite do cartão", example = "3000.00", position = 2)
	private BigDecimal limite;
	
	@NotNull(message = "não pode ser null")
	@ApiModelProperty(value = "Bandeira do cartão", example="VISA", position = 3)
	@Enumerated(EnumType.STRING)
	private BandeiraEnum bandeira;
	
	@NotNull(message = "não pode ser null")
	@ApiModelProperty(value = "Dia de fechamento do cartão", example="10", position = 4)
	private Integer diaFechamento;
	
	@NotNull(message = "não pode ser null")
	@ApiModelProperty(value = "Dia de pagamento do cartão", example="15", position = 5)
	private Integer diaPagamento;
	
	@NotNull(message = "não pode ser null")
	@ApiModelProperty(value = "Id da conta do cartão", example="1", position = 6)
	private Long idConta;
}
