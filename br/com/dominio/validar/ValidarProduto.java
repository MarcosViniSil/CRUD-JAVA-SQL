package br.com.dominio.validar;

import br.com.dominio.exceccao.MarcaInvalidaException;
import br.com.dominio.exceccao.ProdutoInvalidoException;
import br.com.dominio.exceccao.ValorInvalidoException;

public class ValidarProduto {

	public static void validarNome(String nome) {
		if (nome == null || nome.length() < 5) {
			throw new ProdutoInvalidoException();
		}
	}

	public static void validarPreco(double preco) {
		if (preco == 0) {
			throw new ValorInvalidoException(preco);
		}
	}

	public static void validarMarca(String marca) {
		if (marca == null || marca.length() < 3) {
			throw new MarcaInvalidaException(marca);
		}
	}
}
