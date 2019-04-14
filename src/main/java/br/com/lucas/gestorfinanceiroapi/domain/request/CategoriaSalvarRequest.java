package br.com.lucas.gestorfinanceiroapi.domain.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.lucas.gestorfinanceiroapi.enums.TipoCategoriaEnum;
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
public class CategoriaSalvarRequest {
	
	@Size(max = 100, message = "quantidade de caracteres deve ser menor que 100")
	@NotNull(message = "não pode ser null")
	@ApiModelProperty(value = "Descrição da categoria", example = "Supermercado", position = 1)
	private String descricao;
	
	@NotNull(message = "não pode ser null")
	@ApiModelProperty(value = "Tipo de categoria", example="DESPESA", position = 2)
	@Enumerated(EnumType.STRING)
	private TipoCategoriaEnum tipoCategoria;

}
