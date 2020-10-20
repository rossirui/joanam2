package br.ufrpe.joanam2;

import javax.persistence.Persistence;

public class TesteJPA {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("joanam2");
	}

}
