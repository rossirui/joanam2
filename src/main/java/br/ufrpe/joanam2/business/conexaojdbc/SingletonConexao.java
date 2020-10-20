package br.ufrpe.joanam2.business.conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConexao {

	
	private static String url = "jdbc:postgresql://localhost:5432/renda_fixa";
	private static String password = "postgres";
	private static String user = "postgres";
	private static Connection conexao = null;
	
	static {
		conectar();
	}
	
	public SingletonConexao() {
		conectar();
	}
	
	private static void conectar() {
		try {
			if(conexao == null) {
				System.out.println("E aí, conectou?");
				Class.forName("org.postgresql.Driver");
				conexao = DriverManager.getConnection(url, user, password);
				conexao.setAutoCommit(false);
				System.out.println("Conectou com sucesso!");
			}
		} catch (Exception e) {
			System.out.println("Deu erro de conexão");
			e.getStackTrace();
		}
	}
	
	public static Connection getConexao() {
		return conexao;
	}
}
