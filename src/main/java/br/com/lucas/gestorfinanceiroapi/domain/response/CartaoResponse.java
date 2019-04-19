package br.com.lucas.gestorfinanceiroapi.domain.response;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.lucas.gestorfinanceiroapi.data.Conta;
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
@ApiModel(value = "CartaoResponse", description = "CartaoResponse")
public class CartaoResponse implements Serializable {
	private static final long serialVersionUID = 860050973428581229L;

	@ApiModelProperty(value = "Id do cartão", position = 1)
	private Long id;
	
	@ApiModelProperty(value = "descrição do cartão", position = 2)
	private String descricao;
	
	@ApiModelProperty(value = "limite do cartão", position = 3)
	private BigDecimal limite;
	
	@Enumerated(EnumType.STRING)
	@ApiModelProperty(value = "Status saldo inicial da conta", position = 4)
	private BandeiraEnum bandeira;
	
	@ApiModelProperty(value = "Dia de fechamento do cartão", position = 5)
	private Integer diaFechamento;
	
	@ApiModelProperty(value = "Dia de pagamento do cartão", position = 6)
	private Integer diaPagamento;
	
	@ApiModelProperty(value = "Dados da conta do cartão", position = 7)
	private Conta conta;
}
