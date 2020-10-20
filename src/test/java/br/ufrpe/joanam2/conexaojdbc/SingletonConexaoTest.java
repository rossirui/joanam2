package br.ufrpe.joanam2.conexaojdbc;

import org.junit.Test;

import br.ufrpe.joanam2.business.conexaojdbc.SingletonConexao;

public class SingletonConexaoTest {

	@Test
	public void conectarTest() {
		SingletonConexao.getConexao();
	}
}
