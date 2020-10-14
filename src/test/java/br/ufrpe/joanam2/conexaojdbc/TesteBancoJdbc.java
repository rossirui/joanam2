package br.ufrpe.joanam2.conexaojdbc;

import org.junit.Test;

public class TesteBancoJdbc {

	@Test
	public void iniciarBanco() {
		SingletonConexao.getConexao();
	}
}
