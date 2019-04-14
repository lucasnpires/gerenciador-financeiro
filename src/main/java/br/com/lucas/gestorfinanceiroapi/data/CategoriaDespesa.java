package br.com.lucas.gestorfinanceiroapi.data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import br.com.lucas.gestorfinanceiroapi.enums.TipoCategoriaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoriaDespesa implements Serializable {
	private static final long serialVersionUID = 8703126403945423249L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String descricao;
	
	@Enumerated
	private TipoCategoriaEnum tipoCategoria;
	
	@OneToMany(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	private List<Despesa> despesaList;

}
