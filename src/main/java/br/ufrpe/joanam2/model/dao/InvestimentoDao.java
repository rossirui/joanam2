package br.ufrpe.joanam2.model.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.ufrpe.joanam2.jpautil.JpaUtil;
import br.ufrpe.joanam2.model.dto.InvestimentoDTO;
import br.ufrpe.joanam2.model.entity.Investimento;

public class InvestimentoDao {

	public Investimento salvar(Investimento investimento) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		investimento = entityManager.merge(investimento);

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

		entityManager.createQuery("delete from Investimento where id = " + investimento.getId()).executeUpdate();

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

	public List<InvestimentoDTO> buscarPorTipo() {
		String sql = "SELECT i.tipo, count(i.tipo) FROM Investimento i GROUP BY tipo";

		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Query nativeQuery = entityManager.createNativeQuery(sql);
		List<Object[]> listaBD = nativeQuery.getResultList();
		
		List<InvestimentoDTO> lista = new ArrayList<InvestimentoDTO>();
		if (listaBD != null) {
			for (Object[] obj : listaBD) {
				InvestimentoDTO dto = new InvestimentoDTO();
				
				dto.setTipo((int) obj[0]);
				BigInteger total = (BigInteger) obj[1];
				dto.setTotal(total.intValue());
				
				lista.add(dto);
			}
		}

		entityTransaction.commit();
		entityManager.close();

		return lista;
	}
}
