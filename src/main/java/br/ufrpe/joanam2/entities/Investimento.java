package br.ufrpe.joanam2.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Investimento {
	private Integer id;
	private int tipo;
	private BigDecimal montante;
	private BigDecimal valorRendimento;
	private String indice;
	private int prazoResgate;
	private LocalDate dataInvestimento;
	private BigDecimal montanteResgatado;
	
	public Investimento() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getMontante() {
		return montante;
	}

	public void setMontante(BigDecimal montante) {
		this.montante = montante;
	}

	public BigDecimal getValorRendimento() {
		return valorRendimento;
	}

	public void setValorRendimento(BigDecimal valorRendimento) {
		this.valorRendimento = valorRendimento;
	}

	public String getIndice() {
		return indice;
	}

	public void setIndice(String indice) {
		this.indice = indice;
	}

	public int getPrazoResgate() {
		return prazoResgate;
	}

	public void setPrazoResgate(int prazoResgate) {
		this.prazoResgate = prazoResgate;
	}

	public LocalDate getDataInvestimento() {
		return dataInvestimento;
	}

	public void setDataInvestimento(LocalDate dataInvestimento) {
		this.dataInvestimento = dataInvestimento;
	}

	public BigDecimal getMontanteResgatado() {
		return montanteResgatado;
	}

	public void setMontanteResgatado(BigDecimal montanteResgatado) {
		this.montanteResgatado = montanteResgatado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Investimento other = (Investimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
