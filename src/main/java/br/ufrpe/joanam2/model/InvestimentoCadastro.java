package br.ufrpe.joanam2.model;

import java.util.List;

import br.ufrpe.joanam2.model.dao.InvestimentoDao;
import br.ufrpe.joanam2.model.entity.Investimento;

public class InvestimentoCadastro {

	private static InvestimentoCadastro uniqueInstance;
	private InvestimentoDao investimentoDao;

	private InvestimentoCadastro() {
		investimentoDao = new InvestimentoDao();
	}

	public static synchronized InvestimentoCadastro getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new InvestimentoCadastro();
		return uniqueInstance;
	}

	public Investimento salvar(Investimento investimento) {
		return investimentoDao.salvar(investimento);
	}

	public String exportarCSV(  ) {

	// UsuarioCadastro.get
		
	return "";
	}

	public List<Investimento> buscar() {
		return investimentoDao.buscar();
	}

	public Investimento excluir(Investimento investimento) {
		return investimentoDao.excluir(investimento);
		
	}

}
