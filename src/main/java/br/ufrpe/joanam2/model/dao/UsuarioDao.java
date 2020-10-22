package br.ufrpe.joanam2.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.ufrpe.joanam2.jpautil.JpaUtil;
import br.ufrpe.joanam2.model.entity.Usuario;

public class UsuarioDao {
	
	public Usuario salvar(Usuario usuario) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
			
		if(usuario.getId() == null) {
			entityManager.persist(usuario);
		} else {
			usuario = entityManager.merge(usuario);
		}
		
		entityTransaction.commit();
		entityManager.close();
		
		return usuario;
	}
	
	public Usuario buscarPorId(Usuario usuario) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		usuario = entityManager.find(Usuario.class, usuario.getId());
		
		entityTransaction.commit();
		entityManager.close();
		
		return usuario;
	}

	public Usuario excluir(Usuario usuario) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		usuario = buscarPorId(usuario);
		entityManager.remove(usuario);
		
		entityTransaction.commit();
		entityManager.close();
		
		return usuario;
	}

	public List<Usuario> buscar() {
		String sql = "SELECT i FROM Usuario i";
		
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		List<Usuario> lista = entityManager.createQuery(sql).getResultList();
		
		entityTransaction.commit();
		entityManager.close();
		
		return lista;
	}

	public boolean validar(Usuario usuario) {
		
		return true;
	}
}
