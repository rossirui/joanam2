package br.ufrpe.joanam2.model;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

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

	
	private String Investimento2String(Investimento investimento) {
		return investimento.toString();
	}
	
	public String exportarCSV2() {
		List<Investimento> investimentos = buscar();

		return "";
	}
	
	public String exportarCSV() {
		List<Investimento> investimentos = buscar();
		
		try {
			Writer writer = Files.newBufferedWriter(Paths.get("C:\\Users\\ruiro\\Documents\\Rui\\investimentos.csv"));
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

	public Investimento excluir(Investimento investimento) {
		return investimentoDao.excluir(investimento);
		
	}

}
