package br.com.lucas.gestorfinanceiroapi.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.lucas.gestorfinanceiroapi.enums.BandeiraEnum;
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
@ApiModel(value = "CartaoUpdateRequest", description = "CartaoUpdateRequest")
public class CartaoUpdateRequest implements Serializable {
	private static final long serialVersionUID = -5157346104570220229L;

	@Size(max = 100, message = "quantidade de caracteres deve ser menor que 100")
	@ApiModelProperty(value = "Descrição do cartão", example = "Cartão Santander", position = 1)
	private String descricao;
	
	@ApiModelProperty(value = "Limite do cartão", example = "3000.00", position = 2)
	private BigDecimal limite;
	
	@ApiModelProperty(value = "Bandeira do cartão", example="VISA", position = 3)
	@Enumerated(EnumType.STRING)
	private BandeiraEnum bandeira;
	
	@ApiModelProperty(value = "Dia de fechamento do cartão", example="10", position = 4)
	private Integer diaFechamento;
	
	@ApiModelProperty(value = "Dia de pagamento do cartão", example="15", position = 5)
	private Integer diaPagamento;
	
	@ApiModelProperty(value = "Id da conta do cartão", example="1", position = 6)
	private Long idConta;

}
