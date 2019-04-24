package br.com.lucas.gestorfinanceiroapi.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.lucas.gestorfinanceiroapi.data.Categoria;
import br.com.lucas.gestorfinanceiroapi.data.Conta;
import br.com.lucas.gestorfinanceiroapi.enums.FaturaEnum;
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
@ApiModel(value = "DespesaCartaoSalvarRequest", description = "DespesaCartaoSalvarRequest")
public class DespesaCartaoSalvarRequest implements Serializable{
	private static final long serialVersionUID = 4018630716857904746L;
	
	@Size(max = 100, message = "quantidade de caracteres deve ser menor que 100")
	@NotNull(message = "não pode ser null")
	@ApiModelProperty(value = "Descrição da Despesa do Cartão", example="Compra móveis da sala de estar", position = 1)
	private String descricao;

	@NotNull(message = "não pode ser null")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = ISO.DATE)
	@ApiModelProperty(value = "Data da despesa", example="2019-04-23",  position = 2)
	private LocalDate dataDespesa;

	@NotNull(message = "não pode ser null")
	@ApiModelProperty(value = "Identificador da Conta da Despesa do Cartão", position = 3)
	private Long idContaDespesa;

	@NotNull(message = "não pode ser null")
	@ApiModelProperty(value = "Identificador da Categoria da Despesa do Cartão", position = 4)
	private Long idCategoriaDespesa;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "não pode ser null")
	@ApiModelProperty(value = "Em qual fatura cairá está despesa", position = 5)
	private FaturaEnum fatura;
	
	@ApiModelProperty(value = "Identificador se foi uma compra parcelada ou não", position = 6)
	private Boolean parcelado;
	
	@ApiModelProperty(value = "Quantidade de parcelas da compra", position = 7)
	private Integer qtdParcelas;
	
	@NotNull(message = "não pode ser null")
	@ApiModelProperty(value = "Valor total da Despesa do cartão", position = 8)
	private BigDecimal total;
}
