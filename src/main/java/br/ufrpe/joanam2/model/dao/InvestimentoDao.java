package br.ufrpe.joanam2.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.ufrpe.joanam2.jpautil.JpaUtil;
import br.ufrpe.joanam2.model.entity.Investimento;

public class InvestimentoDao {

	public Investimento salvar(Investimento investimento) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
			
		investimento = entityManager.merge(investimento);

		/*if(investimento.getId() == null) {
			entityManager.persist(investimento);
		} else {
			investimento = entityManager.merge(investimento);
		}*/
		
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
		
		entityManager.createQuery("delete from Investimento where id = " + investimento.getId())
					 .executeUpdate();
		
		entityTransaction.commit();
		entityManager.close();
		
		return investimento;
	}

	public List<Investimento> buscar() {
		String sql = "SELECT i FROM Investimento i";
		
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		List<Investimento> lista = entityManager.createQuery(sql).getResultList();
		
		entityTransaction.commit();
		entityManager.close();
		
		return lista;
	}


}
