package br.com.dominio.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.dominio.conexao.GerarConexaoBanco;
import br.com.dominio.exceccao.MarcaInvalidaException;
import br.com.dominio.exceccao.ProdutoInvalidoException;
import br.com.dominio.exceccao.ValorInvalidoException;
import br.com.dominio.validar.ValidarProduto;

public class OperacoesCRUD {

	private List<Produto> produtos = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);

	public void cadastrar() throws SQLException {

		String nome = "";
		double preco = 0;
		String marca = "";

		try {
			System.out.print("Digite o preco do produto:");
			preco = sc.nextDouble();
			ValidarProduto.validarPreco(preco);
			sc.nextLine();

			System.out.print("digite o nome do produto:");
			nome = sc.nextLine();
			ValidarProduto.validarNome(nome);

			System.out.print("Digite a marca do produto:");
			marca = sc.nextLine();
			ValidarProduto.validarMarca(marca);

		} catch (ProdutoInvalidoException e) {
			System.out.println(e.getMessage());
			nome = "";
			preco = 0;
			marca = "";
			cadastrar();
		} catch (ValorInvalidoException e) {
			System.out.println(e.getMessage());
			nome = "";
			preco = 0;
			marca = "";
			cadastrar();
		} catch (MarcaInvalidaException e) {
			System.out.println(e.getMessage());
			nome = "";
			preco = 0;
			marca = "";
			cadastrar();
		} finally {
			if (nome != "" && preco != 0 && marca != "") {
				Connection conexao = GerarConexaoBanco.getConexao();
				String sql = "INSERT INTO produto (nome,preco,marca) VALUES(?,?,?)";
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setString(1, nome);
				stmt.setDouble(2, preco);
				stmt.setString(3, marca);

				stmt.execute();
				System.out.println("Finalizado");

			}

		}

	}

	private void carregarBanco() throws SQLException {

		Connection conexao = GerarConexaoBanco.getConexao();

		String sql = "SELECT * FROM produto ORDER BY codigo";

		Statement stmt = conexao.createStatement();
		ResultSet resultado = stmt.executeQuery(sql);

		List<Produto> produtos = new ArrayList<>();

		while (resultado.next()) {
			String nome = resultado.getString("nome");
			double preco = resultado.getDouble("preco");
			String marca = resultado.getString("marca");
			int codigo = resultado.getInt("codigo");
			Produto p = new Produto(nome, preco, marca, codigo);
			produtos.add(p);
		}
		for (Produto p : produtos) {
			System.out.println(p.getCodigo() + "->" + p.getNome() + "->" + p.getPreco() + "->" + p.getMarca());
		}

	}

	public void listar() throws SQLException {
		this.carregarBanco();
	}

	public void excluir() throws SQLException {
		this.carregarBanco();
		System.out.println("Digite o codigo do produto que deseja excluir:");
		int codigo = sc.nextInt();

		if (codigo != 0) {
			Connection conexao = GerarConexaoBanco.getConexao();
			String sql = "DELETE produto FROM produto WHERE codigo=(?)";

			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigo);

			stmt.execute();
			System.out.println("Finalizado");
		} else {
			System.out.println("nao e possivel excluir este produto");
		}
	}

	public void editar() throws SQLException {
		this.carregarBanco();
		System.out.println("Digite o codigo do produto que deseja editar:");
		int codigo = sc.nextInt();

		if (codigo != 0) {
			System.out.println("Digite um novo preco:");
			double preco = sc.nextDouble();
			sc.nextLine();

			System.out.println("Digite um novo nome:");
			String nome = sc.nextLine();

			System.out.println("Digite uma nova marca:");
			String marca = sc.nextLine();

			Connection conexao = GerarConexaoBanco.getConexao();
			String sql = "UPDATE produto SET nome=(?),preco=(?),marca=(?) WHERE codigo=(?)";

			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setDouble(2, preco);
			stmt.setString(3, marca);
			stmt.setInt(4, codigo);

			stmt.execute();
			System.out.println("Finalizado");

		} else {
			System.out.println("Este produto nao existe");
		}
	}

}