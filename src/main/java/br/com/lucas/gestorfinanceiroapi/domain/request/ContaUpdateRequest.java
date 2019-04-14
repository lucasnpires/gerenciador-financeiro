package br.com.lucas.gestorfinanceiroapi.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.lucas.gestorfinanceiroapi.enums.StatusSaldoInicialEnum;
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
@ApiModel(value="Objeto de atualização da conta")
public class ContaUpdateRequest implements Serializable{
	private static final long serialVersionUID = -4900675177854392486L;
	
	@Size(max = 80, message = "quantidade de caracteres deve ser menor que 80")
	@ApiModelProperty(value = "Nome da conta", example = "Conta Bradesco", position = 1)
	private String nome;

	@Enumerated(EnumType.STRING)
	@ApiModelProperty(value = "Saldo inicial", example= "SIM", position = 2)
	private StatusSaldoInicialEnum statusSaldoInicial;

	@ApiModelProperty(value = "Saldo inicial da conta", example = "20.10", position = 3)
	private BigDecimal saldoInicial;
	

}
