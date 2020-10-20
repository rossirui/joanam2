package br.ufrpe.joanam2.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ufrpe.joanam2.business.conexaojdbc.SingletonConexao;
import br.ufrpe.joanam2.business.model.Usuario;

public class UsuarioDao {
	
	private Connection connection;
	
	public UsuarioDao() {
		connection = SingletonConexao.getConexao();
	}

	public void cadastrar(Usuario usuario) {
		String sql = "INSERT INTO usuario (cpf, senha) VALUES(?, ?);";
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getCpf());
			preparedStatement.setString(2, usuario.getSenha());
			preparedStatement.execute();
			
			connection.commit();
			
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	
}
