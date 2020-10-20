package br.ufrpe.joanam2.business.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.ufrpe.joanam2.business.model.Investimento;
import br.ufrpe.joanam2.jpautil.JpaUtil;

public class InvestimentoDao {

	public Investimento salvar(Investimento investimento) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
			
		if(investimento.getId() == null) {
			entityManager.persist(investimento);
		} else {
			investimento = entityManager.merge(investimento);
		}
		
		entityTransaction.commit();
		entityManager.close();
		
		return investimento;
	}
	
	public Investimento buscarPorId(Investimento investimento) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		investimento = entityManager.find(Investimento.class, investimento.getId());
		
		entityTransaction.commit();
		entityManager.close();
		
		return investimento;
	}

	public Investimento excluir(Investimento investimento) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		investimento = buscarPorId(investimento);
		entityManager.remove(investimento);
		
		entityTransaction.commit();
		entityManager.close();
		
		return investimento;
	}

	public List<Investimento> buscar() {
		String sql = "SELECT * FROM investimento";
		
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		List<Investimento> lista = (List<Investimento>)entityManager.createQuery(sql);
		
		entityTransaction.commit();
		entityManager.close();
		
		return lista;
	}


}
