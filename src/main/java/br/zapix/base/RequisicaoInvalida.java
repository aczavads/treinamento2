package br.zapix.base;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RequisicaoInvalida extends RuntimeException {
	private static final long serialVersionUID = -4236347265767776295L;

	public RequisicaoInvalida(String message) {
		super(message);
	}
	
}
