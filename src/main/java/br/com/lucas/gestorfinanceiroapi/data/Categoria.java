package br.com.lucas.gestorfinanceiroapi.data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.lucas.gestorfinanceiroapi.enums.TipoCategoriaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ToString
public class Categoria implements Serializable {
	private static final long serialVersionUID = 8703126403945423249L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String descricao;
	
	@Enumerated
	private TipoCategoriaEnum tipoCategoria;
	
	@JsonIgnore
	@OneToMany(mappedBy = "categoria", cascade = {CascadeType.PERSIST})
    private List<Despesa> despesas;
	
}
