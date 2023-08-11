package br.com.dominio.conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {

	public static void criarConexao() throws SQLException {
		Connection conexao = GerarConexaoBanco.getConexao();

		Statement stmt = conexao.createStatement();
		stmt.execute("CREATE DATABASE IF NOT EXISTS projeto_CRUD ");

		System.out.println("criado");
		conexao.close();
	}

}
