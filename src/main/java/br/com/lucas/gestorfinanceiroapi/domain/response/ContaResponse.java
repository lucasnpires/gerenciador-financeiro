package br.com.lucas.gestorfinanceiroapi.domain.response;

import java.math.BigDecimal;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.lucas.gestorfinanceiroapi.enums.StatusSaldoInicialEnum;
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
@ApiModel(value = "ContaResponse", description = "ContaResponse")
public class ContaResponse {
	
	@ApiModelProperty(value = "Id da conta", position = 1)
	private Long id;

	@ApiModelProperty(value = "Nome da conta", position = 2)
	private String nome;

	@Enumerated(EnumType.STRING)
	@ApiModelProperty(value = "Status saldo inicial da conta", position = 3)
	private StatusSaldoInicialEnum statusSaldoInicial;

	@ApiModelProperty(value = "Saldo inicial da conta", position = 4)
	private BigDecimal saldoInicial;

}
