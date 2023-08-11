package br.com.dominio.exceccao;

@SuppressWarnings("serial")
public class ProdutoInvalidoException extends RuntimeException {

	@Override
	public String getMessage() {
		return "Produto invalido";
	}
}
