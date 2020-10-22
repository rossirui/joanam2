package br.ufrpe.joanam2.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.ufrpe.joanam2.model.dao.UsuarioDao;
import br.ufrpe.joanam2.model.entity.Usuario;

@ViewScoped
@ManagedBean(name = "usuarioBean")
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();
	private UsuarioDao dao = new UsuarioDao();
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioDao getDao() {
		return dao;
	}

	public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}
	
	public String salvar() {
		dao.salvar(usuario);
		usuario = new Usuario();
		return "";
	}
		
	public String logar() {
		if(dao.validar(usuario)) {
			return "renda_fixa";
		}
		return "";
	}

}
