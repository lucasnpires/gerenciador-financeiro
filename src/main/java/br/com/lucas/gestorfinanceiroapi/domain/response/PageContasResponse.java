package br.com.lucas.gestorfinanceiroapi.domain.response;

import java.io.Serializable;

public class PageContasResponse extends PageResponse<ContaResponse> implements Serializable {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageContasResponse(PageResponse p) {
		super(p.getNumber(), p.size, p.getTotalPages(), p.numberOfElements, p.totalElements, p.hasContent, p.first,
				p.last, p.nextPage, p.previousPage, p.content);
	}

}
