package br.ufrpe.joanam2.business.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.ufrpe.joanam2.jpautil.JpaUtil;

public class GenericoDao<E> {

	public void salvar(E entidade) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.persist(entidade);

		entityTransaction.commit();
		entityManager.close();
	}
	
	public E atualizar(E entidade) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		E retorno = entityManager.merge(entidade);

		entityTransaction.commit();
		entityManager.close();
		
		return retorno;
	}

}
