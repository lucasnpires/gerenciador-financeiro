package br.com.lucas.gestorfinanceiroapi.domain.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Enumerated;

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
@ApiModel(value = "DespesaCartaoResponse", description = "DespesaCartaoResponse")
public class DespesaCartaoResponse implements Serializable{
	private static final long serialVersionUID = 2354694211639033192L;

	@ApiModelProperty(value = "Id da Despesa do Cartão", position = 1)
	private Long id;
	
	@ApiModelProperty(value = "Descrição da Despesa do Cartão", position = 2)
	private String descricao;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = ISO.DATE)
	@ApiModelProperty(value = "Data da despesa", position = 5)
	private LocalDate dataDespesa;

	@ApiModelProperty(value = "Conta da Despesa do Cartão", position = 3)
	private Conta contaDespesa;

	@ApiModelProperty(value = "Categoria da Despesa do Cartão", position = 4)
	private Categoria categoriaDespesa;
	
	@Enumerated
	@ApiModelProperty(value = "Em qual fatura cairá está despesa", position = 5)
	private FaturaEnum fatura;
	
	@ApiModelProperty(value = "Identificador se foi uma compra parcelada ou não", position = 6)
	private Boolean parcelado;
	
	@ApiModelProperty(value = "Quantidade de parcelas da compra", position = 7)
	private Integer qtdParcelas;
	
	@ApiModelProperty(value = "Valor total da Despesa do cartão", position = 8)
	private BigDecimal total;

	

}
