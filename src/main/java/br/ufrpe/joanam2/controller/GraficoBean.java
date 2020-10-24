package br.ufrpe.joanam2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

import br.ufrpe.joanam2.model.InvestimentoCadastro;
import br.ufrpe.joanam2.model.dto.InvestimentoDTO;

@ViewScoped
@ManagedBean(name = "graficoBean")
public class GraficoBean {

	private PieChartModel pieModel1;

	private List<InvestimentoDTO> investimentosDTO = new ArrayList<>();

	private InvestimentoCadastro getCadastro() {
		return InvestimentoCadastro.getInstance();
	}

	public List<InvestimentoDTO> getInvestimentosDTO() {
		return investimentosDTO;
	}

	public void setInvestimentosDTO(List<InvestimentoDTO> investimentosDTO) {
		this.investimentosDTO = investimentosDTO;
	}

	public String voltar() {
		return "renda_fixa";
	}

	@PostConstruct
	public void init() {
		createPieModels();
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	private void createPieModels() {
		createPieModel1();
	}

	public void listarPorTipo() {
		investimentosDTO = getCadastro().buscarPorTipo();
	}

	private void createPieModel1() {
		listarPorTipo();
		pieModel1 = new PieChartModel();

		for (InvestimentoDTO dto : investimentosDTO) {
			
			String item = "Pós-fixado";
			if(dto.getTipo() == 1) {
				item = "Prefixado";
			}
			
			int valor = (int)dto.getTotal();
			pieModel1.set(item, valor);
			
		}

		pieModel1.setTitle("Investimentos");
		pieModel1.setLegendPosition("w");
	}

}
