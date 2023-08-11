package br.com.dominio.principal;

import java.sql.SQLException;

import br.com.dominio.crud.Menu;

public class CRUD {

	public static void main(String[] args) throws SQLException {
		Menu menu = new Menu();
		menu.comecar();

	}
}
