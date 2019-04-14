package br.com.lucas.gestorfinanceiroapi.domain.response;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
@ApiModel(value = "CategoriaResponse", description = "CategoriaResponse")
public class CategoriaDespesaResponse implements Serializable {
	private static final long serialVersionUID = 6299350954910094401L;
	
	@ApiModelProperty(value = "id categoria", position = 1)
	private Long id;
	
	@ApiModelProperty(value = "Descrição da categoria", position = 2)
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	@ApiModelProperty(value = "Tipo de categoria", position = 3)
	private TipoCategoriaEnum tipoCategoria;
	
	

}
