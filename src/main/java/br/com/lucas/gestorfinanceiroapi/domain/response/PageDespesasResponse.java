package br.com.lucas.gestorfinanceiroapi.domain.response;

import java.io.Serializable;

import br.com.lucas.gestorfinanceiroapi.data.Despesa;

public class PageDespesasResponse extends PageResponse<Despesa> implements Serializable {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	PageDespesasResponse(PageResponse p) {
		super(p.getNumber(), p.size, p.getTotalPages(), p.numberOfElements, p.totalElements, p.hasContent, p.first,
				p.last, p.nextPage, p.previousPage, p.content);
	}

}
