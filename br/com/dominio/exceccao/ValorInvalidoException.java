package br.com.dominio.exceccao;

@SuppressWarnings("serial")
public class ValorInvalidoException extends RuntimeException {

	private double quantidade;

	public ValorInvalidoException(double quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String getMessage() {
		return String.format("O valor %f e invalido", this.quantidade);
	}

}
