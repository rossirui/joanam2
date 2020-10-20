package br.ufrpe.joanam2.controller.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.ufrpe.joanam2.business.dao.GenericoDao;
import br.ufrpe.joanam2.business.model.Usuario;

@ViewScoped
@ManagedBean(name = "usuarioBean")
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();
	private GenericoDao<Usuario> dao = new GenericoDao<Usuario>();
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public GenericoDao<Usuario> getGenericoDao() {
		return dao;
	}

	public void setGenericoDao(GenericoDao<Usuario> genericoDao) {
		this.dao = genericoDao;
	}

	public String salvar() {
		dao.salvar(usuario);
		usuario = new Usuario();
		return "";
	}
	
	public String atualizar() {
		usuario = dao.atualizar(usuario);
		return "";
	}

}
