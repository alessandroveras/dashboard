package br.edu.infnet.dashboard.model.exceptions;

public class QuantidadeAcompanhamentoNegativaException extends Exception {

	private static final long serialVersionUID = 1L;

	public QuantidadeAcompanhamentoNegativaException(String mensagem) {
		super(mensagem);
	}
}