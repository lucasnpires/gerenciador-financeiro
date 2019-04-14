package br.com.lucas.gestorfinanceiroapi.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
@ApiModel(value = "ContaSalvarRequest", description = "ContaSalvarRequest")
public class ContaSalvarRequest implements Serializable {
	private static final long serialVersionUID = -568849448946646055L;

	@Size(max = 80, message = "quantidade de caracteres deve ser menor que 80")
	@NotNull(message = "não pode ser null")
	@ApiModelProperty(value = "Nome da conta", example = "Conta Bradesco", position = 1)
	private String nome;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "não pode ser null")
	@ApiModelProperty(value = "Saldo inicial", example= "SIM", position = 2)
	private StatusSaldoInicialEnum statusSaldoInicial;

	@ApiModelProperty(value = "Saldo inicial da conta", example = "20.10", position = 3)
	private BigDecimal saldoInicial;

}
