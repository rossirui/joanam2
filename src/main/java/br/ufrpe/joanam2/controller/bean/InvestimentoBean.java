package br.ufrpe.joanam2.controller.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.ufrpe.joanam2.business.dao.InvestimentoDao;
import br.ufrpe.joanam2.business.model.Investimento;

@ViewScoped
@ManagedBean(name="investimentoBean")
public class InvestimentoBean {
	
	private Investimento investimento = new Investimento();
	private InvestimentoDao dao = new InvestimentoDao();
	private List<Investimento> investimentos = new ArrayList<Investimento>();
		
	public Investimento getInvestimento() {
		return investimento;
	}

	public void setInvestimento(Investimento investimento) {
		this.investimento = investimento;
	}

	public InvestimentoDao getDao() {
		return dao;
	}

	public void setDao(InvestimentoDao dao) {
		this.dao = dao;
	}

	public List<Investimento> getInvestimentos() {
		return investimentos;
	}
	
	public void setInvestimentos(List<Investimento> investimentos) {
		this.investimentos = investimentos;
	}
	
	public String novo() {
		investimento = new Investimento();
		return "";
	}
	
	public String salvar() {
		dao.salvar(investimento);
		listarInvestimentos();
		return "";
	}
	
	public String atualizar() {
		investimento = dao.salvar(investimento);
		return "";
	}

	public String excluir() {
		dao.excluir(investimento);
		investimento = new Investimento();
		listarInvestimentos();
		return "";
	}
	
	@PostConstruct
	public void listarInvestimentos() {
		investimentos = dao.buscar();
	}

}
