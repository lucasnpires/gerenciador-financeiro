package br.com.lucas.gestorfinanceiroapi.domain.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.lucas.gestorfinanceiroapi.enums.TipoCategoriaEnum;
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
@ApiModel(value="Objeto de atualização da categoria")
public class CategoriaUpdateRequest {
	
	@Size(max = 100, message = "quantidade de caracteres deve ser menor que 100")
	@ApiModelProperty(value = "Descrição da categoria", example = "Supermercado", position = 1)
	private String descricao;
	
	@ApiModelProperty(value = "Tipo de categoria", example="DESPESA", position = 2)
	@Enumerated(EnumType.STRING)
	private TipoCategoriaEnum tipoCategoria;

}
