package br.ufrpe.joanam2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.ufrpe.joanam2.model.InvestimentoCadastro;
import br.ufrpe.joanam2.model.dao.InvestimentoDao;
import br.ufrpe.joanam2.model.entity.Investimento;

@ViewScoped
@ManagedBean(name="investimentoBean")
public class InvestimentoBean {
	
	private Investimento investimento = new Investimento();
	private List<Investimento> investimentos = new ArrayList<Investimento>();
	
	private InvestimentoCadastro getCadastro() {
		return InvestimentoCadastro.getInstance();
	}
		
	public Investimento getInvestimento() {
		return investimento;
	}

	public void setInvestimento(Investimento investimento) {
		this.investimento = investimento;
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
		investimento = getCadastro().salvar(investimento);
		listarInvestimentos();
		return "";
	}

	public String excluir() {
		getCadastro().excluir(investimento);
		investimento = new Investimento();
		listarInvestimentos();
		return "";
	}
	
	@PostConstruct
	public void listarInvestimentos() {
		investimentos = getCadastro().buscar();
	}
	
	public String relatorio() {
		return "relatorio";
	}

	public String exportarCSV() {
		getCadastro().exportarCSV();
		return "";
	}

}
