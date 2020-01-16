package br.zapix.conta_contabil;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonValue;

@Embeddable
public class CodigoContabil {
	@JsonValue
	private String valor;

	private CodigoContabil() {
	}
	
	public CodigoContabil(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

}
