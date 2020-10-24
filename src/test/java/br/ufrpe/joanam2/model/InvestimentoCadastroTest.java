package br.ufrpe.joanam2.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import br.ufrpe.joanam2.model.entity.Investimento;

public class InvestimentoCadastroTest {

	public static InvestimentoCadastro invCadastro = InvestimentoCadastro.getInstance();
	public Investimento investimento = new Investimento(null, 2, new BigDecimal(0.2), new BigDecimal(500.2), "naosei", 90, new Date(0), new BigDecimal(20000.2));
	
	@Test
	public void salvarBucarExcluirTeste() {
		Investimento investimentoSalvo = invCadastro.salvar(investimento);		
		Investimento investimentoRetornado = invCadastro.buscarPorId(investimentoSalvo);
		
		assertEquals(investimentoSalvo, investimentoRetornado);
		
		Investimento investimentoExcluido = invCadastro.excluir(investimentoSalvo);
		assertEquals(investimentoSalvo, investimentoExcluido);
		
	}

}
