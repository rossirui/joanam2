package br.ufrpe.joanam2.model;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import br.ufrpe.joanam2.model.dao.InvestimentoDao;
import br.ufrpe.joanam2.model.dto.InvestimentoDTO;
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
	
	public String exportarCSV() {
		List<Investimento> investimentos = buscar();
		
		try {
			System.out.println("/ -> " + new File(".").getCanonicalPath());
			Writer writer = Files.newBufferedWriter(Paths.get(".\\investimentos.csv"));
			StatefulBeanToCsv<Investimento> beanToCsv = new StatefulBeanToCsvBuilder(writer)
															.withSeparator(';')
															.build();
			beanToCsv.write(investimentos);
			
	        writer.flush();
	        writer.close();

		} catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
			e.printStackTrace();
		}
		
		return "";
	}

	public List<Investimento> buscar() {
		return investimentoDao.buscar();
	}
	
	public List<InvestimentoDTO> buscarPorTipo() {
		return investimentoDao.buscarPorTipo();
	}
	
	public Investimento buscarPorId(Investimento investimento) {
		return investimentoDao.buscarPorId(investimento);
	}

	public Investimento excluir(Investimento investimento) {
		return investimentoDao.excluir(investimento);
		
	}

}
