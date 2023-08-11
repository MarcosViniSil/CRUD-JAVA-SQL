package br.com.dominio.conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TabelaProduto {
  
	public static void criarTabelaProduto() throws SQLException {
		CriarBanco.criarConexao();
		Connection conexao = GerarConexaoBanco.getConexao();
		
		String sql ="CREATE TABLE IF NOT EXISTS produto("
				+ "codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ "nome VARCHAR(80) NOT NULL,"
				+ "preco DOUBLE NOT NULL,"
				+ "marca VARCHAR(80) NOT NULL"
				+ ")";
		
        Statement stmt = conexao.createStatement();
        stmt.execute(sql);
        
        System.out.println("criado com sucesso");
        conexao.close();
	}
}
