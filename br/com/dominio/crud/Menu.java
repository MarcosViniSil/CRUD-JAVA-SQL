package br.com.dominio.crud;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

	public void comecar() throws SQLException {
		OperacoesCRUD CRUD = new OperacoesCRUD();
		Scanner sc = new Scanner(System.in);
		int opcao = 0;

		do {
			System.out.println("0:SAIR");
			System.out.println("1:CADASTRAR");
			System.out.println("2:ALTERAR");
			System.out.println("3:EXCLUIR");
			System.out.println("4:LISTAR");
			opcao = sc.nextInt();

			switch (opcao) {
			case 0:
				break;
			case 1:
				CRUD.cadastrar();
				break;
			case 2:
				CRUD.editar();
				break;
			case 3:
				CRUD.excluir();
				break;
			case 4:
				CRUD.listar();
				break;
			default:
				System.out.println("opcao invalida");
				break;
			}

		} while (opcao != 0);
	}
}
