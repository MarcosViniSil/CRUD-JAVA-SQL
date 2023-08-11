package br.com.dominio.exceccao;

@SuppressWarnings("serial")
public class MarcaInvalidaException extends RuntimeException {

	private String marca;

	public MarcaInvalidaException(String marca) {
		this.marca = marca;
	}

	@Override
	public String getMessage() {
		return String.format("A marca %s e invalida", this.marca);
	}
}
